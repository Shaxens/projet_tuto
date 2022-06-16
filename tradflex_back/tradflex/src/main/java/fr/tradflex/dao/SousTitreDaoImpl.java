package fr.tradflex.dao;

import fr.tradflex.model.sousTitre.SousTitre;
import fr.tradflex.model.sousTitre.SousTitreWhenCreating;
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
    public SousTitre getById(int id)
    {
        try
        {
            PreparedStatement req = connection.connection().prepareStatement("SELECT * FROM SOUS_TITRE WHERE SOUS_TITRE.id = ?");
            req.setInt(1, id);
            ResultSet res = req.executeQuery();
            if (res.next())
            {
                int idSousTitre = res.getInt("id");
                String body = res.getString("body");
                var timeCodeBegin = res.getDouble("timeCodeBegin");
                var timeCodeEnd = res.getDouble("timeCodeEnd");
                int idProject = res.getInt("idProject");

                return new SousTitre(idSousTitre, body, timeCodeBegin, timeCodeEnd, idProject);
            }
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
        }
        return null;
    }

    public Collection<SousTitre> getAll()
    {
        try
        {
            PreparedStatement req = connection.connection().prepareStatement("SELECT * FROM SOUS_TITRE");
            ResultSet res = req.executeQuery();

            List<SousTitre> listSousTitre = new ArrayList<>();
            while (res.next())
            {
                int id = res.getInt("id");
                String body = res.getString("body");
                var timeCodeBegin = res.getDouble("timeCodeBegin");
                var timeCodeEnd = res.getDouble("timeCodeEnd");
                int idProject = res.getInt("idProject");

                listSousTitre.add(new SousTitre(id, body, timeCodeBegin, timeCodeEnd, idProject));
            }

            return listSousTitre;
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
        }
        return null;
    }

    public boolean create(SousTitreWhenCreating sousTitre)
    {
        try
        {
            PreparedStatement req = connection.connection().prepareStatement("INSERT INTO SOUS_TITRE (body, timeCodeBegin, timeCodeEnd, idProject) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            req.setString(1, sousTitre.body());
            req.setDouble(2, sousTitre.timeCodeBegin());
            req.setDouble(3, sousTitre.timeCodeEnd());
            req.setInt(4, sousTitre.idProject());

            req.executeUpdate();

            var rs = req.getGeneratedKeys();
            rs.next();
            rs.getInt(1);
            // TODO On recup l'id créé, return un objet du coup
            return true;
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
            return false;
        }
    }

    public SousTitre update(SousTitre sousTitre)
    {
        try
        {
            PreparedStatement req = connection.connection().prepareStatement("UPDATE SOUS_TITRE SET body = ?, timeCodeBegin = ?, timeCodeEnd = ? WHERE SOUS_TITRE.id = ?");
            req.setInt(4, sousTitre.id());
            req.setString(1, sousTitre.body());
            req.setDouble(2, sousTitre.timeCodeBegin());
            req.setDouble(3, sousTitre.timeCodeEnd());
            req.executeUpdate();

            return getById(sousTitre.id());
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
        }
        return null;
    }

    public boolean delete(int id)
    {
        try
        {
            PreparedStatement req = connection.connection().prepareStatement("DELETE FROM SOUS_TITRE WHERE SOUS_TITRE.id = ?");
            req.setInt(1, id);
            req.executeUpdate();

            return true;
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
            return false;
        }
    }

}