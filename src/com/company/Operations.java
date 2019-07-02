package com.company;

public class Operations
{
    public static Layer [] add_last(Layer [] arr, Layer obj)
    {
        Layer [] temp = new Layer[arr.length + 1];
        int i=0;
        for (Layer a: arr)
        {
            temp[i] = a;
            i++;
        }
        temp[i] = obj;
        return temp;
    }
    static Layer [] add_first(Layer [] arr, Layer obj)
    {
        Layer [] temp = new Layer[arr.length + 1];
        int i=1;
        for (Layer a: arr)
        {
            temp[i] = a;
            i++;
        }
        temp[0] = obj;
        return temp;
    }
    static double [][] mat_mul(double [][] w1, double[][] w2)
    {
        double [][] w3 = new double[w1.length][w2[0].length];
        for (int i = 0; i< w3.length; i++)
        {
            for(int j= 0; j<w3[0].length;j++)
            {
                for (int k=0; k< w2.length; k++)
                {
                    w3[i][j] += w1[i][k] * w2[k][j];
                }
            }
        }
        return w3;
    }

    static double[][] transpose(double [][] w)
    {
        double[][] w2 = new double[w[0].length][w.length];
        for (int i = 0; i<w2.length; i++) {
            for (int j = 0; j < w2[0].length; j++)
            {
                w2[i][j] = w[j][i];

            }
        }
        return w2;
    }
    static double [][] hadamard(double [][] w1, double [][] w2)
    {
        double [][] w3 = new double[w1.length][w1[0].length];
        for (int i = 0; i<w3.length; i++) {
            for (int j = 0; j < w3[0].length; j++)
            {
                w3[i][j] = w1[i][j] * w2[i][j];

            }
        }
        return w3;
    }
    static double [][] add(double [][] w1, double [][] w2)
    {
        double [][] w3 = new double[w1.length][w1[0].length];
        for (int i = 0; i<w3.length; i++) {
            for (int j = 0; j < w3[0].length; j++)
            {
                w3[i][j] = w1[i][j] +  w2[i][j];

            }
        }
        return w3;
    }
    static double [][] subs(double [][] w1, double [][] w2)
    {
        double [][] w3 = new double[w1.length][w1[0].length];
        for (int i = 0; i<w3.length; i++) {
            for (int j = 0; j < w3[0].length; j++)
            {
                w3[i][j] = w1[i][j] -  w2[i][j];

            }
        }
        return w3;
    }
    static double frobenius(double [][] w1, double [][] w2)
    {
        double sum = 0;
        for (int i = 0; i<w1.length; i++) {
            for (int j = 0; j < w1[0].length; j++)
            {
                sum+= w1[i][j] * w2[i][j];
            }
        }
        return sum;
    }

    static double [][] sig(double [][] w)
    {
        double[][] s = new double[w.length][w[0].length];
        for (int i = 0; i < w.length; i++)
        {
            for (int j = 0; j < w[0].length; j++)
            {
                s[i][j] = sigmoid(w[i][j]);
            }
        }
        return s;
    }
    static double [][] d_sig(double [][] w)
    {
        double[][] s = new double[w.length][w[0].length];
        for (int i = 0; i < s.length; i++)
        {
            for (int j = 0; j < s[0].length; j++)
            {
                s[i][j] = d_sigmoid(sigmoid(w[i][j]));
            }
        }
        return s;
    }
    static double sigmoid(double x)
    {
        return 1/(1+ Math.exp(-x));
    }
    static double d_sigmoid(double x)
    {
        return x*(1-x);
    }
    static void print_mat(double [][] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
            {
                System.out.print(String.format("%.2f",arr[i][j]) + " ");
            }
            System.out.print("\n");
        }
    }

}
