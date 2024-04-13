package com.artur114.neuralnetwork.neuralnetwork.base;


import java.util.Random;

public class Neuron {
    public double[] weight;
    private double data = 0;
    private double result = 0;
    private double errorData = 0;
    public double error = 0;
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

    public void calculate(double data) {
        result = data + offset > 0 ? data + offset : 0;
    }

    public void calculateWithData() {
        result = data + offset > 0 ? data + offset : 0;
        data = 0;
    }

    public void addErrorData(double errorData, int weightIndex) {
        this.errorData += errorData * weight[weightIndex];
    }

    public void calculateError(double desiredRes) {
        error = (((result - desiredRes) * (result - desiredRes)) / 2) * result;
    }

    public void calculateErrorWithData() {
        error = errorData * result;
        errorData = 0;
    }

    public double getResult(int index) {
        return result * weight[index];
    }

    public double getResult() {
        return result;
    }

    public void input(double data) {
        result = data;
    }

    private double getRandom() {
        Random random = new Random();
        return random.nextInt(5) != 0 ? Math.random() : Math.random() * -1;
    }
}
