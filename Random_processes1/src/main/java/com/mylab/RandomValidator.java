package com.mylab;

/**
 * Created by serega.
 */
public class RandomValidator {


    public void valid(long[] mass, double b, double s) {
        final int segmentNumber = 10;
        double bS = b;
        double eS = s;
        int result[] = new int[segmentNumber];
        int i;
        for (double d : mass) {
            for (i = 0; i < segmentNumber - 1 && (bS + (eS - bS) / segmentNumber * (i + 1)) <= d; i++) ;
            result[i]++;
        }
        for (int x : result) {
            System.out.println(x);
        }
    }

    public void valid(double[] mass, double b, double e) {
        final int segmentNumber = 5;
        double bS = b;
        double eS = e;
        int result[] = new int[segmentNumber];
        int i;
        for (double d : mass) {
            for (i = 0; i < segmentNumber - 1 && (bS + (eS - bS) / segmentNumber * (i + 1)) <= d; i++) ;
//                System.out.println("\t\t" + (bS + (double)(eS - bS) / segmentNumber * (i + 1)));
            result[i]++;
        }
        for (int x : result) {
            System.out.println(x);
        }
    }

}
