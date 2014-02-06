/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.Scanner;

/**
 * Luokka lukee ja palauttaa käyttäjän antaman syötteen.
 * 
 *
 * @author anna
 */
public class Syotteenlukija {
    private Scanner lukija;
    
    public Syotteenlukija() {
        this.lukija = new Scanner(System.in);
    }
    /**
     * Metodi palauttaa lukijan antaman syötteen.
     * 
     * 
     * 
     */
    public String LueSyote() {
        String syote = this.lukija.nextLine();
        
        return syote;
    }
}
