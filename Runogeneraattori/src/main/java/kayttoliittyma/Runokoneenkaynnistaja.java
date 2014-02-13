/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import sovelluslogiikka.Hallinto;
import sovelluslogiikka.Tiedostonlukija;
/**
 * ActionListener -luokka, jonka tehtävänä on käynnistää runokone ja 
 * lisätä toiminnankuuntelija tallennusnappiin.
 * @author anna
 */
public class Runokoneenkaynnistaja implements ActionListener {
    
    private JTextArea kohde;
    private JButton save;
    private Container container;
    private Hallinto hallinto;
    private String runo;


    public Runokoneenkaynnistaja(JTextArea kohde, Container container, JButton save, Hallinto hallinto) {
        this.save = save;
        this.kohde = kohde;
        this.container = container;
        this.hallinto = hallinto;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            this.runo = " " + '\n' + this.hallinto.kaynnistaRunokone();
            Tiedostonlukija lukija = this.hallinto.getLukija();
          
            
            
            this.kohde.setText(runo);
            this.save.setEnabled(true);
            this.save.addActionListener(new Runontallentaja(container, hallinto, runo));
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Runokoneenkaynnistaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getRuno() {
        return this.runo;
    }
}