package com.mylab;

import java.util.function.Function;

/**
 * Created by serega.
 */
public class MyRandomizer {

    private static final long MULTI = 35317 ;
    private static final long ADDED = 127;
    private static final long MOD = Integer.MAX_VALUE;
    private static long seed = 5555;
    private Function<Long, Long> function = (s) -> (MULTI * s + ADDED) % MOD;
    public static final int DEFAULT_AMOUNT = 1_0000_000;


    public long nextInt() {
        return seed = function.apply(seed);
    }

    public long nextInt(long newMod) {
        return (seed = function.apply(seed)) % newMod;
    }

    public double nextDouble() {
        return (double)(seed = function.apply(seed))/MOD;
    }

    public static void main(String[] args) {
    }

    private static void valid(long[] mass, double b, double s) {
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

    private static void valid(double[] mass, double b, double s) {
        final int segmentNumber = 5;
        double bS = b;
        double eS = s;
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

    public long[] nextIntMass(int newAmount, long newMod) {
        long[] res = new long[newAmount];
        for (int i = 0; i < res.length; i++) {
            res[i] = nextInt(newMod);
        }
        return res;
    }
}
