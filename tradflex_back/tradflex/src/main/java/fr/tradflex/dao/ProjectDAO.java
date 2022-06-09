package fr.tradflex.dao;

import fr.tradflex.model.project.Project;
import fr.tradflex.model.project.ProjectWhenCreating;

import java.util.Collection;

public interface ProjectDAO {

    Project getById(String id);

    Collection<Project> getAll();

    Project create(ProjectWhenCreating project);

    Project update(Project project);

    boolean delete(String id);
}