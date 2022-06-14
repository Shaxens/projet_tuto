package fr.tradflex.dao;

import fr.tradflex.model.project.Project;
import fr.tradflex.model.project.ProjectWhenCreating;
import fr.tradflex.model.sousTitre.SousTitre;

import java.util.Collection;

public interface ProjectDAO {

    Project getById(String id);

    Collection<Project> getAll();

    Collection<SousTitre> getAllSousTitre(int idProject);

    Project create(ProjectWhenCreating project);

    Project update(Project project);

    boolean delete(String id);
}