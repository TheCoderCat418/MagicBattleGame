module com.thecodercat418.MBG {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.thecodercat418.MBG to javafx.fxml;
    exports com.thecodercat418.MBG;
    exports com.thecodercat418.MBG.Wands;
    opens com.thecodercat418.MBG.Wands to javafx.fxml;
}