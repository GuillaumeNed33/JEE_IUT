package fr.iut;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@WebServlet(name = "room", urlPatterns = {"/room"})
public class RoomServlet extends HttpServlet {

    private ArrayList<Room>fakeRooms = new ArrayList<Room>();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        loadRooms();
        Template freemarkerTemplate = null;
        freemarker.template.Configuration freemarkerConfiguration =
                new freemarker.template.Configuration();
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/");
        freemarkerConfiguration.setObjectWrapper(new DefaultObjectWrapper());
        try {
            freemarkerTemplate = freemarkerConfiguration.getTemplate("templates/listRoom.ftl");
        } catch (IOException e) {
            System.out.println("Unable to process request,error during freemarker template retrieval."); }
        Map<String, Object> root = new HashMap<String, Object>();
// navigation data and links
        root.put("title", "freemarker Servlet - Room");
        root.put("fakeRooms", fakeRooms);
        PrintWriter out = response.getWriter();
        assert freemarkerTemplate != null;
        try {
            freemarkerTemplate.process(root, out);
            out.close();}
        catch (TemplateException e) { e.printStackTrace(); }
// set mime type
        response.setContentType("text/html");
    }

    private void loadRooms() {
        fakeRooms.clear();
        Room r = new Room("room1", 25, 30);
        Room r2 = new Room("room2", 0, 100);
        Room r3 = new Room("room3", 6, 60);
        Room r4 = new Room("room4", 25, 20);
        Room r5 = new Room("room555", 10, 10);
        fakeRooms.add(r);
        fakeRooms.add(r2);
        fakeRooms.add(r3);
        fakeRooms.add(r4);
        fakeRooms.add(r5);
    }

}
