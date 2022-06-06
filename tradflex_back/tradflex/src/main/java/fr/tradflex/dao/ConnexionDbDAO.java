package fr.tradflex.dao;

import java.sql.*;

public class ConnexionDbDAO {
    // ATTRIBUT
    private static ConnexionDbDAO instance;

    // Constructeur
    private ConnexionDbDAO()
    {
        instance = ConnexionDbDAO.getInstance();
    }

    // METHODES
    public static ConnexionDbDAO getInstance() // On créé un singleton d'objet de type Connexion (une instance)
    {
        if (instance != null) {
            instance = new ConnexionDbDAO();
        }
        return instance;
    }

    public static Connection creerConnection() //
    {
        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/oury16u_tradFlex";
        String login = "oury16u_appli";
        String pwd = "32124584";
        Connection maConnexion = null;

        try {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion" + sqle.getMessage());
        }

        return maConnexion;
    }
}
