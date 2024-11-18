module com.thecodercat418.MBG {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.thecodercat418.MBG to javafx.fxml;
    exports com.thecodercat418.MBG;
}