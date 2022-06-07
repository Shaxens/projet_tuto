package fr.tradflex.dao;

import fr.tradflex.model.Project;
import fr.tradflex.model.ProjectWhenCreating;

import java.sql.SQLException;
import java.util.Collection;

public interface ProjectDAO {

    Project getById(String id);

    Collection<Project> getAll();

    Project create(ProjectWhenCreating project);

    Project update(Project project);

    boolean delete(String id);
}