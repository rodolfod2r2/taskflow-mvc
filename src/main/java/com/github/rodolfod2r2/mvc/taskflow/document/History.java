package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "History")
@Getter
@Setter
public class History extends AbstractDocumentModel {

    private User user;
    private String action;
    private Date dateAction;

}
