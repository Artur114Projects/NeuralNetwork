module com.artur.neuralnetwork {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.artur114.neuralnetwork to javafx.fxml;
    exports com.artur114.neuralnetwork;
    exports com.artur114.neuralnetwork.controllers;
    opens com.artur114.neuralnetwork.controllers to javafx.fxml;
}