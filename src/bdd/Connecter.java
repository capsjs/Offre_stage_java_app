package bdd;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connecter {
    public static Connection connecter() {
        Connection con = null;
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");

            String utilisateur = props.getProperty("db.utilisateur");
            String motDePasse = props.getProperty("db.motDePasse");

            con = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données OK.");

        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion : " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du fichier de configuration : " + e.getMessage());
            throw new RuntimeException("Impossible de charger le fichier conf.properties.", e);
        }
        return con;
    }

    public static void fermerConnexion(Connection con) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Connexion fermée.");
            } catch( SQLException e) {
                System.err.println("Erreur lors de la fermeture : " + e.getMessage());
            }
        }
    }
}
