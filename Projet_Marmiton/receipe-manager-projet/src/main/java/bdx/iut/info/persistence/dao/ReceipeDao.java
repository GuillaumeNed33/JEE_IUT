package bdx.iut.info.persistence.dao;

import bdx.iut.info.persistence.domain.Ingredient;
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
private Provider<EntityManager> entityManager;

    private static final Logger logger = LoggerFactory.getLogger(IngredientDao.class);

    public Receipe create(Receipe r) {
        logger.info("Try to save " + toString());
        logger.info("Entity Manager" + this.entityManager);
        logger.info("Entity Manager.get" + this.entityManager.get());
        this.entityManager.get().persist(r);
        logger.info("Saved as " + r.getId());
        return r;
    }

    public Receipe read(Long id) {
        return this.entityManager.get().find(Receipe.class, id);
    }

    public Receipe update(Receipe t) {
        return this.entityManager.get().merge(t);
    }

    public void delete(Receipe t) {
        t = this.entityManager.get().merge(t);
        this.entityManager.get().remove(t);
    }

    public List<Receipe> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Receipe.class.getName());
        List<Receipe> receipes = this.entityManager.get().createQuery(query.toString()).getResultList();
        logger.debug("{} ingredients found", receipes);
        return receipes;
    }


    public List<Receipe> findByName(final String name) {
        // TODO implement
        return null;
    }

}
