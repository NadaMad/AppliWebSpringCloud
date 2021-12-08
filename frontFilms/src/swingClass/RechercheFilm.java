package swingClass;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;

public class RechercheFilm {
    private JFrame frame;
    private JTextField recherche;
    private JRadioButton id;
    private JRadioButton touslesfilm;
    private JRadioButton titre;
    private JRadioButton sortie;
    private JRadioButton realisateur;
    private ButtonGroup group;
    private JTextArea textArea;
    private ClientCreate client= new ClientCreate();

    public RechercheFilm() {
        frame = new JFrame("Recherche");

        recherche = new JTextField ("");
        recherche.setBounds(128, 65, 86, 20);
        recherche.setColumns(10);


        JButton valider = new JButton("Rechercher");
        JButton retour = new JButton("Retour");

        retour.addActionListener(new RetourListener());
        valider.addActionListener(new RechercheListener());




        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 248, 247));



        touslesfilm = new JRadioButton("Tous les films");
        id = new JRadioButton("ID");
        titre = new JRadioButton("Titre");
        realisateur = new JRadioButton("Realisateur");
        sortie = new JRadioButton("Année Sortie");

        id.setSelected(true);
        panel.add(recherche);
        group = new ButtonGroup();
        group.add(touslesfilm);
        group.add(id);
        group.add(titre);
        group.add(realisateur);
        group.add(sortie);
        panel.add(touslesfilm);
        panel.add(id);
        panel.add(titre);
        panel.add(realisateur);
        panel.add(sortie);
        panel.add(valider);
        panel.add(retour);
        frame.add(panel);


        textArea = new JTextArea("Aucune recherche lancée.");
        textArea.setFont(new Font("Verdana", Font.PLAIN, 10));
        textArea.setPreferredSize(new Dimension(400, 450));
        textArea.setForeground(new Color(120, 90, 40));
        textArea.setBackground(new Color(100, 20, 70));
        Border border = BorderFactory.createLineBorder(Color.ORANGE);
        textArea.setBorder(border);
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        frame.add(textArea, BorderLayout.SOUTH);
        textArea.setBackground(Color.white);
        textArea.setOpaque(true);
        textArea.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 150));
        textArea.setEditable(false);

        frame.setPreferredSize(new Dimension(750, 750));

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);




    }

    private class RetourListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }

    }


    private class RechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements(); ) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    switch (button.getText()) {
                        case "ID":
                            try {
                                textArea.setText(client.getFilmByID(recherche.getText()));

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case "Tous les films":
                            try {
                                textArea.setText(client.getLesFilms());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case "Année Sortie":
                            try {
                                textArea.setText(client.getFilmByAnne(recherche.getText()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case "Titre":
                            try {
                                textArea.setText(client.getFilmByTitre(recherche.getText()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;

                        case "Realisateur":
                            try {
                                textArea.setText(client.getFilmByRealisateur(recherche.getText()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;

                    }
                }

            }
        }

    }



}