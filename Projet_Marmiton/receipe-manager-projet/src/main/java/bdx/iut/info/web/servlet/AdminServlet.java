package bdx.iut.info.web.servlet;

import bdx.iut.info.persistence.dao.IngredientDao;
import bdx.iut.info.persistence.dao.ReceipeDao;
import bdx.iut.info.persistence.domain.Ingredient;
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
import java.util.Map;

@Singleton
public class
AdminServlet extends HttpServlet {
    /**.
     *
     */
    private static final String BOOTFREE_TEMPLATE = "templates/admin.ftl";
    /**.
     * constant for UTF-8 *
     */
    private static final String TEMPLATE_ENCODING = "UTF-8";
    /**
     *
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(AdminServlet.class);
    /**
     *
     */
    @Inject
    private IngredientDao ingredientDao;
    /**
     *
     */
    @Inject
    private ReceipeDao receipeDao;

    /**
     *
     * @param req
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(final HttpServletRequest req,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        // Configure the objets to give to freemarker
        Map<String, Object> root = new HashMap<String, Object>();
        ArrayList<Receipe> receipes = new ArrayList<Receipe>();
        receipes = (ArrayList<Receipe>)receipeDao.findAll();
        root.put("receipes",receipes);
        if (req.getParameter("action") != null && req.getParameter("action").equals("deleteReceipe")) {
            receipeDao.delete(receipes.get(Integer.parseInt(req.getParameter("indexReceipe"))));
        }


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