package bdx.iut.info.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgiot on 06/02/17.
 */
@Entity
public class Receipe  implements Serializable {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * Title.
     */
    @NotNull
    private java.lang.String title;
    /**
     * preparationTime.
     */
    @NotNull
    private Integer preparationTime;
    /**
     * cookTime.
     */
    private Integer cookTime;

    /**
     * List of the receipe steps.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    @NotNull
    private List<Step> steps;
    /**
     * List of Ingredients.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    @NotNull
    private List<IngredientQuantity> ingredients;

    /**
     * Constructor.
     */
    public Receipe() {
        steps = new ArrayList<Step>();
        ingredients = new ArrayList<IngredientQuantity>();
    }

    /**
     * add an ingredient.
     * @param ingredient .
     * @param quantity .
     * @param unitType .
     */
    public void addIngredient(final Ingredient ingredient,
                              final double quantity, final String unitType) {
        IngredientQuantity i = new IngredientQuantity();
        i.setIngredient(ingredient);
        i.setQuantity(quantity);
        i.setUnit(unitType);
        ingredients.add(i);
    }

    /**
     * add a step in a receipe.
     * @param step .
     */
    public void addInstruction(final Step step) {
        steps.add(step);
    }

    /**
     * remove a step.
     * @param pos .
     */
    public void removeInstruction(final Integer pos) {
        steps.remove(pos.intValue());
    }

    /**
     * remove an ingredient.
     * @param pos .
     */
    public void removeIngredient(final Integer pos) {
        ingredients.remove(pos.intValue());
    }

    /**
     * count steps.
     * @return int
     */
    public int nbSteps() {
        return getSteps().size();
    }

    /**
     * count ingredients.
     * @return int
     */
    public int nbIngredients() {
        return getIngredients().size();
    }

    // Automatically generated code

    /**
     * return id.
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * change id.
     * @param id2 .
     */
    public void setId(final long id2) {
        this.id = id2;
    }

    /**
     *
     * @return Integer
     */
    public Integer getPreparationTime() {
        return preparationTime;
    }

    /**
     *
     * @param preparationTime2 .
     */
    public void setPreparationTime(final Integer preparationTime2) {
        this.preparationTime = preparationTime2;
    }

    /**
     *
     * @return Integer
     */
    public Integer getCookTime() {
        return cookTime;
    }

    /**
     *
     * @param cookTime2 .
     */
    public void setCookTime(final Integer cookTime2) {
        this.cookTime = cookTime2;
    }

    /**
     *
     * @return List<Step>
     */
    public List<Step> getSteps() {
        return steps;
    }

    /**
     *
     * @param steps2 .
     */
    public void setSteps(final List<Step> steps2) {
        this.steps = steps2;
    }

    /**
     *
     * @return List<IngredientQuantity>
     */
    public List<IngredientQuantity> getIngredients() {
        return ingredients;
    }

    /**
     *
     * @param ingredients2 .
     */
    public void setIngredients(final List<IngredientQuantity> ingredients2) {
        this.ingredients = ingredients2;
    }

    /**
     *
     * @return String
     */
    public java.lang.String getTitle() {
        return title;
    }

    /**
     *
     * @param title2 .
     */
    public void setTitle(final java.lang.String title2) {
        this.title = title2;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        String txt = "";
        txt += getTitle() + "\n";
        txt += "Préparation : " + getPreparationTime() + "\n";
        txt += "Cuisson :" + getCookTime() + "\n";
        txt += "Ingredients :" + "\n";
        for (IngredientQuantity ingredient: getIngredients()) {
            txt += ingredient.toString() + "\n";
        }
        txt += "Instructions" + "\n";
        for (Step step : getSteps()) {
            txt += step.toString() + "\n";
        }
        return txt;
    }
}
