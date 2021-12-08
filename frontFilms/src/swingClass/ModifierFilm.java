package swingClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModifierFilm {
    private JFrame frame;
    private JTextField idtxt;
    private  JTextField titretxt;
    private JTextField realisateurtxt;
    private  JTextField sortitxt;
    private ClientCreate clientCreate = new ClientCreate();



    public ModifierFilm() {
        frame = new JFrame("Modifier Film");

        JLabel id = new JLabel ("ID");
        id.setBounds(65, 80, 46, 14);
        frame.getContentPane().add(id);
        idtxt = new JTextField("");
        idtxt.setBounds(140, 80, 86, 20);
        frame.getContentPane().add(idtxt);
        idtxt.setColumns(10);


        JLabel titre = new JLabel("Titre");
        titre.setBounds(65, 115, 46, 14);
        frame.getContentPane().add(titre);
        titretxt = new JTextField("");
        titretxt.setBounds(140, 112, 86, 20);
        frame.getContentPane().add(titretxt);
        titretxt.setColumns(10);


        JLabel real = new JLabel("Realisateur");
        real.setBounds(65, 162, 46, 14);
        frame.getContentPane().add(real);
        realisateurtxt = new JTextField("");
        realisateurtxt.setBounds(140, 157, 100, 20);
        frame.getContentPane().add(realisateurtxt);
        realisateurtxt.setColumns(10);

        JLabel sortie = new JLabel("Année sortie");
        sortie.setBounds(65, 200, 89, 23);
        frame.getContentPane().add(sortie);
        sortitxt = new JTextField("");
        sortitxt.setBounds(140, 200, 86, 20);
        frame.getContentPane().add(sortitxt);
        sortitxt.setColumns(10);



        JButton valider = new JButton("Valider modification");
        frame.add(valider, BorderLayout.SOUTH);

        valider.addActionListener(new UpdateListener());








        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 248, 247));


        frame.add(panel);

        //  panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 150));


        frame.setPreferredSize(new Dimension(500, 500));

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
    private class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                clientCreate.update(idtxt.getText(),titretxt.getText(),realisateurtxt.getText(),sortitxt.getText());
                System.out.println("sinde");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame.setVisible(false);
        }

    }
}

