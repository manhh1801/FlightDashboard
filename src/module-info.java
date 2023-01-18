module project.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.app to javafx.fxml;
    exports project.app;
}