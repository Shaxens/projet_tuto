package fr.tradflex.dao;

import fr.tradflex.model.Project;
import fr.tradflex.model.ProjectStatus;
import fr.tradflex.model.ProjectWhenCreating;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public final class ProjectDAOImpl implements ProjectDAO {
    private ConnexionDbDAO connexionDbDAO;

    public ProjectDAOImpl()
    {
        this.connexionDbDAO = ConnexionDbDAO.getInstance();
    }

    private static int getLastIds() throws SQLException
    {
        Connection connection = ConnexionDbDAO.creerConnection();
        PreparedStatement req = connection.prepareStatement("SELECT id FROM PROJECT");
        ResultSet res = req.executeQuery();
        int lastId = 0;

        if (res.next())
        {
            while (res.next())
            {
                lastId = res.getInt("id");
            }
        }
        return lastId;
    }

    private int incrementLastId() throws SQLException
    {
        return getLastIds() + 1;
    }

    @Override
    public Project getById(String id)
    {
        try
        {
            Connection connection = ConnexionDbDAO.creerConnection();
            PreparedStatement req = connection.prepareStatement("SELECT * FROM PROJECT WHERE PROJECT.id = ?");
            req.setString(1, id);
            ResultSet res = req.executeQuery();
            if (res.next())
            {
                String idProject = Integer.toString(res.getInt("id"));
                String name = res.getString("name");
                String description = res.getString("description");
                String picture = res.getString("picture");
                ProjectStatus status = ProjectStatus.of(res.getInt("status"));

                return new Project(idProject, name, description, picture, status);
            }
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Project> getAll()
    {
        try
        {
            Connection connection = ConnexionDbDAO.creerConnection();
            PreparedStatement req = connection.prepareStatement("SELECT * FROM PROJECT");
            ResultSet res = req.executeQuery();

            List<Project> listProjects = new ArrayList<>();
            while (res.next())
            {
                String idProject = Integer.toString(res.getInt("id"));
                String name = res.getString("name");
                String description = res.getString("description");
                String picture = res.getString("picture");
                ProjectStatus status = ProjectStatus.of(res.getInt("status"));

                listProjects.add(new Project(idProject, name, description, picture, status));
            }

            return listProjects;
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
        }
        return null;
    }

    @Override
    public Project create(ProjectWhenCreating project) {
        try
        {
            var newProject = new Project(String.valueOf(incrementLastId()), project.name(), project.description(), project.picture(), ProjectStatus.EN_COURS);
            Connection connection = ConnexionDbDAO.creerConnection();
            PreparedStatement req = connection.prepareStatement("INSERT INTO PROJECT (id, name, description, picture, status) VALUES (?, ?, ?, ?, ?)");
            req.setString(1, newProject.id());
            req.setString(2, newProject.name());
            req.setString(3, newProject.description());
            req.setString(4, newProject.picture());
            req.setInt(5, newProject.status().getId());

            req.executeQuery();
            return newProject;
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
        }
        return null;
    }

    @Override
    public Project update(Project project)
    {
        // SQL
        return null;
    }

    @Override
    public void delete(String id)
    {
        // SQL
    }
}
