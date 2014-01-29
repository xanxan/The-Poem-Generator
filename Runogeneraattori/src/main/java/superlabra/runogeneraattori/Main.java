/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superlabra.runogeneraattori;


import Sovelluslogiikka.Arpoja;
import Sovelluslogiikka.Hallinto;
import Sovelluslogiikka.Runokone;
import Sovelluslogiikka.Syotteenlukija;
import Sovelluslogiikka.Tiedostonkirjaaja;
import Sovelluslogiikka.Tiedostonlukija;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;


/**
 *
 * @author anna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
       Syotteenlukija lukija = new Syotteenlukija();
      
       Arpoja arpoja = new Arpoja();
       
       Tiedostonlukija l = new Tiedostonlukija();
        Tiedostonkirjaaja kirjaaja = new Tiedostonkirjaaja(l);
        Runokone runokone = new Runokone(arpoja, kirjaaja, l);
        Hallinto hallinto = new Hallinto(l, kirjaaja, arpoja);
        
        hallinto.alustaOhjelma();
        
        System.out.println("Tulostetaan runo:");
        File runo = runokone.kirjoitaRuno();
        
        l.tulostaTiedosto(runo);
    }
}
