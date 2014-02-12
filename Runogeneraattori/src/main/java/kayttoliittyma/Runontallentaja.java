/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import sovelluslogiikka.Hallinto;
import sovelluslogiikka.Tiedostonkirjaaja;

/**
 *
 * @author anna
 */
public class Runontallentaja implements ActionListener {
    
   
    private Container container;
    private Hallinto hallinto;
    private String runo;
    private Tiedostonkirjaaja kirjaaja;

    public Runontallentaja(Container container, Hallinto hallinto, String runo) {
        
        this.container = container;
        this.hallinto = hallinto;
        this.runo = runo;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kirjaaja = this.hallinto.getKirjaaja();
        try {
            String tiedostonimi = "runo.txt";
            
            final File tiedosto = this.kirjaaja.luoTiedostoksi(tiedostonimi, runo);
            try {
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) { }

            SwingUtilities.invokeLater(new Runnable() {

            @Override
	    public void run() {
                Tiedostontallentaja tiedostontallentaja = new Tiedostontallentaja(tiedosto);
	    }
          });
            
            kirjaaja.tyhjennaLista(tiedosto);
        } catch (IOException ex) {
            Logger.getLogger(Runontallentaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
