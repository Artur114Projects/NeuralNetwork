package com.artur114.neuralnetwork.neuralnetwork.base.neurons;


import com.artur114.neuralnetwork.neuralnetwork.base.neurons.bases.NeuronBase;

public class Neuron extends NeuronBase.Weight.Calculate {


    public Neuron(int weightSize, double offset) {
        super(weightSize, offset);
    }

    public Neuron(double[] weight, double offset) {
        super(weight, offset);
    }

}
