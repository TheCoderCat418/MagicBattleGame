package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.FireWand;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    private AnchorPane battleAbilities;
    private Slider battleSlider;
    private Label enemyName;
    private Button MA1;
    private Button MA2;
    private Button MA3;
    private Button MA4;
    private ProgressBar playerHealthBar;
    private ProgressBar playerManaBar;
    private ProgressBar enemyHealthBar;
    private Label playerHealth;
    private Label enemyHealth;
    private Label playerMana;
    private Label statusBar;

    // --- //
    public ListView<String> characters;
    public ListView<String> starterWands;
    public ListView<String> spells;
    public TreeView<String> spellDetails;

    // --- //
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
        statusBar.setText("");
        Button button = (Button) aEvent.getSource();
        if(button.getText().equals("Do Nothing")){
            enemyTurn();
            updateStats();
            return;
        }
        if(currentPlayer.castSpell(button.getText(), currentEnemy) == -1){
            statusBar.setText("You do not have enough mana! It needs " + currentPlayer.getCurrentWand().findSpellByName(button.getText()) + " mana to be cast.");
            return;
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

    // --- Menu/Character Selector --- //
    public void menuInitialize(){
        listLoader();
    }
    public void listLoader(){
        characters.getItems().clear();
        //get from file or website. most likly website http://magicbattlegame.thecodercat418.net/characters
        characters.getItems().addAll("Dumbledore");
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