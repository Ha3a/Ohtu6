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
public class Nollaa implements Komento {

    TextField tuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    int edellinenArvo;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenArvo = sovellus.tulos();
        sovellus.nollaa();
        tuloskentta.setText("" + sovellus.tulos());
        syotekentta.setText("");
        undo.disableProperty().set(false);
        nollaa.disableProperty().set(true);
    }

    @Override
    public void peru() {
        sovellus.asetaArvo(edellinenArvo);
        tuloskentta.setText("" + sovellus.tulos());
        syotekentta.setText("");
    }

}
