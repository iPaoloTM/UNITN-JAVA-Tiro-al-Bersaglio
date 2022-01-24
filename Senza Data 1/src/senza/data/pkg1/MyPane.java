/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senza.data.pkg1;

import java.util.Random;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Pannello principale con gestione di eventi da mouse
 * @author paoloaliprandi
 */
public class MyPane extends BorderPane {
    
    /**
     * raggio dei cerchi
     */ 
    public int r;
    /**
    * punteggio
    */
    public int p=0;
    
    
    double h;
    double w;
    
    /**
     * contenitore orizzontale superiore
    */
    public HBox top = new HBox();
    
    /**
    testo "punteggio"
    */
    public Text punteggio = new Text("Punteggio: ");
    /**
    testo "raggio"
    */
    public Text raggio=new Text("R: ");
    
    /**
    textfield per la stampa dei punti
    */
    public MyTextField points = new MyTextField("0");
    
    /**
    textfield per la lettura del raggio
    */
    public MyTextField radius = new MyTextField("45");
    
    /**
    pulsante reset
    */
    
    public Button reset = new Button("RESET");
    
    /**
    pulsante mira causale
    */
    
    public Button auto = new Button("Auto-Aim");
    
    /**
    pannello centrale grafico
    */
    
    public Pane pannello = new Pane();
    
    MyPane() {
        
        
        
        this.setCenter(pannello);
        pannello.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        pannello.setPrefSize(USE_PREF_SIZE, Double.MAX_VALUE);
    
        points.setDisable(true);
        
        //insets(down,sx,rx,top)
        
        points.setPadding(new Insets(5,5,5,5));
        
        reset.setPadding(new Insets(5,5,5,5));
        
        auto.setMinSize(50, 20);
        
        top.getChildren().addAll(punteggio, points, raggio, radius, reset,auto);
        
        this.setTop(top);
        
        //h=pannello.getHeight();
        //w=pannello.getWidth();
        
        initiate();

        reset.setOnAction(new EventHandler() {
            @Override
            
                /**
            *gestisce pressione pulsante resest 
            */
            public void handle(Event event) {
                
                clear();
                
               initiate();
            }
        });
        
        auto.setOnAction(new EventHandler() {
            @Override
           
            /**
            *gestisce pressione pulsante resest 
            */
            public void handle(Event event) {
               
               
                
              auto();
            }
        });
        
        
        pannello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            /**
            *gestisce click mouse
            */
            public void handle(MouseEvent t) {
                
                
                
                 Text text = new Text(t.getX(), t.getY(), "X");
                   
                 text.setFill(Color.WHITE);
                 pannello.getChildren().add(text);
                 
                 checkPunti(text);
                
            }
        });
    }
       
       /**
    *disegna i cerchi nel pannello
    */
    public void draw() {
        
     
        
        Circle c1 = new Circle(200,200,r);
        c1.setFill(Color.YELLOW);
        Circle c2 = new Circle(200,200,2*r);
        c2.setFill(Color.RED);
        Circle c3 = new Circle(200,200,3*r);
        c3.setFill(Color.BLUE);
        Circle c4 = new Circle(200,200,4*r);
        c4.setFill(Color.BLACK);
        
        pannello.getChildren().addAll(c4,c3,c2,c1);
    }
    
    /**
    *stampa il punteggio ottenuto poi lo azzera e ripulisce il pannello
    */
   
    public void clear() {
        
    
    
        pannello.getChildren().clear();
        System.out.println("Punteggio: "+p);
        points.setText("0");
        p=0;
    }
      /**
    *aggiorna il conteggio dei punti
    @param t la "x" aggiunta al pannello
    */
    public void checkPunti(Text t) {
       
       
        
        Double distance= Math.sqrt(Math.pow(t.getX()-200, 2) + Math.pow(t.getY()-200, 2));
        
        int distance1= r;
        int distance2=2*r;
        int distance3=3*r;
        int distance4=4*r;
        
        if (distance>distance4) p+=0;
        else if ((distance > distance3) && (distance < distance4)) p+=1;
        else if ((distance > distance2) && (distance < distance3)) p+=10;
        else if ((distance > distance1) && (distance < distance2)) p+=100;
        else p+=1000;
        
        points.setText(p+"");
    }
    
    /**
         * inizializza
         */
    
    public void initiate() {
        
        
     try {  
                r=Integer.parseInt(radius.getText());
                } catch(NumberFormatException ex) {
                System.out.println("serve un numero");
                }
                
                draw();
    }
    
     
         /**
    *spara a caso
    */
    public void auto() {
       
   
    Random generatore = new Random(System.currentTimeMillis());
    
    int ax=generatore.nextInt(400);
    int ay=generatore.nextInt(400);
    
    Text text = new Text(ax, ay, "X");
                   
                 text.setFill(Color.WHITE);
                 pannello.getChildren().add(text);
                 
                 checkPunti(text);
    
    }
}
