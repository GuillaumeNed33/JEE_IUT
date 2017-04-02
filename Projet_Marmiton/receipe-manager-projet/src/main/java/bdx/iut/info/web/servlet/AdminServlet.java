package bdx.iut.info.web.servlet;

import bdx.iut.info.persistence.dao.IngredientDao;
import bdx.iut.info.persistence.dao.ReceipeDao;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class
AdminServlet extends HttpServlet {
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

    }

}