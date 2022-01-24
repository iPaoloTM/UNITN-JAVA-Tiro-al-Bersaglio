/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senza.data.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * lancia l'applicazione
 * @author paoloaliprandi
 */
public class SenzaData1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       
        MyPane pane = new MyPane();
        Scene scene = new Scene(pane,400,400);
        
        pane.h=scene.getHeight();
        pane.w=scene.getWidth();
        
        
        primaryStage.setTitle("Tiro al bersaglio!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
