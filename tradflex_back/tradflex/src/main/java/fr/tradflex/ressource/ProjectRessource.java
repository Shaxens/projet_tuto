package fr.tradflex.ressource;

import fr.tradflex.model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Représente l'ensemble des API des REST liée à un ou des {@link Project}.
 */
@RestController
public class ProjectRessource {

    private static final AtomicInteger ID = new AtomicInteger(1);
    private static final List<Project> PROJECTS = new ArrayList<>();

    static {
        PROJECTS.add(new Project(Integer.toString(ID.getAndIncrement()), "toto"));
        PROJECTS.add(new Project(Integer.toString(ID.getAndIncrement()), "tata"));
        PROJECTS.add(new Project(Integer.toString(ID.getAndIncrement()), "tata"));
    }

    @GetMapping(path = "/project/{id}")
    public Project getProject(@PathVariable(name = "id") String id) {
        return PROJECTS.stream()
                .filter(project -> id.equals(project.id()))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping(path = "/project")
    public List<ProjectAsId> getProjects() {
        return PROJECTS.stream().map(ProjectAsId::new).toList();
    }

    @PostMapping("/project")
    public Project createProject(@RequestBody ProjectWhenCreating project) {
        var newProject = new Project(Integer.toString(ID.getAndIncrement()), project.nom());
        PROJECTS.add(newProject);
        return newProject;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {}

    private record ProjectWhenCreating(String nom) {}

    private record ProjectAsId(String id, String url) {
        ProjectAsId(Project project) {
            this(project.id(), "localhost:8080/project/"+project.id());
        }
    }
}
