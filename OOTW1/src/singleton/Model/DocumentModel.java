package singleton.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.text.Document;
import java.io.Serializable;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class DocumentModel implements Serializable {

    @Id
    @GeneratedValue
    public int documentId;

        public Document document;

    public String author;

    @Temporal(TemporalType.TIMESTAMP)
    public Timestamp updateTime;

    public DocumentModel(Document document, String author){
        this.document = document;
        this.author = author;
    }


}
