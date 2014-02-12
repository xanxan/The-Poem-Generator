/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 *
 * @author anna
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Tiedostontallentaja extends JFrame {

	private JButton buttonBrowse;
        private File tiedosto;

	public Tiedostontallentaja(File tiedosto) {
		super("Save File");
		setLayout(new FlowLayout());
		buttonBrowse = new JButton("Save...");
		buttonBrowse.addActionListener(new ActionListener() {

                 @Override
                public void actionPerformed(ActionEvent arg0) {
                    NaytaSaveFile();
                }
		});
		getContentPane().add(buttonBrowse);
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

//	
	private void NaytaSaveFile() {
		JFileChooser tiedostonvalitsija = new JFileChooser(tiedosto);
		tiedostonvalitsija.setDialogTitle("Specify a file to save");

		int kayttajaValitsee = tiedostonvalitsija.showSaveDialog(this);
		if (kayttajaValitsee == JFileChooser.APPROVE_OPTION) {
			File talletettava = tiedostonvalitsija.getSelectedFile();
			System.out.println("Save as file: " + talletettava.getAbsolutePath());
		}
	}
}
