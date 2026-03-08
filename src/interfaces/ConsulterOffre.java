package interfaces;

import bdd.Connecter;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsulterOffre extends JFrame {
    private JPanel jPanel1;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8;
    private JTextField txtLibelleOffre, txtDescriptionOffre, txtDomaineOffre, txtDebutOffre, txtDureeOffre, txtNomEntreprise, txtEmailEntreprise, txtAdresseVilleEntreprise;
    private JComboBox<String> ComboListeOffre;
    private JButton boutonRetourGestionAdmin;

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public ConsulterOffre() {
        con = Connecter.connecter();

        setTitle("Consulter les offres");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jPanel1 = new JPanel();
        jPanel1.setBackground(new java.awt.Color(172, 197, 205));
        jPanel1.setLayout(null);

        jLabel1 = new JLabel("Choix de l'offre: ");
        jLabel1.setBounds(50, 70, 250, 25);
        jPanel1.add(jLabel1);

        ComboListeOffre = new JComboBox<>();
        ComboListeOffre.setBounds(300, 70, 250, 25);
        jPanel1.add(ComboListeOffre);

        jLabel2 = new JLabel("Description de l'offre");
        jLabel2.setBounds(50, 110, 200, 25);
        jPanel1.add(jLabel2);

        txtDescriptionOffre = new JTextField();
        txtDescriptionOffre.setBounds(300, 110, 250, 25);
        jPanel1.add(txtDescriptionOffre);

        jLabel3 = new JLabel("Domaine d'activité");
        jLabel3.setBounds(50, 150, 200, 25);
        jPanel1.add(jLabel3);

        txtDomaineOffre = new JTextField();
        txtDomaineOffre.setBounds(300, 150, 250, 25);
        jPanel1.add(txtDomaineOffre);

        jLabel4 = new JLabel("Nom de l'entreprise");
        jLabel4.setBounds(50, 190, 200, 25);
        jPanel1.add(jLabel4);

        txtNomEntreprise = new JTextField();
        txtNomEntreprise.setBounds(300, 190, 250, 25);
        jPanel1.add(txtNomEntreprise);

        jLabel5 = new JLabel("Email de l'entreprise");
        jLabel5.setBounds(50, 230, 200, 25);
        jPanel1.add(jLabel5);

        txtEmailEntreprise = new JTextField();
        txtEmailEntreprise.setBounds(300, 230, 250, 25);
        jPanel1.add(txtEmailEntreprise);

        boutonRetourGestionAdmin = new JButton("Retour");
        boutonRetourGestionAdmin.setBounds(390, 360, 150, 30);
        jPanel1.add(boutonRetourGestionAdmin);

        chargerOffres();

        ComboListeOffre.addActionListener(e -> chargerInfosOffre());
        boutonRetourGestionAdmin.addActionListener(e -> gestionDesOffres());

        setContentPane(jPanel1);
        setVisible(true);
    }

    private void chargerOffres() {
        try {
            pst = con.prepareStatement("SELECT libelle_offre FROM offre");
            rs = pst.executeQuery();
            while (rs.next()){
                ComboListeOffre.addItem(rs.getString("libelle_offre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur chargement offres : " + e.getMessage());
        }
    }

    private void chargerInfosOffre() {
        String libelle = (String) ComboListeOffre.getSelectedItem();
        try {
            pst = con.prepareStatement("SELECT * FROM offre WHERE libelle_offre = ?");
            pst.setString(1, libelle);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtLibelleOffre.setText(rs.getString("libelle_offre"));
                txtDescriptionOffre.setText(rs.getString("description_offre"));
                txtDomaineOffre.setText(rs.getString("domaine_offre"));
                txtDebutOffre.setText(rs.getString("date_debut_offre"));
                txtDureeOffre.setText(rs.getString("duree_offre"));
                txtNomEntreprise.setText(rs.getString("nom_entreprise"));
                txtEmailEntreprise.setText(rs.getString("email_entreprise"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur chargement info offres : " + e.getMessage());
        }
    }

    private void gestionDesOffres() {
        new GestionDesOffres();
        this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConsulterOffre::new);
    }


}
