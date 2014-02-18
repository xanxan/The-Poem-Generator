/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 * JFramen perivä luokka, joka toteuttaa JFileChooserin ja tallettaa sen avulla tiedoston käyttäjän koneelle haluttuun kansioon.
 * @author anna
 */
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import sovelluslogiikka.Tiedostonkirjaaja;

public class Tiedostontallentaja extends JFrame {

	
        private File tiedosto;
        private Tiedostonkirjaaja kirjaaja;
        private String runo;

	public Tiedostontallentaja(String runo, Tiedostonkirjaaja kirjaaja) throws IOException {
            this.kirjaaja = kirjaaja;
            this.runo = runo;
            naytaSaveFile();
                
	}

        /**
         * Metodi avaa Hakemistonäkymän ja suorittaa tallennuksen.
         *
         */
	private void naytaSaveFile() throws IOException {
		JFileChooser tiedostonvalitsija = new JFileChooser(tiedosto);
		tiedostonvalitsija.setDialogTitle("Specify a file to save");

		int kayttajaValitsee = tiedostonvalitsija.showSaveDialog(this);
		if (kayttajaValitsee == JFileChooser.APPROVE_OPTION) {
			File talletettava = tiedostonvalitsija.getSelectedFile();
                        this.kirjaaja.kirjoitaTiedostoon(talletettava, runo);
                }
	}
}
