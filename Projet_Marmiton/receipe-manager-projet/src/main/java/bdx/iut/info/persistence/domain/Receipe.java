package bdx.iut.info.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgiot on 06/02/17.
 */
@Entity
public class Receipe  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private java.lang.String title;

    @NotNull
    private Integer preparationTime;
    private Integer cookTime;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    @NotNull
    private List<Step> steps;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection
    @NotNull
    private List<IngredientQuantity> ingredients;


    public Receipe() {
        steps = new ArrayList<Step>();
        ingredients = new ArrayList<IngredientQuantity>();
    }

    public void addIngredient(Ingredient ingredient, double quantity, String unitType) {
       IngredientQuantity i = new IngredientQuantity();
       i.setIngredient(ingredient);
       i.setQuantity(quantity);
       i.setUnit(unitType);
       ingredients.add(i);
    }

    public void addInstruction(Step step) {
        steps.add(step);
    }


    public void removeInstruction(Integer pos) {
        steps.remove(pos.intValue());
    }

    public void removeIngredient(Integer pos) {
        ingredients.remove(pos.intValue());
    }


    public int nbSteps() {return getSteps().size();}
    public int nbIngredients() {return getIngredients().size();}

    // Automatically generated code
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<IngredientQuantity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientQuantity> ingredients) {
        this.ingredients = ingredients;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        String txt = "";
        txt += getTitle() + "\n";
        txt += "Préparation : " + getPreparationTime() + "\n";
        txt += "Cuisson :" + getCookTime() + "\n";
        txt += "Ingredients :" + "\n";
        for(IngredientQuantity ingredient: getIngredients()) {
            txt += ingredient.toString() + "\n";
        }
        txt += "Instructions" + "\n";
        for(Step step : getSteps()) {
            txt += step.toString() + "\n";
        }
        return txt;
    }
}