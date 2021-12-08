package swingClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AjouterFilm {
    private JFrame frame;
    private JTextField titretxt;
    private JTextField realisateurtxt;
    private JTextField sortitxt;
    private ClientCreate clientCreate= new ClientCreate();


    public AjouterFilm() {
        frame = new JFrame("Ajouter un film");
        JLabel frameTitle = new JLabel("Ajouter un film");
        frame.add(frameTitle);


        JLabel titre = new JLabel("Titre");
        titre.setBounds(65, 115, 46, 14);
        frame.getContentPane().add(titre);
        titretxt = new JTextField("");
        titretxt.setBounds(150, 112, 86, 20);
        frame.getContentPane().add(titretxt);
        titretxt.setColumns(10);


        JLabel real = new JLabel("Realisateur");
        real.setBounds(65, 162, 100, 14);
        frame.getContentPane().add(real);
        realisateurtxt = new JTextField("");
        realisateurtxt.setBounds(150, 157, 86, 20);
        frame.getContentPane().add(realisateurtxt);
        realisateurtxt.setColumns(10);

        JLabel sortie = new JLabel("Année sortie");
        sortie.setBounds(65, 200, 100, 23);
        frame.getContentPane().add(sortie);
        sortitxt = new JTextField("");
        sortitxt.setBounds(150, 200, 86, 20);
        frame.getContentPane().add(sortitxt);
        sortitxt.setColumns(10);


        JButton valider = new JButton("Valider");
        frame.add(valider, BorderLayout.SOUTH);

        valider.addActionListener(new AjouterListener());


        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 248, 247));


        frame.add(panel);

        //  panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 150));


        frame.setPreferredSize(new Dimension(350, 350));

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);


    }

    private class AjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                clientCreate.add(titretxt.getText(),realisateurtxt.getText(),sortitxt.getText());
                frame.setVisible(false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
}