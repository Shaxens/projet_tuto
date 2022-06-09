package fr.tradflex.ressource;

import fr.tradflex.dao.ProjectDAO;
import fr.tradflex.dao.SousTitreDAO;
import fr.tradflex.model.Project;
import fr.tradflex.model.ProjectWhenCreating;
import fr.tradflex.model.SousTitre;
import fr.tradflex.model.SousTitreWhenCreating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SousTitreRessource {
    private final SousTitreDAO sousTitreDAO;
    private static final Logger LOG = LoggerFactory.getLogger(ProjectRessource.class);

    private record SousTitreAsId(int id, String url) {
        SousTitreAsId(SousTitre sousTitre) {
            this(sousTitre.id(), "localhost:8080/sousTitre/"+sousTitre.id());
        }
    }
    @Autowired
    public SousTitreRessource(SousTitreDAO sousTitreDAO) {
        this.sousTitreDAO = sousTitreDAO;
    }

    @GetMapping(path = "/sousTitre/{id}")
    public SousTitre getSousTitre(@PathVariable(name = "id") int id) {
        return Optional.ofNullable(sousTitreDAO.getById(id))
                .orElseThrow(ProjectRessource.ResourceNotFoundException::new);
    }

    @GetMapping(path = "/sousTitre")
    public List<SousTitreAsId> getSousTitres() {
        return sousTitreDAO.getAll().stream()
                .map(SousTitreAsId::new)
                .toList();
    }

    @PostMapping("/sousTitre")
    public boolean createSousTitre(@RequestBody SousTitreWhenCreating sousTitre) {
        return sousTitreDAO.create(sousTitre);
    }

    @DeleteMapping("/sousTitre/{id}")
    public boolean deleteProject(@PathVariable(name = "id") int id)
    {
        return sousTitreDAO.delete(id);
    }

    @PutMapping("/sousTitre")
    public SousTitre updateSousTitre(@RequestBody SousTitre sousTitre)
    {
        return sousTitreDAO.update(sousTitre);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {}
}
