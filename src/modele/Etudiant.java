package modele;

public class Etudiant {

    private int id_etudiant;
    private String nom_etudiant;
    private String prenom_etudiant;
    private String date_de_naissant;
    private String niveau_etude;
    private String email_etudiant;
    private String mdp_etudiant;

    public Etudiant() {
    }

    public Etudiant(int id_etudiant, String nom_etudiant, String prenom_etudiant, String date_de_naissant, String niveau_etude, String email_etudiant, String mdp_etudiant) {
        this.id_etudiant = id_etudiant;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.date_de_naissant = date_de_naissant;
        this.niveau_etude = niveau_etude;
        this.email_etudiant = email_etudiant;
        this.mdp_etudiant = mdp_etudiant;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public String getPrenom_etudiant() {
        return prenom_etudiant;
    }

    public void setPrenom_etudiant(String prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    public String getDate_de_naissant() {
        return date_de_naissant;
    }

    public void setDate_de_naissant(String date_de_naissant) {
        this.date_de_naissant = date_de_naissant;
    }

    public String getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public String getEmail_etudiant() {
        return email_etudiant;
    }

    public void setEmail_etudiant(String email_etudiant) {
        this.email_etudiant = email_etudiant;
    }

    public String getMdp_etudiant() {
        return mdp_etudiant;
    }

    public void setMdp_etudiant(String mdp_etudiant) {
        this.mdp_etudiant = mdp_etudiant;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id_etudiant=" + id_etudiant +
                ", nom_etudiant='" + nom_etudiant + '\'' +
                ", prenom_etudiant='" + prenom_etudiant + '\'' +
                ", date_de_naissant='" + date_de_naissant + '\'' +
                ", niveau_etude='" + niveau_etude + '\'' +
                ", email_etudiant='" + email_etudiant + '\'' +
                ", mdp_etudiant='" + mdp_etudiant + '\'' +
                '}';
    }
}
