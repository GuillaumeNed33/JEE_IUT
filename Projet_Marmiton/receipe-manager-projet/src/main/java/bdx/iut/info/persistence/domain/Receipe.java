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
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     *
     */
    @NotNull
    private java.lang.String title;
    /**
     *
     */
    @NotNull
    private Integer preparationTime;
    /**
     *
     */
    private Integer cookTime;

    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    @NotNull
    private List<Step> steps;
    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    @NotNull
    private List<IngredientQuantity> ingredients;

    /**
     *
     */
    public Receipe() {
        steps = new ArrayList<Step>();
        ingredients = new ArrayList<IngredientQuantity>();
    }

    /**
     *
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
     *
     * @param step .
     */
    public void addInstruction(final Step step) {
        steps.add(step);
    }

    /**
     *
     * @param pos .
     */
    public void removeInstruction(final Integer pos) {
        steps.remove(pos.intValue());
    }

    /**
     *
     * @param pos .
     */
    public void removeIngredient(final Integer pos) {
        ingredients.remove(pos.intValue());
    }

    /**
     *
     * @return int
     */
    public int nbSteps() {
        return getSteps().size();
    }

    /**
     *
     * @return int
     */
    public int nbIngredients() {
        return getIngredients().size();
    }

    // Automatically generated code

    /**
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     *
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
