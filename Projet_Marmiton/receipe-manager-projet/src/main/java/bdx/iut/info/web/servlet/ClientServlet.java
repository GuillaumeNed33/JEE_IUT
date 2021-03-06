package bdx.iut.info.web.servlet;

import bdx.iut.info.persistence.dao.ReceipeDao;
import bdx.iut.info.persistence.domain.Receipe;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by rgiot on 12/02/17.
 */
@Singleton
public class ClientServlet extends HttpServlet {
    /**.
     *
     */
    private static final String BOOTFREE_TEMPLATE = "templates/client.ftl";
    /**.
     * constant for UTF-8 *
     */
    private static final String TEMPLATE_ENCODING = "UTF-8";
    /**.
     * Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ClientServlet.class);
    /**.
     *
     */
    @Inject
    private ReceipeDao receipeDao;

    /**
     *
     * @param req .
     * @param response .
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(final HttpServletRequest req,
                         final HttpServletResponse response)
            throws ServletException, IOException {


        // Configure the objets to give to freemarker
        Map<String, Object> root = new HashMap<String, Object>();

        List<Receipe> receipes = new ArrayList<Receipe>();
        Receipe r = new Receipe();
        r.setTitle("poche");
        receipes.add(r);
        root.put("receipes", receipes);
        if (req.getParameter("action") != null
                &&
                req.getParameter("action").equals("searchByReceipeName")) {
            receipes = receipeDao.findByName(req.getParameter("receipeName"));
            root.put("receipes", receipes);
        }



        // Manage freemarker stuff
        Template freemarkerTemplate = null;
        freemarker.template.Configuration freemarkerConfiguration =
                new freemarker.template.Configuration();
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(),
                "/");
        freemarkerConfiguration.setObjectWrapper(new DefaultObjectWrapper());
        try {
            freemarkerTemplate = freemarkerConfiguration.getTemplate(
                    BOOTFREE_TEMPLATE, TEMPLATE_ENCODING);

        } catch (IOException e) {
            LOGGER.error(
                    "Unable to process request, "
                            +
                            "error during freemarker template retrieval.", e);
        }

        // navigation data and links
        root.put("title", "Java EE - Recettes - v0.1");

        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        assert freemarkerTemplate != null;
        try {
            freemarkerTemplate.process(root, out);
            out.close();
        } catch (TemplateException e) {
            LOGGER.error("Error during template processing", e);
        }

        // set mime type
        response.setContentType("text/html");
    }
}
