package com.mylab.model;

import java.util.function.Function;


public class CalculateIntegral {

    private final int tmpFactor = 10;
    private final static MyRandomizer r = new MyRandomizer();
    private final Function<Double, Double>[] fun =
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
                            return tmpFactor*1d / ((x + 1) * Math.pow(x, 0.5d));
                        }
                    },
                    new Function<Double, Double>() {
                        public Double apply(Double x) {
                            return Math.pow(x, 2);
                        }
                    }
            };
    private final double BEGIN_X[] = {0, 0, 0, 0};
    private final double DELTA_X[] = {1, Math.PI, 1000, 1};
    private final double BEGIN_Y[] = {min(0), min(1), 0, min(3)};
    private final double DELTA_Y[] =
            {max(0) - min(0), max(1) - min(1), 1000, max(3) - min(3)};

    public void calc() {
        calc(0);
    }

    public void calc(final int CUR_INT) {
        final long AMOUNT = 1_000_000L;
        long count = 0;
        for (int i = 0; i < AMOUNT; i++) {
            double x = BEGIN_X[CUR_INT] + r.random() * DELTA_X[CUR_INT];
            double y = BEGIN_Y[CUR_INT] + r.random() * DELTA_Y[CUR_INT];

            if (y < (Double) fun[CUR_INT].apply(x) && y >= 0)
                count++;
            else if (y > (Double) fun[CUR_INT].apply(x) && y < 0)
                count--;
        }
        double square = (double) count / AMOUNT * DELTA_X[CUR_INT] * DELTA_Y[CUR_INT];

        System.out.println("X: " + BEGIN_X[CUR_INT] + " -> " + (BEGIN_X[CUR_INT] + DELTA_X[CUR_INT]));
        System.out.println("Y: " + BEGIN_Y[CUR_INT] + " -> " + (BEGIN_Y[CUR_INT] + DELTA_Y[CUR_INT]));
        System.out.println("Square: " + square);
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
