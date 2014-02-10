/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 *
 * @author anna
 */
public class Toiminnankuuntelija implements ActionListener {
    
    private JTextArea kohde;
    private JButton save;
    private Container container;

    public Toiminnankuuntelija(JTextArea kohde, Container container, JButton save) {
        this.save = save;
        this.kohde = kohde;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kohde.setText("runo");
        container.add(save);
    }
}
