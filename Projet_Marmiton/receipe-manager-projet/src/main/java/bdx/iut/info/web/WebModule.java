package bdx.iut.info.web;

import bdx.iut.info.web.servlet.AdminServlet;
import bdx.iut.info.web.servlet.ClientServlet;
import bdx.iut.info.web.servlet.InitServlet;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fred on 08/03/15.
 */
public class WebModule extends ServletModule {
    /**.
     * Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(WebModule.class);

    /**
     *
     */
    @Override
    protected final void configureServlets() {
        LOGGER.info("WebModule configureServlets started...");
        super.configureServlets();

        install(new JpaPersistModule("receipes-manager"));

        LOGGER.info("install servlet filter");
        filter("/*").through(PersistFilter.class);

        LOGGER.info("Install filters.");

        serve("/admin/init").with(InitServlet.class);
        serve("/").with(ClientServlet.class);
        serve("/admin/main").with(AdminServlet.class);


        LOGGER.info("WebModule configureServlets ended.");
    }
}
