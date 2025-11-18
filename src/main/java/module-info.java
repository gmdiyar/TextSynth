module org.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens org.example.demo1 to javafx.fxml;
    exports org.example.demo1;
    exports org.example.demo1.Controllers;
    opens org.example.demo1.Controllers to javafx.fxml;
}