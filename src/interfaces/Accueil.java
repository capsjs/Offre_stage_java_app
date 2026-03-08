package interfaces;

import bdd.Connecter;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Accueil extends JFrame {
    private JPanel jPanel1;
    private JLabel lblTitre, lblIdentifiant, lblMotDePasse, lblChoix;
    private JTextField txtIdentifiant;
    private JButton btnValider, btnCreerEtudiant, btnCreerEntreprise;
    private JComboBox<String> comboUtilisateur;
    private JPasswordField txtMotDePasse;

    private Connection con;
    private PreparedStatement pr;
    private ResultSet rs;

    public Accueil() {
        initComponents();
        con = Connecter.connecter();
    }

    private void initComponents() {


        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBackground(new Color(172, 197, 205));//couleur de fond

        lblTitre = new JLabel("Bonjour, veuillez vous connecter");
        lblTitre.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        lblTitre.setBounds(60, 20, 400, 30);
        jPanel1.add(lblTitre);

        lblIdentifiant = new JLabel("Identifiant");
        lblIdentifiant.setBounds(40, 80, 100, 20);
        jPanel1.add(lblIdentifiant);

        txtIdentifiant = new JTextField();
        txtIdentifiant.setBounds(150, 80, 200, 25);
        jPanel1.add(txtIdentifiant);

        lblMotDePasse = new JLabel("Mot de passe");
        lblMotDePasse.setBounds(40, 120, 100, 20);
        jPanel1.add(lblMotDePasse);

        txtMotDePasse = new JPasswordField();
        txtMotDePasse.setBounds(150, 120, 200, 25);
        jPanel1.add(txtMotDePasse);

        lblChoix = new JLabel("Utilisateur");
        lblChoix.setBounds(40, 160, 100, 20);
        jPanel1.add(lblChoix);

        comboUtilisateur = new JComboBox<>(new String[]{"Etudiant", "Entreprise", "Admin"});
        comboUtilisateur.setBounds(150, 160, 200, 25);
        jPanel1.add(comboUtilisateur);

        btnValider = new JButton("Valider");
        btnValider.setBounds(270, 200, 80, 30);
        jPanel1.add(btnValider);

        btnCreerEtudiant = new JButton("Créer étudiant");
        btnCreerEtudiant.setBounds(80, 250, 130, 30);
        jPanel1.add(btnCreerEtudiant);

        btnCreerEntreprise = new JButton("Créer entreprise");
        btnCreerEntreprise.setBounds(220, 250, 130, 30);
        jPanel1.add(btnCreerEntreprise);

        btnValider.addActionListener(e -> connecter());

        btnCreerEtudiant.addActionListener(e -> {
            new CreerEtudiant().setVisible(true);
            this.setVisible(false);
        });

        btnCreerEntreprise.addActionListener(e -> {
            new CreerEntreprise().setVisible(true);
            this.setVisible(false);
        });
        this.setTitle("Accueil");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(jPanel1);
        this.setSize(450, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void connecter() {
        String choix = comboUtilisateur.getSelectedItem().toString();
        String identifiant = txtIdentifiant.getText();
        String mdp = new String(txtMotDePasse.getPassword());
        String table = "", champEmail = "", champMdp = "";

        switch (choix) {
            case "Etudiant":
                table = "etudiant";
                champEmail = "email_etudiant";
                champMdp = "mdp_etudiant";
                break;
            case "Entreprise":
                table = "entreprise";
                champEmail = "email_entreprise";
                champMdp = "mdp_entreprise";
                break;
            case "Admin":
                table = "admin";
                champEmail = "email_admin";
                champMdp = "mdp_admin";
                break;

        }
        try {
            String sql = "SELECT * FROM " + table + " WHERE " + champEmail + "=? AND " + champMdp + "=?";

            pr = con.prepareStatement(sql);
            pr.setString(1, identifiant);
            pr.setString(2, mdp);
            rs = pr.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Connexion Réussie !");
                if (choix.equals("Etudiant")) {
                    new ConsulterOffreEtudiant().setVisible(true);
                } else if (choix.equals("Entreprise")) {
                    new EntrepriseCreerOffre().setVisible(true);
                } else {
                    new GestionDesOffres().setVisible(true);
                }
                this.dispose();//fermer la fenêtre actuelle
            } else {
                JOptionPane.showMessageDialog(this, "Identifiants incorrects.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, " Erreur : " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Accueil::new);

    }
}