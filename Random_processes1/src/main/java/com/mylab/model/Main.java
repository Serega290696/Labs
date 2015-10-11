package com.mylab.model;

import com.mylab.MainController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by serega.
 */
public class Main {
    private static final RandomValidator validator = new RandomValidator();
    private static final MyRandomizer random = new MyRandomizer();
    private static final CalculateIntegral integral = new CalculateIntegral();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String welcome = "Welcome!\n" +
            "Follow the instructions:\n" +
            "Input '1', '2' or '3' and press 'Enter'\n" +
            "1. Check Java's generator.\n" +
            "2. Check new random numbers generator.\n" +
            "3. Calculate the integral.\n" +
            "4. Launch task#4.\n" +
            "0. Exit\n" +
            "Enter number: ";
    private static final String SEPARATOR = "=======================================\n\n";

    public static void main(String... args) throws IOException {
        args = new String[2];
        String s;
        int amount;
        double[] randMass;
        while (true) {
            System.out.print(welcome);
            s = reader.readLine();
            if(s.length() == 0) {
                System.err.println("Wrong input!");
                continue;
            }
            s = s.substring(0, 1);
            if (s.equals("0")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            args[0] = s;

//            args = new String[]{"3", "0"};
//            if (args.length == 0) {
//                args = new String[]{"1"};
//            }
            switch (Integer.parseInt(args[0])) {
                case 1:
                    amount = 100000;
                    randMass = new double[amount];
                    for (int i = 0; i < amount; i++) {
                        randMass[i] = Math.random();
                    }
                    System.out.println("\nResult:");
                    validator.valid(randMass, 0, 1);
                    break;
                case 2:
                    amount = 100000;
                    randMass = new double[amount];
                    for (int i = 0; i < amount; i++) {
                        randMass[i] = random.nextDouble();
                    }
                    System.out.println("\nResult:");
                    validator.valid(randMass, 0, 1);
                    break;
                case 3:
                    System.out.println("0. Turn back.\n" +
                            "1. First integral.\n" +
                            "2. Second integral.\n" +
                            "3. Third integral.");
                    s = reader.readLine();
                    if (s.length() == 0) {
                        System.err.println("Wrong input!");
                        break;
                    }
                    s = s.substring(0, 1);
                    int intNumber = 0;
                    try {
                        intNumber = Integer.parseInt(s);
                    } catch (Exception e) {
                        System.err.println("Wrong input!");
                        break;
                    }
                    if (intNumber == 0)
                        break;
                    else if (intNumber < 1 || intNumber > 3) {
                        System.err.println("Wrong input!");
                        break;
                    } else args[1] = s.trim();


                    System.out.println("\nResult:");
                    integral.calc(intNumber - 1);
                    break;
                case 4:
                    MainController.startApp();
                default:
                    System.out.println("Wrong input!");
            }
            System.out.print("Press 'Enter' to resume. . .");
            s = reader.readLine();
            System.out.printf(SEPARATOR);

        }



/*
        System.out.println("Max value: " + Integer.MAX_VALUE);
        MyRandomizer r = new MyRandomizer();

        long firstRepetition = -1;
        long t[] = new long[DEFAULT_AMOUNT];
        for (int i = 0; i < DEFAULT_AMOUNT; i++) {
            t[i] = r.nextInt();
            if (t[i] == t[0] && i != 0)
                firstRepetition = i;
//            if (i > 0)
//                System.out.println(t[i - 1] + " ->" + t[i]);
        }

        System.out.println("===========");
        valid(t, 0, MOD);
//        long t[] = new long[DEFAULT_AMOUNT];

//        long firstRepetition = -1;
        long firstValue = r.nextInt();
        for (long i = 0; i < 1_000_000_000_000_000L; i++) {
            if (firstValue == r.nextInt()) {
                firstRepetition = i;//1073741822
                break;
            }
        }
        System.out.println("===========");
        System.out.println("Values before repeating: " + firstRepetition);*/
    }

}
