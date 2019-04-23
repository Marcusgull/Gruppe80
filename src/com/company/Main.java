package com.company;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
	System.out.println("HEI GRUPPE80");
        System.out.println("heihei"); 
        
        Arbeidsgiver a1 = new Arbeidsgiver("slottet", "mat", "email@email.no", "99922999");
        
        System.out.println(a1.getBransje());
        
        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
