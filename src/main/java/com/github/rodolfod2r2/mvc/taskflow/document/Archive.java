package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Archive")
@Getter
@Setter
public class Archive extends AbstractDocumentModel {

    private String path;
    private String name;

}


