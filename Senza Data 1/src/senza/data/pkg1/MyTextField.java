/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senza.data.pkg1;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;

/**
 * TextField con insets e massima estensione fissati
 * @author paoloaliprandi
 */
public class MyTextField extends TextField {
    
     MyTextField(String s) {
        super(s);
        
        this.setPadding(new Insets(5,5,5,5));
        this.setMaxWidth(80);
    }
    
}
