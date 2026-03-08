package interfaces;

import bdd.Connecter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminCreerOffre extends JFrame {

    private JPanel jPanel1;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9;
    private JTextField txtLibelleOffre, txtDescriptionOffre, txtDomaineOffre, txtDebutOffre, txtDureeOffre, txtNomEntreprise, txtEmailEntreprise, txtAdresseVilleEntreprise;
    private JButton boutonAnnulerOffre, boutonEnvoyerOffre;

    Connection con;
    PreparedStatement pr;

    public AdminCreerOffre() {
        con = Connecter.connecter();

        initComponents();

        this.setTitle("Creer une offre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setContentPane(jPanel1);
        this.setVisible(true);
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(172, 197, 205));
        jPanel1.setBorder(new LineBorder(Color.BLACK, 1, true));
        jPanel1.setLayout(null);

        jLabel1 = new JLabel("Création d'une offre");
        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setBounds(200, 10, 300, 30);
        jPanel1.add(jLabel1);

        jLabel2 = new JLabel("Intitulé de l'offre");
        jLabel2.setBounds(30, 50, 150, 25);
        jPanel1.add(jLabel2);

        txtLibelleOffre = new JTextField();
        txtLibelleOffre.setBounds(200, 50, 400, 25);
        jPanel1.add(txtLibelleOffre);

        jLabel3 = new JLabel("Description");
        jLabel3.setBounds(30, 90, 150, 25);
        jPanel1.add(jLabel3);

        txtDescriptionOffre = new JTextField();
        txtDescriptionOffre.setBounds(200, 90, 400, 25);
        jPanel1.add(txtDescriptionOffre);

        jLabel4 = new JLabel("Domaine");
        jLabel4.setBounds(30, 130, 150, 25);
        jPanel1.add(jLabel4);

        txtDomaineOffre = new JTextField();
        txtDomaineOffre.setBounds(200, 130, 400, 25);
        jPanel1.add(txtDomaineOffre);

        jLabel5 = new JLabel("Date de début");
        jLabel5.setBounds(30, 170, 150, 25);
        jPanel1.add(jLabel5);

        txtDebutOffre = new JTextField();
        txtDebutOffre.setBounds(200, 170, 400, 25);
        jPanel1.add(txtDebutOffre);

        jLabel6 = new JLabel("Durée de l'offre");
        jLabel6.setBounds(30, 210, 150, 25);
        jPanel1.add(jLabel6);

        txtDureeOffre = new JTextField();
        txtDureeOffre.setBounds(200, 210, 400, 25);
        jPanel1.add(txtDureeOffre);

        jLabel7 = new JLabel("Nom de l'entreprise");
        jLabel7.setBounds(30, 250, 150, 25);
        jPanel1.add(jLabel7);

        txtNomEntreprise = new JTextField();
        txtNomEntreprise.setBounds(200, 250, 400, 25);
        jPanel1.add(txtNomEntreprise);

        jLabel8 = new JLabel("Email de l'entreprise");
        jLabel8.setBounds(30, 290, 150, 25);
        jPanel1.add(jLabel8);

        txtEmailEntreprise = new JTextField();
        txtEmailEntreprise.setBounds(200, 290, 400, 25);
        jPanel1.add(txtEmailEntreprise);

        jLabel9 = new JLabel("Adresse de l'entreprise");
        jLabel9.setBounds(30, 330, 150, 25);
        jPanel1.add(jLabel9);

        txtAdresseVilleEntreprise = new JTextField();
        txtAdresseVilleEntreprise.setBounds(200, 330, 400, 25);
        jPanel1.add(txtAdresseVilleEntreprise);

        boutonEnvoyerOffre = new JButton("Envoyer");
        boutonEnvoyerOffre.setBounds(200, 380, 100, 30);
        boutonEnvoyerOffre.addActionListener(this::boutonEnvoyerOffreActionPerformed);
        jPanel1.add(boutonEnvoyerOffre);


        boutonAnnulerOffre = new JButton("Annuler");
        boutonAnnulerOffre.setBounds(320, 380, 100, 30);
        jPanel1.add(boutonAnnulerOffre);
        boutonAnnulerOffre.addActionListener(e -> {
            this.setVisible(false);
            new GestionDesOffres().setVisible(true);
        });

    }

        private void boutonEnvoyerOffreActionPerformed (ActionEvent evt){
            try {
                String sql = "INSERT INTO offre (libelle_offre, description_offre, domaine_offre, \n" +
                        "date_debut_offre, duree_offre, nom_entreprise, email_entreprise, adresse_ville_entreprise) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                pr = con.prepareStatement(sql);
                pr.setString(1, txtLibelleOffre.getText());
                pr.setString(2, txtDescriptionOffre.getText());
                pr.setString(3, txtDomaineOffre.getText());
                pr.setString(4, txtDebutOffre.getText());
                pr.setString(5, txtDureeOffre.getText());
                pr.setString(6, txtNomEntreprise.getText());
                pr.setString(7, txtEmailEntreprise.getText());
                pr.setString(8, txtAdresseVilleEntreprise.getText());

                pr.executeUpdate();
                JOptionPane.showMessageDialog(null, "Offre enregistrée avec succès !");
                this.setVisible(false);
                new GestionDesOffres().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            new AdminCreerOffre();
        }

}
