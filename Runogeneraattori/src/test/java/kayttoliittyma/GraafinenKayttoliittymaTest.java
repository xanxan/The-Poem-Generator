/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.io.FileNotFoundException;
import org.junit.Test;
import sovelluslogiikka.Arpoja;
import sovelluslogiikka.Hallinto;
import sovelluslogiikka.Tiedostonkirjaaja;
import sovelluslogiikka.Tiedostonlukija;

/**
 *
 * @author anna
 */
public class GraafinenKayttoliittymaTest {
    private Arpoja arpoja;
    private Tiedostonlukija lukija;
    private Tiedostonkirjaaja kirjaaja;
    private Hallinto hallinto;
    private GraafinenKayttoliittyma liittyma;
    
    public GraafinenKayttoliittymaTest() throws FileNotFoundException {
        this.arpoja = new Arpoja();
        this.lukija = new Tiedostonlukija();
        this.kirjaaja = new Tiedostonkirjaaja(lukija);
        this.hallinto = new Hallinto(lukija, kirjaaja, arpoja);
        this.liittyma = new GraafinenKayttoliittyma(hallinto);
    }
    
    
     @Test
     public void GraafinenKayttoliittymaRunToimii() {
     
         
     }
}
