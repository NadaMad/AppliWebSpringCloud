package swingClass;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;

public class SupprimerFilm {
    private JFrame frame;
    private JTextField supprimer;
    private JLabel id;
    private ClientCreate client;


    public SupprimerFilm() {
        client = new ClientCreate();
        frame = new JFrame("Supprimer");

        supprimer = new JTextField ("");
        supprimer.setBounds(128, 65, 86, 20);
        supprimer.setColumns(10);


        JButton valider = new JButton("Supprimer");
        JButton retour = new JButton("Retour");
        valider.addActionListener(new SupprimerListener());


        retour.addActionListener(new RetourListener());



        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 248, 247));


        id = new JLabel("ID");
        panel.add(supprimer);
        panel.add(id);
        panel.add(valider);
        panel.add(retour);


        frame.add(panel);

        frame.setPreferredSize(new Dimension(150, 150));

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

    private class SupprimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                            try {
                                client.deleteByID(supprimer.getText());
                                frame.setVisible(false);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

        }
    }
}
