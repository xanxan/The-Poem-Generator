/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.util.Random;

/**
 *
 * @author anna
 */
public class Arpoja {
    private int luku;
    private Random arpoja;
    
    public Arpoja() {
        arpoja = new Random();
    }
    
    public int SatunnainenLuku(int ylaraja) {
        luku = arpoja.nextInt(ylaraja);
        return luku;
    }
}