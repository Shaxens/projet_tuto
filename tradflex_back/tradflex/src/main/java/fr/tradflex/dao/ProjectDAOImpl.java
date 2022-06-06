package fr.tradflex.dao;

import fr.tradflex.model.Project;
import fr.tradflex.model.ProjectStatus;
import fr.tradflex.model.ProjectWhenCreating;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public final class ProjectDAOImpl implements ProjectDAO {
    private static final AtomicInteger ID = new AtomicInteger(1);
    private static final List<Project> PROJECTS = new ArrayList<>();

    static {
        PROJECTS.add(new Project(Integer.toString(ID.getAndIncrement()), "toto", "yoloo", "https://media.gqmagazine.fr/photos/5dea6130061f7b00082f3405/master/pass/Djangounchained.jpg", 1));
        PROJECTS.add(new Project(Integer.toString(ID.getAndIncrement()), "tonton", "yaloo", "https://media.gqmagazine.fr/photos/5dea6130061f7b00082f3405/master/pass/Djangounchained.jpg", ProjectStatus.ABANDONNE));
        PROJECTS.add(new Project(Integer.toString(ID.getAndIncrement()), "tata", "yohoo", "https://media.gqmagazine.fr/photos/5dea6130061f7b00082f3405/master/pass/Djangounchained.jpg", ProjectStatus.TERMINE));
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
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Project> getAll()
    {
        return PROJECTS;
    }

    @Override
    public Project create(ProjectWhenCreating project)
    {
        var newProject = new Project(Integer.toString(ID.getAndIncrement()), project.name(), project.description(), project.picture(), ProjectStatus.EN_COURS);
        PROJECTS.add(newProject);
        return newProject;
    }

    @Override
    public Project update(Project project)
    {
        return null;
    }

    @Override
    public void delete(String id)
    {

    }
}
