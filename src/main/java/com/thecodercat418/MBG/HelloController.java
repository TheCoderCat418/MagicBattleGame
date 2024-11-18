package com.thecodercat418.MBG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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
    @FXML
    private AnchorPane battleWands;
    @FXML
    private Pane templateItem;
    @FXML
    private ScrollPane scrollBattleItems;
    @FXML
    private Button useItem;
    @FXML
    private Label itemDetailText;
    // --- //
    @FXML
    private ListView<String> characters;
    @FXML
    private ListView<String> starterWands;
    @FXML
    private ListView<String> spells;
    @FXML
    private TreeView<String> spellDetails;

    // --- //
    @FXML
    private ImageView bruh;
    @FXML
    private ListView<String> shopTable;
    @FXML
    private Label shopItemDesc;
    @FXML
    private Button buyButton;
    @FXML
    private Label goldCounter;

    @FXML
    private RadioButton rd1;
    @FXML
    private RadioButton rd2;
    @FXML
    private RadioButton rd3;
    @FXML
    private Button wandSwapper;
    @FXML
    private Label wndA;
    @FXML
    private Label wndB;
    @FXML
    private Label wndC;
    @FXML
    private Label currWnd;
    @FXML
    private AnchorPane battleManagement;
    @FXML
    private TabPane tp;

    private ShopItem currentShopItem;
    private ArrayList<ShopItem> listOfItems = new ArrayList<>();

    // --- //
    private MagicCharacter currentPlayer;
    private BaseCharacter currentEnemy;
    private BaseCharacter currentCharacter;
    private Item currentItem;
    private Wand sWand;

    private RunningPlacement STATE = RunningPlacement.BEFORE_TURN;
    private Turn setTurn = Turn.PLAYER;

    private enum Turn {
        PLAYER,
        ENEMY
    }

    public void gameStateChanged(boolean advance) {
        updateBattle();
        boolean playerTurn = (setTurn == Turn.PLAYER ? true : false);
        switch (STATE) {
            case RunningPlacement.BEFORE_TURN:
                currentPlayer.BEFORE_TURN(playerTurn);
                currentEnemy.BEFORE_TURN(!playerTurn);
                STATE = advance ? RunningPlacement.BEFORE_ATTACK : RunningPlacement.BEFORE_TURN;
                break;
            case RunningPlacement.BEFORE_ATTACK:
                currentPlayer.BEFORE_ATTACK(playerTurn);
                currentEnemy.BEFORE_ATTACK(!playerTurn);
                STATE = advance ? RunningPlacement.AFTER_ATTACK : RunningPlacement.BEFORE_ATTACK;
                break;
            case RunningPlacement.AFTER_ATTACK:
                currentPlayer.AFTER_ATTACK(playerTurn);
                currentEnemy.AFTER_ATTACK(!playerTurn);
                STATE = advance ? RunningPlacement.AFTER_TURN : RunningPlacement.AFTER_ATTACK;
                break;
            case RunningPlacement.AFTER_TURN: // TURN CHANGE
                currentPlayer.AFTER_TURN(playerTurn);
                currentEnemy.AFTER_TURN(!playerTurn);
                STATE = advance ? RunningPlacement.BEFORE_TURN : RunningPlacement.AFTER_TURN;
                if (playerTurn) {
                    setTurn = Turn.ENEMY;
                    currentCharacter = currentEnemy;
                    enemyTurn();
                } else {
                    setTurn = Turn.PLAYER;
                    currentCharacter = currentPlayer;
                }
                break;
        }

    }

    public void initialize() {
        try {
            // System.out.println(shopTable.getColumns().get(0));
            bruh.setImage(new Image(
                    new FileInputStream(new File("src\\main\\resources\\com\\thecodercat418\\MBG\\shopkeeper.jpg"))));
        } catch (FileNotFoundException e) {
            // Womp Womp
        }
        battleSlider.valueProperty().addListener((_, _, newValue) -> {
            miniScreenSwitcher(newValue.intValue());
        });
        shopTable.getSelectionModel().selectedIndexProperty().addListener((_, _, c) -> {
            if (c.intValue() == -1) {
                return;
            }
            shopItemDesc.setText(listOfItems.get(c.intValue()).getItem().getDescription());
            currentShopItem = listOfItems.get(c.intValue());
            buyButton.setDisable(false);
            if (currentShopItem.getPrice() > currentPlayer.getCoins()) {
                buyButton.setDisable(true);
            }
        });
        starterWands.getSelectionModel().selectedIndexProperty().addListener((_, _, c) -> {
            if (c.intValue() == -1) {
                return;
            }
            sWand = DataLoader.getAllWandPosiblities().get(c.intValue());
            spells.getItems().clear();
            for (Spell s : sWand.getSpells()) {
                spells.getItems()
                        .add(s.getSpellName() + " | DMG: " + s.getDamage() + " | DEF: " + s.getDefence()
                                + " | Lasts For: " + s.getLastsFor() + " | Mana: " + s.getManaNeeded() + " | Cooldown: "
                                + s.getTurnCooldown());
            }
        });
        for (Wand wand : DataLoader.getAllWandPosiblities()) {
            starterWands.getItems().add(wand.getName());
        }
        for (MagicCharacter mc : DataLoader.getAllMagicCharacters()) {
            characters.getItems().add(mc.getName() + " | Health: " + mc.getHealth() + " | Mana: " + mc.getMana());
        }
        tp.getTabs().get(1).setDisable(true);
        tp.getTabs().get(2).setDisable(true);
        currentEnemy = new BaseCharacter("Enemy");

        listOfItems.addAll(DataLoader.getAllShopItemPosibilies());
    }

    public void loadBattle() {
        tp.getTabs().get(1).setDisable(false);
        tp.getTabs().get(2).setDisable(false);
        tp.getSelectionModel().select(1);
        tp.getTabs().get(0).setDisable(true);
        battleSlider.setValue(4.0);
        currentPlayer = DataLoader.getAllMagicCharacters().get(0);
        currentPlayer.addWand(sWand);
        currentPlayer.changeCoins(500);
        currentCharacter = currentPlayer;
        updateBattle();
    }

    public void useAbility(ActionEvent aEvent) {
        statusBar.setText("");
        Button button = (Button) aEvent.getSource();
        if (button.getText().equals("Do Nothing")) {
            gameStateChanged(true); // BEFORE_TURN -> BEFORE_ATTACK
            gameStateChanged(true); // BEFORE_ATTACK -> AFTER_ATTACK
            gameStateChanged(true); // AFTER_ATTACK -> AFTER_TURN
            gameStateChanged(true); // AFTER_TURN -> SIDESWAP -> BEFORE_TURN
            return;
        }
        gameStateChanged(true); // BEFORE_TURN -> BEFORE_ATTACK
        currentPlayer.castSpell(button.getText(), currentEnemy);
        gameStateChanged(true); // BEFORE_ATTACK -> AFTER_ATTACK
        gameStateChanged(true); // AFTER_ATTACK -> AFTER_TURN
        gameStateChanged(true); // AFTER_TURN -> SIDESWAP -> BEFORE_TURN
        updateBattle();
    }

    public void updateBattle() {
        playerHealth.setText(Integer.toString(currentPlayer.getHealth()));
        playerHealthBar.setProgress((currentPlayer.getHealth() + 0.0) / currentPlayer.getMaxHealth());
        enemyHealthBar.setProgress((currentEnemy.getHealth() + 0.0) / currentEnemy.getMaxHealth());
        enemyHealth.setText(Integer.toString(currentEnemy.getHealth()));
        playerManaBar.setProgress((currentPlayer.getMana() + 0.0) / 10);
        playerMana.setText(Integer.toString(currentPlayer.getMana()));
        wandSwapper.setDisable(currentPlayer.usedItem);
        useItem.setDisable(currentPlayer.usedItem);
        loadWands();
        loadActionTable();
        loadItemTable();
        loadShop();
    }

    public void enemyTurn() {
        gameStateChanged(true); // BEFORE_TURN -> BEFORE_ATTACK
        int wandid = (int)(Math.random()*DataLoader.getAllWandPosiblities().size());
        int spellid = (int)(Math.random()*DataLoader.getAllWandPosiblities().get(wandid).spells.size());
        DataLoader.getAllWandPosiblities().get(wandid).castSpell(currentPlayer, DataLoader.getAllWandPosiblities().get(wandid).spells.get(spellid));
        gameStateChanged(true); // BEFORE_ATTACK -> AFTER_ATTACK
        gameStateChanged(true); // AFTER_ATTACK -> AFTER_TURN
        gameStateChanged(true); // AFTER_TURN -> SIDESWAP -> BEFORE_TURN
    }

    public void loadActionTable() {
        int track = 0;
        for (int i = 0; i < currentPlayer.getCurrentWand().getSpells().length; i++) {
            Spell currentSpell = currentPlayer.getCurrentWand().getSpells()[i];
            boolean cooldown = currentPlayer.getSpellEffectFromSpell(currentSpell) != null;
            boolean mana = currentPlayer.getMana() < currentSpell.getManaNeeded();
            boolean locked = currentPlayer.getCurrentWand().getLevel() < currentSpell.getWandLevelNeeded();
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
            button.setText(currentPlayer.getCurrentWand().getSpells()[i].getSpellName());
            button.setDisable(false);
            label.setText("Ready.");
            if (mana) {
                label.setText("Not Enough Mana!\nYou need " + currentSpell.getManaNeeded() + " mana!");
                button.setDisable(true);
            }
            if (cooldown) {
                label.setText("On Cooldown!\nTurns of cooldown left: "
                        + currentPlayer.getSpellEffectFromSpell(currentSpell).getRemainingCooldown() + "\n "
                        + currentPlayer.getSpellEffectFromSpell(currentSpell).hasEffect());
                button.setDisable(true);
            }
            if (locked) {
                label.setText("It's Locked!\nWand level needed: " + currentSpell.getWandLevelNeeded());
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

    public void loadItemDetails() {
        itemDetailText.setText(currentItem.getName() + "\n\n" + currentItem.getDescription());
    }

    public void loadItemTable() {
        AnchorPane base = (AnchorPane) (scrollBattleItems.getContent());
        base.getChildren().clear();

        int layer = 0;
        for (int i = 0; i < currentPlayer.items.size(); i++) {
            Item item = currentPlayer.items.get(i);
            Pane itemPane = new Pane();
            itemPane.setStyle("-fx-background-color: red");
            itemPane.setPrefSize(100.0, 100.0);
            itemPane.setLayoutY(114.0 * layer);
            if (i % 2 == 1) {
                itemPane.setLayoutX(114.0);
            }

            Label name = new Label(item.getName());
            name.setAlignment(Pos.CENTER);
            name.setLayoutX(6.0);
            name.setLayoutY(50.0);
            name.setPrefHeight(17.0);
            name.setPrefWidth(90.0);

            Button select = new Button("Select");
            select.setLayoutX(14.0);
            select.setLayoutY(67.0);
            select.setMnemonicParsing(false);
            select.setPrefHeight(25.0);
            select.setPrefWidth(75.0);

            select.setOnAction((ae) -> {
                Button b = (Button) ae.getSource();
                for (Node node : b.getParent().getChildrenUnmodifiable()) {
                    if (node instanceof Label) {
                        for (Item itemb : currentPlayer.items) {
                            if (((Label) node).getText().equals(itemb.getName())) {
                                currentItem = itemb;
                                loadItemDetails();
                                return;
                            }
                        }
                    }
                }
            });

            ImageView imageView = new ImageView(item.getImage());
            imageView.setFitHeight(41.0);
            imageView.setFitWidth(44.0);
            imageView.setLayoutX(29.0);
            imageView.setLayoutY(9.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);

            itemPane.getChildren().clear();
            itemPane.getChildren().addAll(name, select, imageView);
            base.getChildren().add(itemPane);
            if (i % 2 == 1) {
                layer++;
            }
            if (i == currentPlayer.items.size() - 1 && i % 2 == 0) {
                layer++;
            }

        }
        base.setPrefHeight(100.0 * layer + 14.0 * (layer - 1));
    }

    public void loadShop() {
        goldCounter.setText("Gold: " + currentPlayer.getCoins());
        shopTable.getItems().clear();
        for (ShopItem si : DataLoader.getAllShopItemPosibilies()) {
            if (si.getQuatity() <= 0) {
                continue;
            }
            shopTable.getItems()
                    .add(si.getItem().getName() + " : Price: " + si.getPrice() + " : Quanity: " + si.getQuatity());
        }
    }

    public void buyItem() {
        currentPlayer.items.add(currentShopItem.getItem());
        currentPlayer.changeCoins(-1 * currentShopItem.getPrice());
        currentShopItem.itemTaken();
        updateBattle();
    }

    public void useItem() {
        if (currentCharacter.usedItem) {
            return;
        }
        currentPlayer.addSpellEffect(currentItem.getEffect());
        for (Item item : currentPlayer.items) {
            if (currentItem.equals(item)) {
                currentPlayer.items.remove(item);
                break;
            }
        }
        currentItem = null;
        currentCharacter.usedItem = true;
        updateBattle();
    }

    public void loadWands() {
        rd1.setDisable(false);
        rd2.setDisable(false);
        rd3.setDisable(false);
        ArrayList<Wand> wndsm = new ArrayList<>();
        for (Wand w : currentPlayer.getWands()) {
            if (w.equals(currentPlayer.getCurrentWand())) {
                continue;
            }
            wndsm.add(w);
        }
        currWnd.setText(currentPlayer.getCurrentWand().getName());

        int i;
        for (i = 0; i < wndsm.size(); i++) {
            switch (i) {
                case 0:
                    wndA.setText(wndsm.get(i).getName());
                    break;
                case 1:
                    wndB.setText(wndsm.get(i).getName());
                    break;
                case 2:
                    wndC.setText(wndsm.get(i).getName());
                    break;
            }
        }
        for (i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    wndA.setText("Empty");
                    rd1.setDisable(true);
                    break;
                case 1:
                    wndB.setText("Empty");
                    rd2.setDisable(true);
                    break;
                case 2:
                    wndC.setText("Empty");
                    rd3.setDisable(true);
                    break;
            }
        }

    }

    public void swapWands(ActionEvent ae) {
        if (currentPlayer.usedItem) {
            return;
        }
        RadioButton rd;
        if (rd1.isSelected()) {
            rd = rd1;
        } else if (rd2.isSelected()) {
            rd = rd2;
        } else {
            rd = rd3;
        }
        for (int i = 0; i < rd.getParent().getChildrenUnmodifiable().size(); i++) {
            if (rd.getParent().getChildrenUnmodifiable().get(i) instanceof Label) {
                Label l = (Label) rd.getParent().getChildrenUnmodifiable().get(i);
                for (Wand wnd : currentPlayer.getWands()) {
                    if (wnd.getName().equals(l.getText())) {
                        currentPlayer.equipWand(wnd);
                        currentCharacter.usedItem = true;
                    }
                }
            }
        }
        updateBattle();
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
        battleWands.setVisible(false);
        battleManagement.setVisible(false);
        // Screen 1: Abilities
        if (screenId == 1) {
            battleAbilities.setVisible(true);
        } else if (screenId == 2) {
            battleItems.setVisible(true);
        } else if (screenId == 3) {
            battleWands.setVisible(true);
        } else if (screenId == 4) {
            battleManagement.setVisible(true);
        }
    }
}