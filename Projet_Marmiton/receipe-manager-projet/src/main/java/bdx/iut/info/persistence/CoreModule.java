package bdx.iut.info.persistence;

import bdx.iut.info.persistence.dao.IngredientDao;
import bdx.iut.info.persistence.dao.ReceipeDao;
import com.google.inject.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rgiot on 06/02/17.
 *
 * Binds the objets necerray for the DAO stuff.
 * To ease the work, we do not work with inmplementations/interfaces
 */
public class CoreModule extends AbstractModule {
    /**.
     * Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CoreModule.class);

    /**.
     * Configuration file
     */
    @Override
    protected void configure() {
        LOGGER.info("CoreModule configuration started...");

        LOGGER.info("Install Ingredient Dao");
        bind(IngredientDao.class);


        LOGGER.info("Install Ingredient ReceipeDao");
        bind(ReceipeDao.class);

        LOGGER.info("CoreModule configuration ended.");
    }
}
