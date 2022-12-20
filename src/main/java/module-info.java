module com.example.courseproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
//    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires com.jfoenix;

    opens com.example.courseproject to javafx.fxml;
    exports com.example.courseproject;
    exports com.example.courseproject.controller;
    opens com.example.courseproject.controller to javafx.fxml;
    exports com.example.courseproject.database;
    opens com.example.courseproject.database to javafx.fxml;
    exports com.example.courseproject.model;
    opens com.example.courseproject.model to javafx.fxml;
    exports com.example.courseproject.controller.queries;
    opens com.example.courseproject.controller.queries to javafx.fxml;
    exports com.example.courseproject.controller.tableView;
    opens com.example.courseproject.controller.tableView to javafx.fxml;
    exports com.example.courseproject.controller.addAndDelete;
    opens com.example.courseproject.controller.addAndDelete to javafx.fxml;
}