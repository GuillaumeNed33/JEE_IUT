package bdx.iut.info.persistence.dao;

import bdx.iut.info.persistence.domain.Receipe;
import com.google.inject.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgiot on 06/02/17.
 *
 */
public class ReceipeDao {
    /**.
     * entityManager
     */
    private Provider<EntityManager> entityManager;

    /**.
     * Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(IngredientDao.class);

    /**
     * Create a receipe.
     * @param r .
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
     * Find a receipe with her id.
     * @param id .
     * @return Receipe
     */
    public Receipe read(final Long id) {
        return this.entityManager.get().find(Receipe.class, id);
    }

    /**
     * Update a receipe.
     * @param t .
     * @return Receipe
     */
    public Receipe update(final Receipe t) {
        return this.entityManager.get().merge(t);
    }

    /**
     * Delete a receipe.
     * @param t .
     */
    public void delete(final Receipe t) {
        this.entityManager.get().remove(this.entityManager.get().merge(t));
    }

    /**.
     * Find All receipes.
     * @return List<Receipe>
     */
    public List<Receipe> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Receipe.class.getName());
        List<Receipe> receipes =
                this.entityManager.get().createQuery(query.toString())
                        .getResultList();
        LOGGER.debug("{} receipes found", receipes);
        return receipes;
    }

    /**.
     * Find a Receipe with her name
     * @param name .
     * @return List<Receipe>
     */
    public List<Receipe> findByName(final String name) {
        List<Receipe> receipesFound = new ArrayList<Receipe>();
        for (Receipe s : findAll()) {
            if (s.getTitle().contains(name)) {
                receipesFound.add(s);
            }
        }
        return receipesFound;
    }

}
