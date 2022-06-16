package fr.tradflex.process.sousTitre;

import fr.tradflex.dao.ProjectDAO;
import fr.tradflex.model.sousTitre.SousTitre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SecurityWhenSousTitreCreatingOrUpdating {
    private final ProjectDAO projectDAO;

    @Autowired
    public SecurityWhenSousTitreCreatingOrUpdating(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public boolean isPossible(double timeCodeBegin, double timeCodeEnd, int idProject)
    {
        Collection<SousTitre> sousTitres = projectDAO.getAllSousTitre(idProject);
        // TODO à compléter

        return true;
    }

}
