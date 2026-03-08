import bdd.Connecter;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = Connecter.connecter();

        if(con != null) {
            System.out.println("Connection ok!.");
        } else {
            System.out.println("Echec de la  connexion.");
        }

    }
}