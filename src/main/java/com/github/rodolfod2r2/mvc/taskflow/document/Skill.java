package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Remark")
@Getter
@Setter
public class Skill extends AbstractDocumentModel {

    private String name;
    private int level;
    private User user;

}
