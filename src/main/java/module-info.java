module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}