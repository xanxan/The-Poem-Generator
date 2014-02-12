/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superlabra.runogeneraattori;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.SwingUtilities;
import kayttoliittyma.GraafinenKayttoliittyma;
import sovelluslogiikka.Arpoja;
import sovelluslogiikka.Hallinto;
import sovelluslogiikka.Tiedostonkirjaaja;
import sovelluslogiikka.Tiedostonlukija;

/**
 *Luokka käynnistää hallinnon sekä hoitaa ohjelman
 *ja käyttäjän välisen kommunikaation.
 * 
 * @author anna
 */
public class Kayttoliittyma {
    
    public Kayttoliittyma() {
        
    }
    /**
     * Metodi käynnistää käyttöliittymän ja luo tarvittavat oliot.
     * 
     * 
     * 
     */
    public void kaynnista() throws FileNotFoundException {
        
        Arpoja arpoja = new Arpoja();
        Tiedostonlukija lukija = new Tiedostonlukija();
        Tiedostonkirjaaja kirjaaja = new Tiedostonkirjaaja(lukija);
        Hallinto hallinto = new Hallinto(lukija, kirjaaja, arpoja);
        
        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(hallinto);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
}
