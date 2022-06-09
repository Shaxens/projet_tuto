package fr.tradflex.dao;

import fr.tradflex.model.project.Project;
import fr.tradflex.model.project.ProjectStatus;
import fr.tradflex.model.project.ProjectWhenCreating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public final class ProjectDAOImpl implements ProjectDAO {

    private final ConnexionDbDAO connection;

    @Autowired
    public ProjectDAOImpl(ConnexionDbDAO connection) {
        this.connection = connection;
    }

    private int getLastIds() throws SQLException
    {
        PreparedStatement req = connection.connection().prepareStatement("SELECT id FROM PROJECT");
        ResultSet res = req.executeQuery();
        int lastId = 0;

        while (res.next())
        {
            lastId = Integer.parseInt(res.getString("id"));
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
            PreparedStatement req = connection.connection().prepareStatement("SELECT * FROM PROJECT WHERE PROJECT.id = ?");
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
            PreparedStatement req = connection.connection().prepareStatement("SELECT * FROM PROJECT");
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
            PreparedStatement req = connection.connection().prepareStatement("INSERT INTO PROJECT (id, name, description, picture, status) VALUES (?, ?, ?, ?, ?)");
            req.setString(1, newProject.id());
            req.setString(2, newProject.name());
            req.setString(3, newProject.description());
            req.setString(4, newProject.picture());
            req.setInt(5, newProject.status().getId());
            req.executeUpdate();

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
        try
        {
            PreparedStatement req = connection.connection().prepareStatement("UPDATE PROJECT SET name = ?, description = ?, picture = ?, status = ? WHERE PROJECT.id = ?");
            req.setString(1, project.name());
            req.setString(2, project.description());
            req.setString(3, project.picture());
            req.setInt(4, project.status().getId());
            req.setString(5, project.id());
            req.executeUpdate();

            return getById(project.id());
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(String id)
    {
        try
        {
            PreparedStatement req = connection.connection().prepareStatement("DELETE FROM PROJECT WHERE PROJECT.id = ?");
            req.setString(1, id);
            req.executeUpdate();

            return true;
        } catch (SQLException SQLe)
        {
            System.out.println(SQLe.getMessage());
            return false;
        }
    }
}
