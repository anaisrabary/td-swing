package com.anaisrabary.insa.calculateurprix;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.text.NumberFormat;

import javax.swing.*;

public class CalculateurPrixView extends JFrame {

    private final CalculateurPrixPresenter presenter;

    private JTextField prixArticleTextField ;
    private JTextField quantiteArticleTextField ;
    private JFormattedTextField montantHTTextField ;

    public CalculateurPrixView() throws HeadlessException {
        super("Calculateur de prix");
        this.presenter = new CalculateurPrixPresenter(this);

        // creation Label et son Field ainsi que son ToolTipText
        JLabel prixArticleLabel = new JLabel("Prix d'un article (€) : ");
        prixArticleTextField = new JTextField(10);
        prixArticleLabel.setLabelFor(prixArticleTextField);
        prixArticleTextField.setToolTipText("Entrez ici le montant d'un article");

        JLabel quantiteArtilcleLabel = new JLabel("Quantite : ");
        quantiteArticleTextField = new JTextField(10);
        prixArticleLabel.setLabelFor(quantiteArticleTextField);
        prixArticleTextField.setToolTipText("Entrez ici la quantite d'un article");


        // Idem mais on formate la sortie du field
        JLabel montantHTLabel = new JLabel("Montant HT : ");
        montantHTTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        montantHTTextField.setValue(0.00);
        montantHTTextField.setEditable(false);
        montantHTLabel.setLabelFor(montantHTTextField);

            // Action Listernet sur le bouton calculer
        JButton computeButton = new JButton("Calculer");
        computeButton.addActionListener(e -> this.presenter.onComputeButtonClicked(prixArticleTextField.getText(), quantiteArticleTextField.getText()));

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.add(prixArticleTextField);
        contentPane.add(quantiteArticleTextField);

        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        labelPane.add(prixArticleLabel);
        labelPane.add(quantiteArtilcleLabel);
        labelPane.add(montantHTLabel);


        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(prixArticleTextField);
        fieldPane.add(quantiteArticleTextField);
        fieldPane.add(montantHTTextField);


        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, WEST);
        add(fieldPane, EAST);
        add(computeButton, SOUTH);

        prixArticleTextField.requestFocus();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void afficherErreur(String message) {
        showMessageDialog(this, message, "Erreur", ERROR_MESSAGE);
    }

    public void display() {
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void afficherResultat(double resultat) {
        montantHTTextField.setText(NumberFormat.getCurrencyInstance().format(resultat));

    }
}
