package com.artur114.neuralnetwork.neuralnetwork.base.neurons;

import com.artur114.neuralnetwork.neuralnetwork.base.neurons.bases.NeuronBase;

public class InputNeuron extends NeuronBase.Weight {
    public InputNeuron(int weightSize) {
        super(weightSize);
    }

    public InputNeuron(double[] weight) {
        super(weight);
    }

    public void input(double data) {
        result = data;
    }
}
