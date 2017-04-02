package bdx.iut.info.persistence.dao;

import bdx.iut.info.persistence.domain.Ingredient;
import bdx.iut.info.persistence.domain.IngredientQuantity;
import bdx.iut.info.persistence.domain.IngredientQuantity_;
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
     * @param t .
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
     * @param id .
     * @return Ingredient
     */
    @Transactional
    public Ingredient read(final Long id) {
        return this.entityManager.get().find(Ingredient.class, id);
    }

    /**
     *
     * @param t .
     * @return Ingredient
     */
    @Transactional
    public Ingredient update(final Ingredient t) {
        return this.entityManager.get().merge(t);
    }

    /**
     *
     * @param t .
     */
    @Transactional
    public void delete(final Ingredient t) {
        this.entityManager.get().remove(this.entityManager.get().merge(t));
    }

    /**
     *
     * @return List<Ingredient>
     */
    public List<Ingredient> findAll() {

        StringBuilder query = new StringBuilder("from ");
        query.append(Ingredient.class.getName());
        List<Ingredient> ingredients =
                this.entityManager.get().createQuery(query.toString())
                        .getResultList();
        LOGGER.debug("{} ingredients found", ingredients);
        return ingredients;
    }

    /**
     *
     * @param name .
     * @return Ingredient
     */
    public Ingredient findByName(final String name) {
        List<Ingredient> ingredients = findAll();
        Ingredient ingredientFound = null;
        for (Ingredient ingredient : ingredients)
        {
            if(ingredient.getName().equals(name))
            {
                ingredientFound = ingredient;
            }
        }
        return ingredientFound;
    }

    /**
     * Count the number of times the ingredient is used in various receipes.
     * The count number is obtained thanks to a JPQL query
     * @param ing Ingredient of interest
     * @return Number of times the ingredient of interest has been used
     */
    @Transactional
    public Integer countUsagesInReceipes(final Ingredient ing) {

        StringBuilder query = new StringBuilder("from ");
        query.append(IngredientQuantity.class.getName()).append(" as IngredientQuantity");
        query.append(" where ingredientquantity.").append(IngredientQuantity_.ingredient.getName())
                .append(" = :ingredient");

        List<IngredientQuantity> result = entityManager.get().createQuery(query.toString())
                .setParameter("ingredient", ing).getResultList();
        int sum = 0;
        for (IngredientQuantity i : result) {
            sum += i.getQuantity();
        }
        LOGGER.debug("Ingredient  with name '{}' used '{}' times", ing.getName(), sum);
        return sum;

    }

}
