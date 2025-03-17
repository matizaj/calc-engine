package com.ps.calcengine;


import java.util.Objects;
import java.util.Scanner;

import static com.ps.calcengine.MathEquation.*;

public class Main {
    public static void  main(String[] args) {

        if (args.length == 0) {
            performCalculation();
        } else if (args.length == 3) {
            performOperations(args);
        } else if (Objects.equals(args[0], "interactive")) {
            executeInteractively();
        }else {
            System.out.println("Wrong number of cmd line args");
        }
    }

    private static void performCalculation() {
        System.out.println("Calc Engine v1");

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(MathOperation.ADD,100.0d, 50.0d);
        equations[1] = new MathEquation(MathOperation.SUBSTRACT, 125.0d, 25.0d);
        equations[2] = new MathEquation(MathOperation.MULTIPLY, 130.0d, 10.0d);
        equations[3] = new MathEquation(MathOperation.DIVIDE, 50.0d, 15.0d);

        for(MathEquation eq: equations) {
            eq.execute();
            System.out.println(eq);
        }
        System.out.println("Average: " + getAverageResult());

        // useOverloads();

    }

    private static void useOverloads() {
        MathEquation eqOverload = new MathEquation(MathOperation.DIVIDE);
        double val1=9.0d;
        double val2=4.0d;
        eqOverload.execute(val1, val2);
        System.out.println("Equation overload result: " + eqOverload.result);
    }

    static void executeInteractively() {
        System.out.println("enter a operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String usrInput = scanner.nextLine();
        String[] parts = usrInput.split(" ");
        performOperations(parts);
    }

    private static void performOperations(String[] parts) {
        MathOperation opCode = MathOperation.valueOf(parts[0].toUpperCase());
        double val1 = valueFromWord(parts[1]);
        double val2 = valueFromWord(parts[2]);
        MathEquation eq = new MathEquation(opCode, val1, val2);
        eq.execute(val1, val2);
        System.out.println(eq);
    }

    static double valueFromWord(String word) {
        String[] wordList = { "zero","one", "two","three", "four", "five", "six", "seven",
        "eight", "nine", "ten"};

        double value = 0d;
        boolean isValueSet= false;
        for (int i = 0; i < wordList.length; i++) {
            if(word.equals(wordList[i])){
                value=i;
                isValueSet=true;
                break;
            }
        }

        if(!isValueSet) {
            value = Double.parseDouble(word);
        }
        return value;
    }
}
