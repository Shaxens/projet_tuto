package fr.tradflex.model.project;

import java.util.stream.Stream;

public enum ProjectStatus {
    EN_COURS(1),
    TERMINE(2),
    ABANDONNE(3);

    private final int id;

    ProjectStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ProjectStatus of(int id) {
        return Stream.of(values())
                .filter(status -> status.id == id)
                .findFirst()
                .orElseThrow();
    }
}
