package bdx.iut.info.persistence.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 */
@Entity
public class Ingredient implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**.
     * Name of the ingredient.
     */
    private java.lang.String name;
    /**
     * UnitType of the Ingredient.
     */
    private UnitType unitType;

    /**
     * Constructor.
     */
    public Ingredient() {
        name = "";
        unitType = UnitType.weight;
    }



    // Automatically generated code

    /**
     * Return the id.
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * Change Id.
     * @param id2 .
     */
    public void setId(final long id2) {
        this.id = id2;
    }

    /**
     * Return the name.
     * @return String
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * Change the name.
     * @param name2 .
     */
    public void setName(final java.lang.String name2) {
        this.name = name2;
    }

    /**
     * Return the UnitType.
     * @return UnitType
     */
    public UnitType getUnitType() {
        return unitType;
    }

    /**
     * Change the UnitType.
     * @param unitType2 .
     */
    public void setUnitType(final UnitType unitType2) {
        this.unitType = unitType2;
    }


}
