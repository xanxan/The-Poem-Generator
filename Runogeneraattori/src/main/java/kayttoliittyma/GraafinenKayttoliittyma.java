/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 *
 * @author anna
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;

    public GraafinenKayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Poem generator");
        frame.setPreferredSize(new Dimension(700, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(5, 2));
        JLabel teksti = new JLabel("Welcome to the poem generator!");
        container.add(teksti);
        JButton nappi = new JButton("Let's write a poem!");
        JTextArea textArea = new JTextArea();
        JButton save = new JButton("Save the poem");
         nappi.addActionListener(new Toiminnankuuntelija(textArea, container, save));
        container.add(nappi);
        
        container.add(textArea);
//        JButton button = new JButton("Add a new word");
//        container.add(button);
        
//        
    }

    public JFrame getFrame() {
        return frame;
    }
}
