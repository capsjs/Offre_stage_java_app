package interfaces;

import bdd.Connecter;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class GestionDesOffres extends JFrame {

    private JPanel jpanel1;
    private JLabel jlabel1, txtId, txtIdRecupere;
    private JButton boutonSaisir, boutonCreer, boutonModifier, boutonConsulter, boutonAnnuler;

    private Connection con;

    public GestionDesOffres() {
        con = Connecter.connecter();

        initComponents();

        this.setTitle("Administration des offres de stage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(jpanel1);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {
        jpanel1 = new JPanel(null);
        jpanel1.setBackground(new Color(172, 197, 205));
        jpanel1.setPreferredSize(new Dimension(700, 450));

        jlabel1 = new JLabel("Administration des offres de stage");
        jlabel1.setFont(new Font("Verdana", Font.BOLD, 14));
        jlabel1.setBounds(180, 20, 350, 30);
        jpanel1.add(jlabel1);

        txtId = new JLabel("identifiant");
        txtId.setBounds(10, 60, 100, 20);
        jpanel1.add(txtId);

        txtIdRecupere = new JLabel("manon");
        txtIdRecupere.setBounds(120, 60, 200, 20);
        jpanel1.add(txtIdRecupere);

        boutonSaisir = new JButton("Saisir une offre");
        boutonSaisir.setBounds(80, 140, 150, 30 );
        jpanel1.add(boutonSaisir);

        boutonCreer = new JButton("Créer une entreprise");
        boutonCreer.setBounds(280, 140, 180, 30 );
        jpanel1.add(boutonCreer);

        boutonConsulter = new JButton("Consulter les offres");
        boutonConsulter.setBounds(80, 220, 150, 30 );
        jpanel1.add(boutonConsulter);

        boutonModifier = new JButton("Modifier une entreprise");
        boutonModifier.setBounds(280, 220, 180, 30 );
        jpanel1.add(boutonModifier);

        boutonAnnuler = new JButton("Annuler");
        boutonAnnuler.setBounds(200, 300, 150, 30 );
        jpanel1.add(boutonAnnuler);

        boutonSaisir.addActionListener(e -> saisirOffre());
        boutonCreer.addActionListener(e -> creerEntreprise());
        boutonConsulter.addActionListener(e -> consulterOffres());
        boutonModifier.addActionListener(e -> modifierEntreprise());
        boutonAnnuler.addActionListener(e -> this.dispose());
    }

    private void saisirOffre() {
        new AdminCreerOffre();
        this.setVisible(false);
    }

    private void creerEntreprise() {
        new CreerEntreprise();
        this.setVisible(false);
    }

    private void consulterOffres() {
        new ConsulterOffre();
        this.setVisible(false);
    }

    private void modifierEntreprise() {
        new ModifierEntreprise();
        this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestionDesOffres::new);
    }
}
