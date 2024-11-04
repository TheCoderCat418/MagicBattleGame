package com.thecodercat418.MBG;

import com.thecodercat418.MBG.Wands.FireWand;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class HelloController {
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
    private Label SMA1;
    @FXML
    private Label SMA2;
    @FXML
    private Label SMA3;
    @FXML
    private Label SMA4;
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
    @FXML
    private Label statusBar;
    @FXML
    private AnchorPane battleItems;

    // --- //
    @FXML
    public ListView<String> characters;
    @FXML
    public ListView<String> starterWands;
    @FXML
    public ListView<String> spells;
    @FXML
    public TreeView<String> spellDetails;

    // --- //
    MagicCharacter currentPlayer;
    BaseCharacter currentEnemy;

    String STATE = "BATTLE";

    public void initialize() {
        battleSlider.valueProperty().addListener((_, _, newValue) -> {
            miniScreenSwitcher(newValue.intValue());
        });

        battleSlider.setValue(3.0);
        currentEnemy = new BaseCharacter("Enemy");

        currentPlayer = new MagicCharacter();
        currentPlayer.addWand(new FireWand());
        loadBattle(currentEnemy);
        updateBattle();
    }

    public void useAbility(ActionEvent aEvent) {
        statusBar.setText("");
        Button button = (Button) aEvent.getSource();
        if (button.getText().equals("Do Nothing")) {
            currentPlayer.finishTurn();
            enemyTurn();
            updateBattle();
            return;
        }
        currentPlayer.finishTurn();
        currentPlayer.castSpell(button.getText(), currentEnemy);
        updateBattle();
        enemyTurn();
    }

    public void updateBattle() {
        playerHealth.setText(Integer.toString(currentPlayer.getHealth()));
        playerHealthBar.setProgress((currentPlayer.getHealth() + 0.0) / currentPlayer.getMaxHealth());
        enemyHealthBar.setProgress((currentEnemy.getHealth() + 0.0) / currentEnemy.getMaxHealth());
        enemyHealth.setText(Integer.toString(currentEnemy.getHealth()));
        playerManaBar.setProgress((currentPlayer.getMana() + 0.0) / 10);
        playerMana.setText(Integer.toString(currentPlayer.getMana()));
        loadActionTable();
    }

    public void enemyTurn() {
        currentPlayer.startTurn();
        updateBattle();
    }

    public void loadActionTable() {
        int track = 0;
        for (int i = 0; i < currentPlayer.getCurrentWand().getSpells().length; i++) {
            Spell currentSpell = currentPlayer.getCurrentWand().getSpells()[i];
            boolean cooldown = currentPlayer.getSpellEffectFromSpell(currentSpell) != null;
            boolean mana = currentPlayer.getMana() < currentSpell.manaNeeded;
            boolean locked = currentPlayer.getCurrentWand().getWandLevel() < currentSpell.wandLevelNeeded;
            Button button = null;
            Label label = null;
            switch (track) {
                case 0:
                    button = MA1;
                    label = SMA1;
                    break;
                case 1:
                    button = MA2;
                    label = SMA2;
                    break;
                case 2:
                    button = MA3;
                    label = SMA3;
                    break;
                case 3:
                    button = MA4;
                    label = SMA4;
                    break;
            }
            button.setText(currentPlayer.getCurrentWand().getSpells()[i].spellName);
            button.setDisable(false);
            label.setText("Ready.");
            if (mana) {
                label.setText("Not Enough Mana!\nYou need " + currentSpell.manaNeeded + " mana!");
                button.setDisable(true);
            }
            if (cooldown) {
                label.setText("On Cooldown!\nTurns of cooldown left: "
                        + currentPlayer.getSpellEffectFromSpell(currentSpell).remainingCooldown + "\n "
                        + currentPlayer.getSpellEffectFromSpell(currentSpell).hasEffect());
                button.setDisable(true);
            }
            if (locked) {
                label.setText("It's Locked!\nWand level needed: " + currentSpell.wandLevelNeeded);
                button.setDisable(true);
            }
            track++;
        }
        for (int i = track; i < 4; i++) {
            Button button = null;
            Label label = null;
            switch (i) {
                case 0:
                    button = MA1;
                    label = SMA1;
                    break;
                case 1:
                    button = MA2;
                    label = SMA2;
                    break;
                case 2:
                    button = MA3;
                    label = SMA3;
                    break;
                case 3:
                    button = MA4;
                    label = SMA4;
                    break;
            }
            button.setText("No Ability");
            label.setText("");
        }
    }

    public void loadBattle(BaseCharacter enemy) {
        enemyName.setText(enemy.getName());
        currentEnemy = enemy;
    }

    // --- Menu/Character Selector --- //
    public void menuInitialize() {
        listLoader();
    }

    public void listLoader() {
        characters.getItems().clear();
        // get from file or website. most likly website
        // http://magicbattlegame.thecodercat418.net/characters
        characters.getItems().addAll("Dumbledore");
    }

    public void miniScreenSwitcher(int screenId) {
        battleAbilities.setVisible(false);
        battleItems.setVisible(false);
        // Screen 1: Abilities
        if (screenId == 1) {
            battleAbilities.setVisible(true);
        } else if(screenId == 2) {
            battleItems.setVisible(true);

        }
    }
}