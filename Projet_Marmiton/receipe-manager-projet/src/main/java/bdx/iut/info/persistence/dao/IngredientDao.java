package bdx.iut.info.persistence.dao;

import bdx.iut.info.persistence.domain.Ingredient;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by rgiot on 06/02/17.
 */
@Singleton
public class IngredientDao {
    /**
     *
     */
    @Inject
    private Provider<EntityManager> entityManager;

    /**
     *
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(IngredientDao.class);

    /**
     *
     * @param t
     * @return Ingredient
     */
    @Transactional
    public Ingredient create(final Ingredient t) {
        LOGGER.info("Try to save " + toString());
        LOGGER.info("Entity Manager" + this.entityManager);
        LOGGER.info("Entity Manager.get" + this.entityManager.get());
        this.entityManager.get().persist(t);
        LOGGER.info("Saved as " + t.getId());
        return t;
    }

    /**
     *
     * @param id
     * @return Ingredient
     */
    @Transactional
    public Ingredient read(Long id) {
        return this.entityManager.get().find(Ingredient.class, id);
    }

    /**
     *
     * @param t
     * @return Ingredient
     */
    @Transactional
    public Ingredient update(Ingredient t) {
        return this.entityManager.get().merge(t);
    }

    /**
     *
     * @param t
     */
    @Transactional
    public void delete(Ingredient t) {
        t = this.entityManager.get().merge(t);
        this.entityManager.get().remove(t);
    }

    /**
     *
     * @return
     */
    public List<Ingredient> findAll() {

        StringBuilder query = new StringBuilder("from ");
        query.append(Ingredient.class.getName());
        List<Ingredient> ingredients = this.entityManager.get().createQuery(query.toString()).getResultList();
        LOGGER.debug("{} ingredients found", ingredients);
        return ingredients;
    }

    /**
     *
     * @param name
     * @return Ingredient
     */
    public Ingredient findByName(String name) {
        //TODO Implement
        return null;
    }

    /**
     * Count the number of times the ingredient is used in various receipes.
     * The count number is obtained thanks to a JPQL query
     * @param ing Ingredient of interest
     * @return Number of times the ingredient of interest has been used
     */
    public Integer countUsagesInReceipes(Ingredient ing) {
        return (Integer)this.entityManager.get().createQuery("").getResultList().get(0);
    }

}
