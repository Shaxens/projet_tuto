package fr.tradflex.ressource;

import fr.tradflex.dao.ProjectDAO;
import fr.tradflex.dao.ProjectDAOImpl;
import fr.tradflex.model.Project;
import fr.tradflex.model.ProjectWhenCreating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Représente l'ensemble des API des REST liée à un ou des {@link Project}.
 */
@RestController
public class ProjectRessource {

    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectRessource(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @GetMapping(path = "/project/{id}")
    public Project getProject(@PathVariable(name = "id") String id) {
        return Optional.ofNullable(projectDAO.getById(id))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping(path = "/project")
    public List<ProjectAsId> getProjects() {
        return projectDAO.getAll().stream()
                .map(ProjectAsId::new)
                .toList();
    }

    @PostMapping("/project")
    public Project createProject(@RequestBody ProjectWhenCreating project) {
        return projectDAO.create(project);
    }

    @DeleteMapping("/project/{id}")
    public boolean deleteProject(@PathVariable(name = "id") String id)
    {
        return projectDAO.delete(id);
    }

    @PutMapping("/project")
    public Project updateProject(@RequestBody Project project)
    {
        return projectDAO.update(project);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {}


    private record ProjectAsId(String id, String url) {
        ProjectAsId(Project project) {
            this(project.id(), "localhost:8080/project/"+project.id());
        }
    }
}