package fr.tradflex.model;

import java.io.Serializable;

public record Project(String id, String name, String description, String picture, ProjectStatus status) implements Serializable {

    public Project(String id, String name, String description, String picture, int status) {
        this(id, name, description, picture, ProjectStatus.of(status));
    }
}
