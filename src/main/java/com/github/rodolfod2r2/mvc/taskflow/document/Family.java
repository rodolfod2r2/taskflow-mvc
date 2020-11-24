package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Family")
@Getter
@Setter
public class Family extends AbstractDocumentModel {

    private String name;
    private String description;

}
