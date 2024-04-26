package com.artur114.neuralnetwork.neuralnetwork.base.neurons.bases;


import java.util.Random;

public abstract class NeuronBase {
    protected double result;

    public double getResult() {
        return result;
    }

    public abstract static class Weight extends NeuronBase {
        protected final double[] weight;
        protected double result;
        public final int weightSize;

        public Weight(int weightSize) {
            this.weight = new double[weightSize];
            this.weightSize = weightSize;

            for (int j = 0; j != weight.length; j++) {
                weight[j] = getRandom();
            }
        }

        public Weight(double[] weight) {
            this.weight = weight;
            this.weightSize = weight.length;
        }

        public double getResultWithWeight(int index) {
            return result * weight[index];
        }

        protected double getRandom() {
            return new Random().nextInt(3) == 0 ? Math.random() * -1 : Math.random();
        }

        public abstract static class Calculate extends Weight {
            private double data;
            private double errorData;
            public double error;
            public double offset;


            public Calculate(int weightSize, double offset) {
                super(weightSize);
                this.offset = offset;
            }

            public Calculate(double[] weight, double offset) {
                super(weight);
                this.offset = offset;
            }

            public void addData(double data) {
                this.data += data;
            }

            public void calculate(double data) {
                result = Math.tanh(data + offset);
            }

            public void calculateWithData() {
                result = Math.tanh(data + offset);
                data = 0;
            }

            public void addErrorData(double errorData, int weightIndex) {
                this.errorData += errorData * weight[weightIndex];
            }

            public void calculateErrorWithData() {
                error = errorData * result;
                errorData = 0;
            }
        }

    }
}
