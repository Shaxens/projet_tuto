package fr.tradflex.dao;

import fr.tradflex.model.sousTitre.SousTitre;
import fr.tradflex.model.sousTitre.SousTitreWhenCreating;

import java.util.Collection;

public interface SousTitreDAO {
    SousTitre getById(int id);

    Collection<SousTitre> getAll();

    boolean create(SousTitreWhenCreating sousTitre);

    SousTitre update(SousTitre sousTitre);

    boolean delete(int id);
}
