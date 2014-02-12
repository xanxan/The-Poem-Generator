/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sovelluslogiikka.Hallinto;
import sovelluslogiikka.Tiedostonkirjaaja;

/**
 *
 * @author anna
 */
public class Sanantallentaja implements ActionListener {
    private Container container;
    private Hallinto hallinto;
    private Tiedostonkirjaaja kirjaaja;
    private JTextField sana;
    private File tiedosto;
    private JTextField tiedostonimi;
    private JLabel tulos;
    
    public Sanantallentaja(Container container, Hallinto hallinto, JTextField sana, JTextField tiedostonimi, JLabel tulos) {
        this.container = container;
        this.hallinto = hallinto;
        this.kirjaaja = hallinto.getKirjaaja();
        this.sana = sana;
        this.tiedostonimi = tiedostonimi;
        this.tulos = tulos;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.tiedosto = new File(tiedostonimi.getText() + ".txt");
       
        try {
           boolean onnistui  =  this.kirjaaja.lisaaSana(tiedosto, sana.getText());
           if (onnistui) {
               this.tulos.setText("Action completed!");
           } else {
               this.tulos.setText("The word already exists!");
           }
           
        } catch (IOException ex) {
            this.tulos.setText("Action failed: File not found.");
            Logger.getLogger(Sanantallentaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
