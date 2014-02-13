/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import sovelluslogiikka.Hallinto;

/**
 * ActionListener -luokka, joka  käynnistää sanan tallennukseen tarkoitetun käyttöliittymän.
 * @author anna
 */
public class Tallennuksenkaynnistaja implements ActionListener {
    private Hallinto hallinto;
    
    public Tallennuksenkaynnistaja(Hallinto hallinto) {
        this.hallinto = hallinto;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        SananTallennusKayttoliittyma kayttoliittyma = new SananTallennusKayttoliittyma(hallinto);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
}
