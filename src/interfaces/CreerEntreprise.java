package interfaces;

import bdd.Connecter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreerEntreprise extends JFrame {

    private JPanel jPanel1;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9;
    private JTextField txtNomEntreprise, txtNumeroRue, txtCodePostal, txtVille, txtMailContact, txtTelContact, txtSecteur, txtMdp;
    private JButton boutonEnvoyerEntreprise, boutonAnnulerEntreprise;

    Connection con;
    PreparedStatement pr;

    public CreerEntreprise() {
        con = Connecter.connecter();

        initComponents();

        this.setTitle("Créer une entreprise");
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

        jLabel1 = new JLabel("Création d'une entreprise");
        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jLabel1.setForeground(Color.BLACK);
        jLabel1.setBounds(200, 10, 300, 30);
        jPanel1.add(jLabel1);

        jLabel2 = new JLabel("Nom de l'entreprise");
        jLabel2.setBounds(30, 50, 150, 25);
        jPanel1.add(jLabel2);

        txtNomEntreprise = new JTextField();
        txtNomEntreprise.setBounds(200, 50, 400, 25);
        jPanel1.add(txtNomEntreprise);

        jLabel3 = new JLabel("Adresse");
        jLabel3.setBounds(30, 90, 150, 25);
        jPanel1.add(jLabel3);

        txtNumeroRue = new JTextField();
        txtNumeroRue.setBounds(200, 90, 400, 25);
        jPanel1.add(txtNumeroRue);

        jLabel4 = new JLabel("Code Postal");
        jLabel4.setBounds(30, 130, 150, 25);
        jPanel1.add(jLabel4);

        txtCodePostal = new JTextField();
        txtCodePostal.setBounds(200, 130, 400, 25);
        jPanel1.add(txtCodePostal);

        jLabel5 = new JLabel("Ville");
        jLabel5.setBounds(30, 170, 150, 25);
        jPanel1.add(jLabel5);

        txtVille = new JTextField();
        txtVille.setBounds(200, 170, 400, 25);
        jPanel1.add(txtVille);

        jLabel6 = new JLabel("Mail du contact");
        jLabel6.setBounds(30, 210, 150, 25);
        jPanel1.add(jLabel6);

        txtMailContact = new JTextField();
        txtMailContact.setBounds(200, 210, 400, 25);
        jPanel1.add(txtMailContact);

        jLabel9 = new JLabel("Mot de passe");
        jLabel9.setBounds(30, 250, 150, 25);
        jPanel1.add(jLabel9);

        txtMdp = new JTextField();
        txtMdp.setBounds(200, 250, 400, 25);
        jPanel1.add(txtMdp);

        jLabel8 = new JLabel("Téléphone du contact");
        jLabel8.setBounds(30, 290, 150, 25);
        jPanel1.add(jLabel8);

        txtTelContact = new JTextField();
        txtTelContact.setBounds(200, 290, 400, 25);
        jPanel1.add(txtTelContact);

        jLabel7 = new JLabel("Secteur d'activité");
        jLabel7.setBounds(30, 330, 150, 25);
        jPanel1.add(jLabel7);

        txtSecteur = new JTextField();
        txtSecteur.setBounds(200, 330, 400, 25);
        jPanel1.add(txtSecteur);

        boutonEnvoyerEntreprise = new JButton("Envoyer");
        boutonEnvoyerEntreprise.setBounds(200, 380, 100, 30);
        boutonEnvoyerEntreprise.addActionListener(this::boutonEnvoyerEntrepriseActionPerformed);
        jPanel1.add(boutonEnvoyerEntreprise);

        boutonAnnulerEntreprise = new JButton("Annuler");
        boutonAnnulerEntreprise.setBounds(320, 380, 100, 30);
        jPanel1.add(boutonAnnulerEntreprise);
        boutonAnnulerEntreprise.addActionListener(e -> {
            this.setVisible(false);
            new Accueil().setVisible(true);
        });

    }

    private void boutonEnvoyerEntrepriseActionPerformed(ActionEvent evt) {
        try {
            String sql = "INSERT INTO entreprise (nom_entreprise, adresse_rue_entreprise, adresse_code_postal_entreprise, \n" +
                    "adresse_ville_entreprise, email_entreprise, mdp_entreprise, tel_entreprise, secteur_activite) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            pr = con.prepareStatement(sql);
            pr.setString(1, txtNomEntreprise.getText());
            pr.setString(2, txtNumeroRue.getText());
            pr.setString(3, txtCodePostal.getText());
            pr.setString(4, txtVille.getText());
            pr.setString(5, txtMailContact.getText());
            pr.setString(6, txtMdp.getText());
            pr.setString(7, txtTelContact.getText());
            pr.setString(8, txtSecteur.getText());

            pr.executeUpdate();
            JOptionPane.showMessageDialog(null, "Entreprise enregistrée avec succès !");
            this.setVisible(false);
            new GestionDesOffres().setVisible(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CreerEntreprise();
    }
}