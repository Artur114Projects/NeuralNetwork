package com.artur114.neuralnetwork.neuralnetwork.base;

import java.util.Random;

public class Layer {
    public Neuron[] neurons;
    public int size;
    public boolean isFinal = false;

    public Layer(int size, int nextSize, boolean isInput) {
        this.neurons = new Neuron[size];
        this.size = size;

        for (int i = 0; i != neurons.length; i++) {
            neurons[i] = new Neuron(nextSize, isInput);
        }
    }

    public Layer(int size, int nextSize) {
        this.neurons = new Neuron[size];
        this.size = size;

        for (int i = 0; i != neurons.length; i++) {
            neurons[i] = new Neuron(nextSize, getRandom());
        }
    }


    public Layer(int size) {
        this.size = size;
        this.neurons = new Neuron[size];
        isFinal = true;

        for (int i = 0; i != neurons.length; i++) {
            neurons[i] = new Neuron(getRandom());
        }
    }

    private double getRandom() {
        Random random = new Random();
        return random.nextInt(5) != 0 ? Math.random() : Math.random() * -1;
    }
}
