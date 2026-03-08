package modele;

import java.util.LinkedList;
import java.util.List;

public class Entreprise {

    private List<OffreStage> lesOffres = new LinkedList<>();

    private String nomEntreprise;
    private String adVille;
    private String adRue;
    private String codePostal;
    private String tel;
    private String email;
    private String secteur;

    public Entreprise() {
    }

    public Entreprise(String nomEntreprise, String adVille, String adRue, String codePostal, String tel, String email, String secteur) {
        this.nomEntreprise = nomEntreprise;
        this.adVille = adVille;
        this.adRue = adRue;
        this.codePostal = codePostal;
        this.tel = tel;
        this.email = email;
        this.secteur = secteur;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public List<OffreStage> getLesOffres() {
        return lesOffres;
    }

    public String getAdVille() {
        return adVille;
    }

    public String getAdRue() {
        return adRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setLesOffres(List<OffreStage> lesOffres) {
        this.lesOffres = lesOffres;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public void setAdVille(String adVille) {
        this.adVille = adVille;
    }

    public void setAdRue(String adRue) {
        this.adRue = adRue;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String toString(){
        return "\n" + "Nom de l'entreprise: " + nomEntreprise
                + "\n" + "Ville: " + adVille
                + "\n" + "Rue: " + adRue
                + "\n" + "Cosde postal: " + codePostal
                + "\n" + "Téléphone: " + tel
                + "\n" + "Email: " + email
                + "\n" + "Secteur: " + secteur;
    }
}
