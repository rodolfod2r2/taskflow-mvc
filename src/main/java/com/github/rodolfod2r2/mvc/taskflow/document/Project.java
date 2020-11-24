package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;

@Document
@Getter
@Setter
public class Project extends AbstractDocumentModel {

    private String name;
    private String description;
    private Date dtIni;
    private Date dtEnd;
    private User user;
    private Archive archive;
    private Collection<Team> teamCollection;
    private Collection<Task> taskCollection;

}
