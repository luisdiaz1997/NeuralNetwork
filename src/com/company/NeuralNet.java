package com.company;

public class NeuralNet
{
    private double[][] input;
    private Layer [] layers = new Layer[0];
    private double[][] output;
    private double error;

    public NeuralNet()
    {
    }
    public NeuralNet(double[][] input, Layer [] layers )
    {
        this.input = input;
        this.layers = layers;
    }
    public Layer add_layer(int neurons)
    {
        return add_layer(new Layer(neurons));
    }
    public Layer add_layer(Layer layer)
    {
        this.layers = Operations.add_last(layers, layer);
        return layer;
    }
    public void set_input(double [][] input)
    {
        this.input = input;
    }
    public void set_output(double [][] output)
    {
        this.output = output;
    }
    public double[][] feed_forward()
    {
        return feed_forward(input);
    }
    public double[][] feed_forward(double[][] input)
    {
        layers[0].set_input(input);
        for (int i = 1; i< layers.length ; i++)
        {
                layers[i].set_input(layers[i-1].get_output());
        }
        return layers[layers.length - 1].get_output();
    }
    public void back_propagation(double lr)
    {
        double [][] output_diff = Operations.subs( predict(), output);
        this.error = Operations.frobenius(output_diff, output_diff);
        double [][][] tensor = new double[layers.length][][];
        tensor[tensor.length -1] = Operations.hadamard
                    (
                        output_diff,
                        Operations.d_sig(layers[layers.length -1].get_product())
                    );
        for (int i = layers.length - 2; i >= 0; i--)
        {
            tensor[i] = Operations.hadamard
                    (
                    Operations.mat_mul
                            (
                            tensor[i+1],
                            Operations.transpose(layers[i+1].get_weight())
                            )
                            ,
                    Operations.d_sig(layers[i].get_product())
                    );
        }
        for (int i= 0; i< layers.length; i++)
        {
            layers[i].update_weights
                    (
                    Operations.subs
                            (
                            layers[i].get_weight(),
                            Operations.mat_mul
                                    (
                                    Operations.transpose(layers[i].get_input()),
                                    tensor[i]
                                    )
                            )
                    );
            layers[i].update_bias
                    (
                    Operations.subs
                            (
                            layers[i].get_bias(),
                            Operations.mat_mul
                                    (
                                    Operations.transpose(layers[i].get_ones()),
                                    tensor[i]
                                    )
                            )
                    );
        }
    }
    public void train(int times)
    {
        for (int i = 0; i< times; i++)
        {
            back_propagation(0.01);
        }

    }
    public double[][] predict()
    {
        return feed_forward();

    }
    public double[][] predict(double[][] input)
    {
        return feed_forward(input);
    }
    public double get_cost()
    {
        return this.error;
    }
    public Layer get_layer(int index)
    {
        return layers[index];
    }
}

