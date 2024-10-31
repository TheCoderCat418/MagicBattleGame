package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.FireWand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
    @FXML
    private Label enemyName;
    @FXML
    private Button MA1;
    @FXML
    private Button MA2;
    @FXML
    private Button MA3;
    @FXML
    private Button MA4;
    @FXML
    private ProgressBar playerHealthBar;
    @FXML
    private ProgressBar playerManaBar;
    @FXML
    private ProgressBar enemyHealthBar;
    @FXML
    private Label playerHealth;
    @FXML
    private Label enemyHealth;
    @FXML
    private Label playerMana;


    // ---//
    MagicCharacter currentPlayer;
    BaseCharacter currentEnemy;

    public void initialize() {
        battleSlider.valueProperty().addListener((_, _, newValue) -> {
            miniScreenSwitcher(newValue.intValue());
        });

        battleSlider.setValue(3.0);
        currentEnemy = new BaseCharacter("Enemy");

        currentPlayer = new MagicCharacter();
        currentPlayer.addWand(new FireWand());
        loadBattle(currentEnemy);
        updateStats();
    }
    public void useAbility(ActionEvent aEvent){
        Button button = (Button) aEvent.getSource();
        if(button.getText().equals("Do Nothing")){
            enemyTurn();
            updateStats();
            return;
        }
        if(currentPlayer.castSpell(button.getText(), currentEnemy) == -1){
            //Not enough mana
        }
        updateStats();
        enemyTurn();
    }

    public void updateStats(){
        playerHealth.setText(Integer.toString(currentPlayer.getHealth()));
        playerHealthBar.setProgress((currentPlayer.getHealth()+0.0)/currentPlayer.getMaxHealth());
        enemyHealthBar.setProgress((currentEnemy.getHealth()+0.0)/currentEnemy.getMaxHealth());
        enemyHealth.setText(Integer.toString(currentEnemy.getHealth()));
        playerManaBar.setProgress((currentPlayer.getMana()+0.0)/10);
        playerMana.setText(Integer.toString(currentPlayer.getMana()));
    }
    public void enemyTurn(){
        currentPlayer.startTurn();
        updateStats();
    }
    public void loadBattle(BaseCharacter enemy) {
        enemyName.setText(enemy.getName());
        int track = 1;
        for (Spell spell : currentPlayer.getCurrentWand().getSpells()) {
            // MUST IMPLEMENT SPELL EFFECT FOR PROPER COOLDOWN TRACKING
            Button button = null;
            switch (track) {
                case 1:
                    button = MA1;
                    break;
                case 2:
                    button = MA2;
                    break;
                case 3:
                    button = MA3;
                    break;
                case 4:
                    button = MA4;
                    break;
            }
            button.setText(spell.spellName);
            button.setDisable(false);
            if (spell.wandLevelNeeded > currentPlayer.getCurrentWand().getWandLevel()) {
                button.setDisable(true);
            }
            track++;
        }

    }

    public void miniScreenSwitcher(int screenId) {
        battleAbilities.setVisible(false);
        // Screen 1: Abilities
        if (screenId == 1) {
            battleAbilities.setVisible(true);
        } else {

        }
    }
}