package com.artur114.neuralnetwork;

import com.artur114.neuralnetwork.neuralnetwork.iris.IrisDataSet;
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
        String[] commands = new String[] {"/exit", "/start", "/test"};
        System.out.println(Arrays.toString(commands));
        while (true) {
            String str = scan.next();
            if (str.equals(commands[0])) {
                return;
            } else if (str.equals(commands[1])) {
                System.out.println();
                start(scan.nextInt());
            } else if (str.equals(commands[2])) {
                test();
            }
        }
        //        launch();
    }

    public static void start(int generations) {
        if (generations <= 0) {
            throw new IllegalArgumentException(generations + " value too small");
        }
        for (int i = 0; i != generations; i++) {
            double[][] data = IrisDataSet.getRandomData();
            IrisNetwork.calculate(data[0]);
            IrisNetwork.debug(data[1]);
        }
        System.out.println("Finish!");
    }

    public static void test() {
        System.out.println();
        double[] data = new double[4];
        for (byte i = 0; i != data.length; i++) {
            data[i] = scan.nextInt() / 10D;
        }
        System.out.println(Arrays.toString(IrisNetwork.calculate(data)));
    }
}