package fr.tradflex.ressource;

import fr.tradflex.dao.ProjectDAO;
import fr.tradflex.model.project.Project;
import fr.tradflex.model.project.ProjectWhenCreating;
import fr.tradflex.model.sousTitre.SousTitre;
import fr.tradflex.process.parser.SousTitresParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Représente l'ensemble des API des REST liée à un ou des {@link Project}.
 */
@RestController
@CrossOrigin
public class ProjectRessource {

    private final ProjectDAO projectDAO;
    private final SousTitresParser sousTitresParser;
    private static final Logger LOG = LoggerFactory.getLogger(ProjectRessource.class);

    @Autowired
    public ProjectRessource(ProjectDAO projectDAO, SousTitresParser sousTitresParser) {
        this.projectDAO = projectDAO;
        this.sousTitresParser = sousTitresParser;
    }

    @GetMapping(path = "/project/{id}")
    public Project getProject(@PathVariable(name = "id") String id) {
        return Optional.ofNullable(projectDAO.getById(id))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping(path = "/project")
    public Collection<Project> getProjects() {
        return projectDAO.getAll();
    }

    @GetMapping(path = "/project/{id}/sousTitre")
    public Collection<SousTitre> getSousTitres(@PathVariable(name = "id") int id) {
        return projectDAO.getAllSousTitre(id);
    }

    @GetMapping(path = "/project/{id}/sousTitre/srt", produces = {"application/srt"})
    public String getSousTitresAsSrt(@PathVariable(name = "id") int id) {
        return sousTitresParser.parse(getSousTitres(id));
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
            this(project.id(), "http://localhost:8080/project/"+project.id());
        }
    }
}