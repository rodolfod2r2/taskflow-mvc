package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
public class History {

    @Id
    private String id;
    private User user;
    private String action;
    private Date dateAction;

}
