module com.thecodercat418.MBG {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    // requires org.junit.jupiter.api;

    opens com.thecodercat418.MBG to javafx.fxml;

    exports com.thecodercat418.MBG;
    exports com.thecodercat418.MBG.Wands;

    opens com.thecodercat418.MBG.Wands to javafx.fxml;
}