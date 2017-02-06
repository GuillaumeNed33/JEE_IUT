package bean;

import javax.print.Doc;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Thomas on 04/02/2017.
 */
public class DueDocument extends Document {

    @NotNull
    Date dueDate;

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
