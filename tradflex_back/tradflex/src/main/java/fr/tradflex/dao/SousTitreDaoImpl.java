package fr.tradflex.dao;

import fr.tradflex.model.SousTitre;
import fr.tradflex.model.SousTitreWhenCreating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component
public final class SousTitreDaoImpl implements SousTitreDAO {

    private final ConnexionDbDAO connection;

    @Autowired
    public SousTitreDaoImpl(ConnexionDbDAO connection) {this.connection = connection;}

    @Override
    SousTitre getById(int id)
    {

    }

    Collection<SousTitre> getAll()
    {

    }

    SousTitre create(SousTitreWhenCreating sousTitre)
    {

    }

    SousTitre update(SousTitre sousTitre)
    {

    }

    boolean delete(int id)
    {
        return true;
    }
}
