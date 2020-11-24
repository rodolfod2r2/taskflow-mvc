package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Halo")
@Getter
@Setter
public class Halo extends AbstractDocumentModel {

    private String name;
    private String description;

}
