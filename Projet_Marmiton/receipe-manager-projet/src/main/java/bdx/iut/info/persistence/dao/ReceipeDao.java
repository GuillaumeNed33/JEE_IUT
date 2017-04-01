package bdx.iut.info.persistence.dao;

import bdx.iut.info.persistence.domain.Receipe;
import com.google.inject.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by rgiot on 06/02/17.
 *
 */
public class ReceipeDao {
    /**
     *
     */
    private Provider<EntityManager> entityManager;

    /**
     *
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(IngredientDao.class);

    /**
     *
     * @param r
     * @return Receipe
     */
    public Receipe create(final Receipe r) {
        LOGGER.info("Try to save " + toString());
        LOGGER.info("Entity Manager" + this.entityManager);
        LOGGER.info("Entity Manager.get" + this.entityManager.get());
        this.entityManager.get().persist(r);
        LOGGER.info("Saved as " + r.getId());
        return r;
    }

    /**
     *
     * @param id
     * @return Receipe
     */
    public Receipe read(final Long id) {
        return this.entityManager.get().find(Receipe.class, id);
    }

    /**
     *
     * @param t
     * @return Receipe
     */
    public Receipe update(final Receipe t) {
        return this.entityManager.get().merge(t);
    }

    /**
     *
     * @param t
     */
    public void delete(final Receipe t) {
        this.entityManager.get().remove(this.entityManager.get().merge(t));
    }

    /**
     *
     * @return List<Receipe>
     */
    public List<Receipe> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Receipe.class.getName());
        List<Receipe> receipes =
                this.entityManager.get().createQuery(query.toString())
                        .getResultList();
        LOGGER.debug("{} ingredients found", receipes);
        return receipes;
    }

    /**
     *
     * @param name
     * @return List<Receipe>
     */
    public List<Receipe> findByName(final String name) {
        // TODO implement
        return null;
    }

}
