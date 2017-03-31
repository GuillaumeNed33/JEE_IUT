package bdx.iut.info.persistence.domain;


import bdx.iut.info.persistence.constraints.IsStep;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Step implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @IsStep
    private String stepText;

    private String base64Image;

    // Automatically generated code

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStepText() {
        return stepText;
    }

    public void setStepText(String stepText) {
        this.stepText = stepText;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }


    @Override
    public String toString() {
        return stepText;
    }
}
