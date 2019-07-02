package com.company;

import java.util.Random;

public class Layer
{
    private double input[][];
    private double weight[][];
    private double bias[][];
    private double ones[][];
    private double net_output[][];
    private double product[][];
    private int neurons;
    private boolean had_input = false;

    public Layer(int neurons)
    {
        this.neurons = neurons;
    }
    public Layer(double [][] input, int neurons )
    {

        this(neurons);
        set_input(input);

    }
    public void set_input(double [][] input)
    {
        if (!had_input)
        {
            this.weight = new double[input[0].length][neurons];
            this.bias = new double[1][neurons];
            this.ones = new double[input.length][1];
            initialize();
            this.had_input = true;
        }
        this.input = input;
        this.product = Operations.add
                (
                        Operations.mat_mul(input,weight),
                        Operations.mat_mul(ones,bias)
                );
        this.net_output = Operations.sig(product);
    }
    private void initialize()
    {
        Random random = new Random();
        for (int j = 0; j < weight[0].length; j++)
        {
            for (int i = 0; i < weight.length; i++)
            {
                weight[i][j] = (random.nextDouble() -0.5);
            }
            bias[0][j] = (random.nextDouble() -0.5);
        }
        for (int i= 0; i<ones.length; i++)
        {
            ones[i][0] = 1;
        }
    }

    public int neurons()
    {
        return this.neurons;
    }

    public double [][] get_output()
    {
        return this.net_output;
    }
    public void update_weights(double [][] w)
    {
        this.weight = w;
    }
    public void update_bias(double [][] b)
    {
        this.bias = b;
    }
    public double[][] get_weight()
    {
        return weight;
    }
    public double[][] get_bias()
    {
        return bias;
    }
    public double[][] get_ones()
    {
        return ones;
    }
    public double[][] get_product()
    {
        return product;
    }
    public double[][] get_input()
    {
        return input;
    }





}