package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXMLController {

    public void hei(){
        System.out.println("hei!");
    }
    @FXML
    private void vedKlikk(ActionEvent event){
        System.exit(0);
    }
    public void initialize() {

    }
}
