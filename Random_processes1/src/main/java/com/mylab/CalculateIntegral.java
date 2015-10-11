package com.mylab;

import java.util.function.Function;


public class CalculateIntegral {

    Function<Double, Double>[] fun =
            new Function[]{
                    new Function<Double, Double>() {
                        public Double apply(Double x) {
                            return Math.pow(x, 7) + Math.pow(x, 5) + Math.pow(x, 3);
                        }
                    },
                    new Function<Double, Double>() {
                        public Double apply(Double x) {
                            return 2 * Math.sin(3 * x);
                        }
                    },
                    new Function<Double, Double>() {
                        public Double apply(Double x) {
                            return 1d / ((x + 1) * Math.pow(x, 0.5d));
                        }
                    },
                    new Function<Double, Double>() {
                        public Double apply(Double x) {
                            return Math.pow(x, 2);
                        }
                    }
            };
    final double BEGIN_X[] = {0, 0, 0, 0};
    final double DELTA_X[] = {1, Math.PI, 11, 1};
    final double BEGIN_Y[] = {min(0), min(1), 0, min(3)};
    final double DELTA_Y[] =
            {max(0) - min(0), max(1) - min(1), 10, max(3) - min(3)};

    public void calc() {
        calc(0);
    }

    public void calc(int a) {
        int CUR_FUNC = a;
        final long AMOUNT = 100000L;
        long count = 0;
        for (int i = 0; i < AMOUNT; i++) {
            double x = BEGIN_X[CUR_FUNC] + Math.random() * DELTA_X[CUR_FUNC];
            double y = BEGIN_Y[CUR_FUNC] + Math.random() * DELTA_Y[CUR_FUNC];

            if (y < (Double) fun[CUR_FUNC].apply(x) && y >= 0)
                count++;
            else if (y > (Double) fun[CUR_FUNC].apply(x) && y < 0)
                count--;
//            System.out.println("y("+x+") = " + fun[CUR_FUNC].calc(x));
        }
//        System.out.println("X min: " + BEGIN_X[CUR_FUNC]);
//        System.out.println("X max: " + DELTA_X[CUR_FUNC]);
//        System.out.println("Y min: " + BEGIN_Y[CUR_FUNC]);
//        System.out.println("Y max: " + DELTA_Y[CUR_FUNC]);
        System.out.println("X: " + BEGIN_X[CUR_FUNC] + " -> " + (BEGIN_X[CUR_FUNC] + DELTA_X[CUR_FUNC]));
        System.out.println("Y: " + BEGIN_Y[CUR_FUNC] + " -> " + (BEGIN_Y[CUR_FUNC] + DELTA_Y[CUR_FUNC]));
//        System.out.println("Ratio: " + (double) count / AMOUNT);
        System.out.println("Square: " + (double) count / AMOUNT * DELTA_X[CUR_FUNC] * DELTA_Y[CUR_FUNC]);
    }
    private double min(int n) {
        double min = Integer.MAX_VALUE;
        double tmp = DELTA_X[n] / 1000;
        for (double x = BEGIN_X[n] + tmp; x <= BEGIN_X[n] + DELTA_X[n]; x += tmp) {
            double y = (Double) fun[n].apply(x);
            if (min > y)
                min = y;
        }
        return min;
    }

    private double max(int n) {
        double max = Integer.MIN_VALUE;
        double tmp = DELTA_X[n] / 1000;
        for (double x = BEGIN_X[n] + tmp; x <= BEGIN_X[n] + DELTA_X[n]; x += tmp) {
            double y = (Double) fun[n].apply(x);
            if (max < y)
                max = y;
        }
        return max;
    }

}
