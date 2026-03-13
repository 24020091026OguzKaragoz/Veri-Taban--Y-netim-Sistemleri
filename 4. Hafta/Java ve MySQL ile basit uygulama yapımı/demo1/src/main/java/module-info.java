module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.demo1 to javafx.fxml, javafx.base;
    exports com.example.demo1;
}