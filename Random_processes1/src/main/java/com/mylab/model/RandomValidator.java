package com.mylab.model;

/**
 * Created by serega.
 */
public class RandomValidator {

    private int amountSegments = 10;

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

    public int[] valid(double[] mass, double b, double e) {
        final int segmentNumber = amountSegments;
        double bS = b;
        double eS = e;
        int result[] = new int[segmentNumber];
        int i;
        for (double d : mass) {
            for (i = 0; i < segmentNumber - 1 && (bS + (eS - bS) / segmentNumber * (i + 1)) <= d; i++) ;
//                System.out.println("\t\t" + (bS + (double)(eS - bS) / segmentNumber * (i + 1)));
            result[i]++;
        }
        double avrDeviation = 0;
        for (int x : result) {
            System.out.println(x);
            avrDeviation += (double) Math.abs(x - mass.length / segmentNumber);
        }
        System.out.println(avrDeviation);
        avrDeviation = avrDeviation / segmentNumber;
        System.out.println("Average deviation / points amount = " + ((double) avrDeviation / mass.length));
        return result;
    }

    public int getAmountSegments() {
        return amountSegments;
    }

    public void setAmountSegments(int amountSegments) {
        this.amountSegments = amountSegments;
    }
}
