package bdx.iut.info.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by rgiot on 06/02/17.
 */
@Entity
public class IngredientQuantity  implements Serializable {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * Ingredient.
     */
    @NotNull
    @ManyToOne
    private Ingredient ingredient;
    /**
     * unit.
     */
    @NotNull
    private String unit;

    /**
     * quantity.
     */
    @NotNull
    private double quantity;

    // Automatically generated code

    /**
     * return the id.
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * change the id.
     * @param id2 .
     */
    public void setId(final long id2) {
        this.id = id2;
    }

    /**
     * return Ingredient.
     * @return Ingredient
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * change Ingredient.
     * @param ingredient2 .
     */
    public void setIngredient(final Ingredient ingredient2) {
        this.ingredient = ingredient2;
    }

    /**
     * return quantity.
     * @return double
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * change quantity.
     * @param quantity2 .
     */
    public void setQuantity(final double quantity2) {
        this.quantity = quantity2;
    }

    /**
     * return unit.
     * @return String
     */
    public String getUnit() {
        return unit;
    }

    /**
     * change unit.
     * @param unit2 .
     */
    public void setUnit(final String unit2) {
        this.unit = unit2;
    }

    /**
     * Return informations in a string.
     * @return String
     */
    @Override
    public String toString() {
        return ingredient.getName() + ": " + quantity +  " " + unit;

    }
}
