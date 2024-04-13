package com.artur114.neuralnetwork;

import com.artur114.neuralnetwork.neuralnetwork.iris.IrisNetwork;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends Application {
    static Scanner scan = new Scanner(System.in);

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Hallo!");
        double[] data = new double[4];
        for (byte i = 0; i != data.length; i++) {
            data[i] = scan.nextDouble();
        }
        System.out.println(Arrays.toString(IrisNetwork.calculate(data)));
        System.out.println("debug is start");
        IrisNetwork.debug(new double[] {0, 0, 0, 1});
        System.out.println("debug is finish");
//        launch();
    }
}