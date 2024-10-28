package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.FireWand;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private Label title;
    @FXML
    private TextField txtInput;
    @FXML
    private Button main;
    @FXML
    private AnchorPane battleAbilities;
    @FXML
    private Slider battleSlider;

    //---//
    MagicCharacter currentPlayer;
    BaseCharacter currentEnemy;

    public void initialize(){
         battleSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            miniScreenSwitcher(newValue.intValue());
         });





        battleSlider.setValue(3.0);
        BaseCharacter enemyCharacter = new BaseCharacter();
        currentPlayer = new MagicCharacter();
        currentPlayer.addWand(new FireWand());
        currentPlayer.castSpell("Fire Ball", enemyCharacter);
        System.out.println(enemyCharacter.getHealth());
    }
    public void loadBattle(BaseCharacter enemy){
        














    }


    public void miniScreenSwitcher(int screenId){
        battleAbilities.setVisible(false);
        //Screen 1: Abilities
        if(screenId == 1){
            battleAbilities.setVisible(true);
        }else{

        }
    }





    @FXML
    protected void mainOnClick() {

    }
}