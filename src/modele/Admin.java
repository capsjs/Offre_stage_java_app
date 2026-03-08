package modele;

public class Admin {
    public static String id_admin;
    public static String mdp_admin;
    public static boolean isAdmin = false;

    public Admin() {
    }

    public static String getId_admin() {
        return id_admin;
    }

    public static void setId_admin(String id_admin) {
        Admin.id_admin = id_admin;
    }

    public static String getMdp_admin() {
        return mdp_admin;
    }

    public static void setMdp_admin(String mdp_admin) {
        Admin.mdp_admin = mdp_admin;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }




}
