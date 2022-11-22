module com.example.courseproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
//    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.courseproject to javafx.fxml;
    exports com.example.courseproject;
    exports com.example.courseproject.controller;
    opens com.example.courseproject.controller to javafx.fxml;
}