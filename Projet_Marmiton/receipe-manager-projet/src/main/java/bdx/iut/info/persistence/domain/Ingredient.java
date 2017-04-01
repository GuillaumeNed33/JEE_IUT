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
    /**
     *
     */
    private java.lang.String name;
    /**
     *
     */
    private UnitType unitType;

    /**
     *
     */
    public Ingredient() {
        name = "";
        unitType = UnitType.weight;
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
     * @param id2
     */
    public void setId(final long id2) {
        this.id = id2;
    }

    /**
     *
     * @return String
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     *
     * @param name2
     */
    public void setName(final java.lang.String name2) {
        this.name = name2;
    }

    /**
     *
     * @return UnitType
     */
    public UnitType getUnitType() {
        return unitType;
    }

    /**
     *
     * @param unitType2
     */
    public void setUnitType(final UnitType unitType2) {
        this.unitType = unitType2;
    }


}
