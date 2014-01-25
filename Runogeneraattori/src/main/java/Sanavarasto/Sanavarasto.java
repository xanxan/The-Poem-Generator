/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanavarasto;

import java.io.File;

/**
 *
 * @author anna
 */
public class Sanavarasto {
    private File substantiivit;
    private File adjektiivit;
    private File verbit;
    private File numeraalit;
    private File partikkelit;
    private File pronominit;
          
    public Sanavarasto() {
        this.adjektiivit = new File("adjektiivit.txt");
        this.substantiivit = new File("substantiivit.txt");
        this.verbit = new File("verbit.txt");
        this.numeraalit = new File("numeraait.txt");
        this.partikkelit = new File("partikkelit.txt");
        this.pronominit = new File("pronominit.txt");
    }
    
    public File getSubstantiivit() {
        return this.substantiivit;
    }
    
    public File getAdjektiivit() {
        return this.adjektiivit;
    }
    
    public File getVerbit() {
        return this.verbit;
    }
    
    public File getNumeraalit() {
        return this.numeraalit;
    }
    
    public File getPartikkelit() {
        return this.partikkelit;
    }
    
    public File getPronominit() {
        return this.pronominit;
    }
}
