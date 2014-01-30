/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.Random;

/**
 *
 * @author anna
 */
public class Arpoja {
    private int luku = 0;
    private Random arpoja;
    
    public Arpoja() {
        arpoja = new Random();
    }
    
    public int SatunnainenLuku(int ylaraja) {
        
        luku = arpoja.nextInt(ylaraja);
        
        return luku;
    }
}