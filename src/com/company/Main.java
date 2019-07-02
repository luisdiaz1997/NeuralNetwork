package com.company;
public class Main {

    public static void main(String[] args)
    {
        double [][] input =
                          {
                                  {0, 0, 0},
                                  {0, 0, 1},
                                  {0, 1, 0},
                                  {0, 1, 1},
                                  {1, 0, 0},
                                  {1, 0, 1},
                                  {1, 1, 0},
                                  {1, 1, 1}



                          };
        double [][] output = {
                {0},
                {1},
                {1},
                {0},
                {1},
                {0},
                {0},
                {1},


        };


        NeuralNet net = new NeuralNet();
        net.add_layer(2);
        net.add_layer(1);
        net.set_input(input);
        net.set_output(output);
        System.out.println("No Training----------------------------");
        Operations.print_mat(net.predict());
        System.out.println("After Training----------------------------");
        net.train(10000);
        Operations.print_mat(net.predict());
        System.out.println("Weigths neurons 1----------------------------");
        Operations.print_mat(net.get_layer(0).get_weight());
        System.out.println("bias neurons 1----------------------------");
        Operations.print_mat(net.get_layer(0).get_bias());
        System.out.println("Weigths neurons 2----------------------------");
        Operations.print_mat(net.get_layer(1).get_weight());
        System.out.println("bias neurons 2----------------------------");
        Operations.print_mat(net.get_layer(1).get_bias());
        System.out.println("error ----------------------------");
        System.out.println(net.get_cost());





    }


}
