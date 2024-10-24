package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.FireWand;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label title;
    @FXML
    private TextField txtInput;
    @FXML
    private Button main;


    //---//
    MagicCharacter currentPlayer;

    public void initialize(){
        new FireWand();
    }
    @FXML
    protected void mainOnClick() {

    }
}