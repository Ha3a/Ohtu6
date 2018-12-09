/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Harri
 */
public class Erotus implements Komento{
    TextField tuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    int edellinenArvo;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        int arvo = Integer.parseInt(syotekentta.getText());
        edellinenArvo = arvo;
        sovellus.miinus(arvo);
        tuloskentta.setText("" + sovellus.tulos());
        syotekentta.setText("");
        undo.disableProperty().set(false);
        nollaa.disableProperty().set(false);
    }

    @Override
    public void peru() {
        sovellus.plus(edellinenArvo);
        tuloskentta.setText("" + sovellus.tulos());
        syotekentta.setText("");
    }

}

