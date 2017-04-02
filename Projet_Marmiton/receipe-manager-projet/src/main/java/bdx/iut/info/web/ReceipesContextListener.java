package bdx.iut.info.web;

import bdx.iut.info.persistence.CoreModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;


/**
 * Created by rgiot on 06/02/17.
 */
@WebListener
public class ReceipesContextListener extends GuiceServletContextListener {
    /**.
     * Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ReceipesContextListener.class);

    /**
     *
     * @return Injector
     */
    @Override
    protected final Injector getInjector() {
        LOGGER.info("Injector creation asked");
        Injector injector = Guice.createInjector(
                new CoreModule(),
                new WebModule()
                );
        LOGGER.info("Injector created");
        return injector;
    }
}
