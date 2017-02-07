package bean;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Thomas on 04/02/2017.
 */
public class Document {
    @NotNull
    String title;
    String content;
    @NotNull
    Date creationDate;
    @Future
    Date lastModification;

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }
}
