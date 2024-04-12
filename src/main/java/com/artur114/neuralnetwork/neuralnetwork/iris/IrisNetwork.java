package com.artur114.neuralnetwork.neuralnetwork.iris;

import com.artur114.neuralnetwork.neuralnetwork.base.Layer;

public class IrisNetwork {

    private static final Layer l0 = new Layer(4, 4, true);
    private static final Layer l1 = new Layer(4, 4);
    private static final Layer l2 = new Layer(4);


    public static double[] calculate(double[] data) {
        double[] result = new double[4];
        for (int i = 0; i != l0.size; i++) {
            l0.neurons[i].input(data[i]);
            for (int j = 0; j != l1.size; j++) {
                l1.neurons[j].addData(l0.neurons[i].getResult(j));
            }
        }
        for (int i = 0; i != l1.size; i++) {
            l1.neurons[i].calculateWithData(); //
        }

        for (int i = 0; i != l1.size; i++) {
            for (int j = 0; j != l2.size; j++) {
                l2.neurons[j].addData(l1.neurons[i].getResult(j));
            }
        }
        for (int i = 0; i != l2.size; i++) {
            l2.neurons[i].calculateWithData();
            result[i] = l2.neurons[i].getResult();
        }
        return result;
    }
}
