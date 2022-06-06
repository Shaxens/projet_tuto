package fr.tradflex.dao;

import fr.tradflex.model.Project;
import fr.tradflex.model.ProjectWhenCreating;

import java.util.Collection;

public interface ProjectDAO {

    Project getById(int id);

    Collection<Project> getAll();

    Project create(ProjectWhenCreating project);

    Project update(Project project);

    void delete(String id);
}