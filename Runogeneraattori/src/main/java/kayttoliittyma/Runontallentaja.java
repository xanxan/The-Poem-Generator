/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import sovelluslogiikka.Hallinto;

/**
 * Luokka käynnistää tiedostotallennuksen suorrittavan graafisen käyttöliittymän
 * ja antaa sille talletettavan tiedoston.
 * @author anna
 */
public class Runontallentaja implements ActionListener {
    
    private Hallinto hallinto;
    private String runo;
    

    public Runontallentaja(Hallinto hallinto, String runo) {
        
        this.hallinto = hallinto;
        this.runo = runo;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      
            SwingUtilities.invokeLater(new Runnable() {

            @Override
	    public void run() {
                    try {
                        Tiedostontallentaja tiedostontallentaja = new Tiedostontallentaja(runo, hallinto.getKirjaaja());
                    } catch (IOException ex) {
                        Logger.getLogger(Runontallentaja.class.getName()).log(Level.SEVERE, null, ex);
                    }
	    }
          });
            
        
    }
    
}
