package bdx.iut.info.persistence.domain;


import bdx.iut.info.persistence.constraints.IsStep;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 */
@Entity
public class Step implements Serializable {
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
    @IsStep
    private String stepText;
    /**
     *
     */
    private String base64Image;

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
     * @return String
     */
    public String getStepText() {
        return stepText;
    }

    /**
     *
     * @param stepText2 .
     */
    public void setStepText(final String stepText2) {
        this.stepText = stepText2;
    }

    /**
     *
     * @return String
     */
    public String getBase64Image() {
        return base64Image;
    }

    /**
     *
     * @param base64Image2 .
     */
    public void setBase64Image(final String base64Image2) {
        this.base64Image = base64Image2;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return stepText;
    }
}
