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
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import sovelluslogiikka.Hallinto;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private JButton save;
    private JButton button;
    private JButton add;
    private Hallinto hallinto;
    private JTextArea teksti;
    private Runokoneenkaynnistaja runonkaynnistaja;
    private Sanantallentaja tallentaja;

    public GraafinenKayttoliittyma(Hallinto hallinto) {
        this.hallinto = hallinto;
    }

    @Override
    public void run() {
        frame = new JFrame("Poem generator");
        frame.setPreferredSize(new Dimension(750, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
            luoKomponentit(frame.getContentPane());
        
            
        

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container)  {
        this.teksti = new JTextArea();
        JLabel sivupalkki = new JLabel("                                                    ");
        
        container.setBackground(Color.WHITE);
        
        container.add(luoOtsikko(), BorderLayout.NORTH);
        container.add(sivupalkki, BorderLayout.WEST);
        container.add(this.teksti, BorderLayout.CENTER);
        container.add(valikko(), BorderLayout.SOUTH);
        
        this.runonkaynnistaja = new Runokoneenkaynnistaja(teksti, container, save, hallinto);
        Tallennuksenkaynnistaja kaynnistaja = new Tallennuksenkaynnistaja(hallinto);
        
        this.button.addActionListener(this.runonkaynnistaja);
        this.add.addActionListener(kaynnistaja);

        
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private JPanel luoOtsikko() {
        JPanel panel = new JPanel(new GridLayout(1,3));
        
        panel.add(new JLabel(""));
        panel.add(new JLabel("Welcome to the poem generator!"));
        panel.add(new JLabel(""));
        
        return panel;
                
    }
    
  
    
    private JPanel valikko() {
        JPanel panel = new JPanel(new GridLayout(1,3));
        this.save = new JButton("Save the poem");
        this.button = new JButton("Let's write a poem!");
        this.add = new JButton("Add a new word");
        
        panel.add(add);
        panel.add(button);
        panel.add(this.save);
        this.save.setEnabled(false);
        
        
        return panel;
    }
    
    
    
     
    
}
