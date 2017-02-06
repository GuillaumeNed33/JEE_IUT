package bean;

import javax.print.Doc;
import java.util.Date;

/**
 * Created by Thomas on 04/02/2017.
 */
public class DueDocument extends Document {
    Date dueDate;

    public DueDocument(String title, String content, Date creationDate, Date lastModification, Date dueDate) {
        super(title, content, creationDate, lastModification);
        this.dueDate = dueDate;
    }
}
