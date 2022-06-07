package fr.tradflex.dao;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ConnexionDbDAO {

    private Connection connection;
    private ConnexionDbDAO() {
        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/oury16u_tradFlex";
        String login = "oury16u_appli";
        String pwd = "32124584";

        try {
            this.connection = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion" + sqle.getMessage());
        }
    }

    public Connection connection() {
        return connection;
    }
}
