package singleton.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.SerializationUtils;

import javax.persistence.*;
import javax.swing.text.Document;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class DocumentModel implements Serializable,Cloneable {

    @Id
    @GeneratedValue
    public int documentId;

        public Document document;

    public String author;


    public Date updateTime;

    public Date createdDate;

    public DocumentModel(Document document, String author){
        this.document = document;
        this.author = author;
    }
    @PrePersist
    void updateCreateDates() {
        updateTime = new Date();
        createdDate = updateTime;

    }

    @PreUpdate
    void updateDates() {
        updateTime = new Date();
    }



    @Override
    public DocumentModel clone() {
        try {

            DocumentModel clone = (DocumentModel) super.clone();
            return SerializationUtils.clone(clone);

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
