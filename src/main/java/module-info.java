module com.thecodercat418.MBG {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.thecodercat418.MBG to javafx.fxml;

    exports com.thecodercat418.MBG;
    exports com.thecodercat418.MBG.Wands;
    exports com.thecodercat418.MBG.Items;

    opens com.thecodercat418.MBG.Wands to javafx.fxml;
}