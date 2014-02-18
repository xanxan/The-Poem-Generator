/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sovelluslogiikka.Hallinto;

/**
 * Luokka toteuttaa graafisen sivukäyttöliittymän, jossa uusi sana lisätään varastoon.
 * @author anna
 */
public class SananTallennusKayttoliittyma implements Runnable {
    private JFrame frame;
    private Hallinto hallinto;
    private JButton lisaaNappi;
    private JLabel tulos;
    
    public SananTallennusKayttoliittyma(Hallinto hallinto) {
        this.hallinto = hallinto;
    }

    @Override
    public void run() {
        frame = new JFrame("Add a new word");
        frame.setPreferredSize(new Dimension(800, 200));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Metodi luo sivukäyttöliittymän tarvitsemat komponentit ja 
     * tapahtumankuuntelijat sekä lisää ne liittymään.
     * 
     * @param container Container
     *
     */
    private void luoKomponentit(Container container) {
         GridLayout layout = new GridLayout(3, 2);
         container.setLayout(layout);

         JLabel sanaTeksti = new JLabel("New word: ");
         JTextField sanaKentta = new JTextField();
         JLabel tiedostoTeksti = new JLabel("Target class: ");
         JTextField tiedostoKentta = new JTextField();

         
   
         container.add(sanaTeksti);
         container.add(sanaKentta);
         container.add(tiedostoTeksti);
         container.add(tiedostoKentta);
         container.add(nappiJaTulos());
         
         
         Sanantallentaja tallentaja = new Sanantallentaja(hallinto, sanaKentta, tiedostoKentta, this.tulos);
         lisaaNappi.addActionListener(tallentaja);

    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Metodi luo layoutin layoutin sisälle, joka sisältää toimintanapin ja
     * alueen joka myöhemmin ilmoittaa suorituksen onnistumisesta.
     * 
     * @return panel palauttaa uuden ja muokatun JPanelin.
     *
     */
    private JPanel nappiJaTulos() {
        JPanel panel = new JPanel(new GridLayout(1,2));
        this.lisaaNappi = new JButton("Add a new word!");
        this.tulos = new JLabel("");
        
        panel.add(tulos);
        panel.add(lisaaNappi);
        
        return panel;
    }
    
}
