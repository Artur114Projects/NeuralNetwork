package com.artur114.neuralnetwork.neuralnetwork.iris;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IrisDataSet {

    static File dataF = new File("C:\\Users\\DITStudent\\IdeaProjects\\NeuralNetwork\\src\\main\\resources\\com\\artur114\\neuralnetwork\\data", "Iris.txt");
    static Random random = new Random();
    static String[] dataOnDataset = readFile(dataF);

    public static double[][] getRandomData() {
        return random.nextInt(2) == 0 ? getDataInDataSet() : new double[][] {{(random.nextInt(100) / 10D), (random.nextInt(100) / 10D), (random.nextInt(100) / 10D), (random.nextInt(100) / 10D), }, {0, 0, 0, 1}};
    }

    public static double[][] getDataInDataSet() {
        String dataInString = dataOnDataset[random.nextInt(150)];
        StringBuilder buf = new StringBuilder();
        double[] data = new double[4];
        double[] desiredRes = new double[4];
        boolean set = false;
        int index = -2;

        for (int i = 0; i != dataInString.length(); i++) {
            if (dataInString.charAt(i) == 'I') {
                break;
            }
            if (dataInString.charAt(i) == ',') {
                index++;
                set = true;
            }
            if (set) {
                if (dataInString.charAt(i) != ',') {
                    buf.append(dataInString.charAt(i));
                } else if (!buf.isEmpty()) {
                    data[index] = (Double.parseDouble(buf.toString()));
                    buf = new StringBuilder();
                }
            }
        }

        if (dataInString.indexOf("setosa") > 0) {
            desiredRes[0] = 1;
        } else
        if (dataInString.indexOf("versicolor") > 0) {
            desiredRes[1] = 1;
        } else
        if (dataInString.indexOf("virginica") > 0) {
            desiredRes[2] = 1;
        } else {
            desiredRes[3] = 1;
        }

        return new double[][] {data, desiredRes};
    }

    public static String[] readFile(File file) {
        ArrayList<String> buf = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                buf.add(scan.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return buf.toArray(new String[0]);
    }
}
