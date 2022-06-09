package fr.tradflex.dao;

import fr.tradflex.model.SousTitre;
import fr.tradflex.model.SousTitreWhenCreating;

import java.util.Collection;

public interface SousTitreDAO {
    SousTitre getById(int id);

    Collection<SousTitre> getAll();

    SousTitre create(SousTitreWhenCreating sousTitre);

    SousTitre update(SousTitre sousTitre);

    boolean delete(int id);
}
