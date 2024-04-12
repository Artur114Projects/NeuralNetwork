package com.artur114.neuralnetwork.neuralnetwork.base;


import java.util.Random;

public class Neuron {
    public double[] weight;
    private double data = 0;
    protected double result = 0;
    public double offset = 0;
    public boolean isInput = false;
    public boolean isFinal = false;
    public int weightSize = 0;

    public Neuron(int weightSize, double offset) {
        this.weight = new double[weightSize];
        this.offset = offset;
        this.weightSize = weightSize;

        for (int j = 0; j != weight.length; j++) {
            weight[j] = getRandom();
        }
    }

    public Neuron(int weightSize, boolean isInput) {
        this.weight = new double[weightSize];
        this.isInput = isInput;
        this.weightSize = weightSize;

        for (int j = 0; j != weight.length; j++) {
            weight[j] = getRandom();
        }
    }

    public Neuron(double offset) {
        this.offset = offset;
        isFinal = true;
    }

    public void addData(double data) {
        this.data += data;
    }

    public void calculateWithData() {
        result = data + offset;
        data = 0;
    }

    public void calculate(double data) {
        result = data + offset;
    }

    public double getResult(int index) {
        double res = result * weight[index];
        return !isInput ? res > 0 ? res : 0 : res;
    }

    public double getResult() {
        return result > 0 ? result : 0;
    }

    public void input(double data) {
        result = data;
    }

    private double getRandom() {
        Random random = new Random();
        return random.nextInt(5) != 0 ? Math.random() : Math.random() * -1;
    }
}
