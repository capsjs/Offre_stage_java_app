package interfaces;

import bdd.Connecter;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifierEntreprise extends JFrame {
    private JPanel jPanel1;
    private JTextField txtNumeroRue, txtCodePostal, txtVille, txtMailContact, txtTelContact, txtSecteur;
    private JComboBox<String> ComboListeEntreprise;
    private JButton boutonMaj, boutonSupprimerEntreprise, boutonAnnulerEntreprise;
    private JLabel jLabel1, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9;

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public ModifierEntreprise() {
        con = Connecter.connecter();

        setTitle("Modifier une entreprise");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jPanel1 = new JPanel();
        jPanel1.setBackground(new java.awt.Color(172, 197, 205));
        jPanel1.setLayout(null);

        jLabel1 = new JLabel("Modifier une entreprise");
        jLabel1.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
        jLabel1.setBounds(123, 20, 400, 30);
        jPanel1.add(jLabel1);

        jLabel9 = new JLabel("Choix de l'entreprise à modifier: ");
        jLabel9.setBounds(50, 70, 250, 25);
        jPanel1.add(jLabel9);

        ComboListeEntreprise = new JComboBox<>();
        ComboListeEntreprise.setBounds(300, 70, 250, 25);
        jPanel1.add(ComboListeEntreprise);

        jLabel3 = new JLabel("Adresse (Numéro et rue)");
        jLabel3.setBounds(50, 110, 200, 25);
        jPanel1.add(jLabel3);
        txtNumeroRue = new JTextField();
        txtNumeroRue.setBounds(300, 110, 250, 25);
        jPanel1.add(txtNumeroRue);

        jLabel4 = new JLabel("Code Postal");
        jLabel4.setBounds(50, 150, 200, 25);
        jPanel1.add(jLabel4);

        txtCodePostal = new JTextField();
        txtCodePostal.setBounds(300, 150, 250, 25);
        jPanel1.add(txtCodePostal);

        jLabel5 = new JLabel("Ville");
        jLabel5.setBounds(50, 190, 200, 25);
        jPanel1.add(jLabel5);

        txtVille = new JTextField();
        txtVille.setBounds(300, 190, 250, 25);
        jPanel1.add(txtVille);

        jLabel6 = new JLabel("Email du contact");
        jLabel6.setBounds(50, 230, 200, 25);
        jPanel1.add(jLabel6);

        txtMailContact = new JTextField();
        txtMailContact.setBounds(300, 230, 250, 25);
        jPanel1.add(txtMailContact);

        jLabel8 = new JLabel("Téléphone du contact");
        jLabel8.setBounds(50, 270, 200, 25);
        jPanel1.add(jLabel8);

        txtTelContact = new JTextField();
        txtTelContact.setBounds(300, 270, 250, 25);
        jPanel1.add(txtTelContact);

        jLabel7 = new JLabel("Secteur d'activité de l'entreprise");
        jLabel7.setBounds(50, 310, 250, 25);
        jPanel1.add(jLabel7);

        txtSecteur = new JTextField();
        txtSecteur.setBounds(300, 310, 250, 25);
        jPanel1.add(txtSecteur);

        boutonMaj = new JButton("Mettre à jour");
        boutonMaj.setBounds(50, 360, 150, 30);
        jPanel1.add(boutonMaj);

        boutonSupprimerEntreprise = new JButton("Supprimer");
        boutonSupprimerEntreprise.setBounds(220, 360, 150, 30);
        jPanel1.add(boutonSupprimerEntreprise);

        boutonAnnulerEntreprise = new JButton("Annuler");
        boutonAnnulerEntreprise.setBounds(390, 360, 150, 30);
        jPanel1.add(boutonAnnulerEntreprise);

        chargerEntreprises();

        ComboListeEntreprise.addActionListener(e -> chargerInfosEntreprise());

        boutonMaj.addActionListener(e -> mettreAJourEntreprise());

        boutonSupprimerEntreprise.addActionListener(e -> supprimerEntreprise());

        boutonAnnulerEntreprise.addActionListener(e -> gestionDesOffres());

        setContentPane(jPanel1);
        setVisible(true);
    }
    private void chargerEntreprises() {
        try {
            ps = con.prepareStatement("SELECT nom_entreprise FROM entreprise");
            rs = ps.executeQuery();
            while (rs.next()){
                ComboListeEntreprise.addItem(rs.getString("nom_entreprise"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Erreur chargement entreprises : " + e.getMessage());
        }
    }

    private void chargerInfosEntreprise(){
        String nom = (String) ComboListeEntreprise.getSelectedItem();
        try {
            ps = con.prepareStatement("SELECT * FROM entreprise WHERE nom_entreprise = ?");
            ps.setString(1, nom);
            rs = ps.executeQuery();
            if (rs.next()) {
                txtVille.setText(rs.getString("adresse_ville_entreprise"));
                txtNumeroRue.setText(rs.getString("adresse_rue_entreprise"));
                txtCodePostal.setText(rs.getString("adresse_code_postal_entreprise"));
                txtTelContact.setText(rs.getString("tel_entreprise"));
                txtMailContact.setText(rs.getString("email_entreprise"));
                txtSecteur.setText(rs.getString("secteur_activite"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur chargement infos : " + e.getMessage());
        }
    }

    private void mettreAJourEntreprise() {
        String nom = (String) ComboListeEntreprise.getSelectedItem();
        try {
            ps = con.prepareStatement("UPDATE entreprise SET adresse_ville_entreprise = ?, adresse_rue_entreprise = ?, adresse_code_postal_entreprise = ?, tel_entreprise = ?, email_entreprise = ?, secteur_activite = ? WHERE nom_entreprise = ?");
            ps.setString(1, txtVille.getText());
            ps.setString(2, txtNumeroRue.getText());
            ps.setString(3, txtCodePostal.getText());
            ps.setString(4, txtTelContact.getText());
            ps.setString(5, txtMailContact.getText());
            ps.setString(6, txtSecteur.getText());
            ps.setString(7, nom);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Entreprise mise à jour avec succès");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur mise à jour : " + e.getMessage());
        }
    }

    private void supprimerEntreprise() {
        String nom = (String) ComboListeEntreprise.getSelectedItem();
        int confirmation = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cette entreprise ?","Confirmation", JOptionPane.YES_NO_OPTION );
        if (confirmation == JOptionPane.YES_OPTION){
            try {
                ps = con.prepareStatement("DELETE FROM entreprise WHERE nom_entreprise = ?");
                ps.setString(1, nom);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Entreprise supprimée");
                ComboListeEntreprise.removeItem(nom);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erreur Suppression : " + e.getMessage());
            }
        }
    }

    private void gestionDesOffres() {
        new GestionDesOffres();
        this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ModifierEntreprise::new);
    }
}