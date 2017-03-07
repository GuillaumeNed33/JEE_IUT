package bdx.iut.info.persistence.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by rgiot on 06/02/17.
 * TODO Add the Entities annotations
 */
public class Ingredient implements Serializable{
    private long id;

    private java.lang.String name;

    private UnitType unitType;

    public Ingredient() {
        name = "";
        unitType = UnitType.weight;
    }



    // Automatically generated code


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }


}