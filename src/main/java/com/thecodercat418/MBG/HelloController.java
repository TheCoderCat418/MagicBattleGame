package com.thecodercat418.MBG;

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

    @FXML
    protected void mainOnClick() {
        title.setText(txtInput.getText());
        System.out.println(txtInput.getText());
    }
}