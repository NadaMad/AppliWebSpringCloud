package swingClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Classe swingClass.Application pour gerer l'interface de l'application
 * */

public class MainApplication {
    private JFrame frame;

    public MainApplication() {
        frame = new JFrame("Gestion des films");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem quitter = new JMenuItem("Quitter");
        menuBar.add(menu);
        menu.add(quitter);
        quitter.addActionListener(new CloseListener());
        JButton ajouter = new JButton("Ajouter film");



        ajouter.setBackground(new Color(235, 220, 216));
        ajouter.setOpaque(true);
        ajouter.addActionListener(new AddListener());

        JButton rechercher = new JButton("Chercher film");



        rechercher.setBackground(new Color(235, 220, 216));
        rechercher.setOpaque(true);
        rechercher.addActionListener(new SearchListener());

        JButton supprimer = new JButton("Supprimer film");
        supprimer.setBackground(new Color(235, 220, 216));
        supprimer.setOpaque(true);
        supprimer.addActionListener(new DeleteListener());

        JButton modifer = new JButton("Modifier film");
        modifer.setBackground(new Color(235, 220, 216));
        modifer.setOpaque(true);
        modifer.addActionListener(new EditListener());


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(menuBar, BorderLayout.NORTH);





        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 248, 247));
        panel.add(ajouter);
        panel.add(rechercher);
        panel.add(supprimer);
        panel.add(modifer);

        frame.add(panel);

      //  panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 150));


        frame.setPreferredSize(new Dimension(400, 400));

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);




    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);
        }
    }
    private class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            AjouterFilm ajouterFilm =new AjouterFilm();

        }

    }
    private class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            RechercheFilm rechercheFilm =new RechercheFilm();
        }

    }
    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            SupprimerFilm supprimerFilm = new SupprimerFilm();
        }

    }

    private class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ModifierFilm modifierFilm =new ModifierFilm();
        }

    }
}
