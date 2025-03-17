package com.ps.calcengine;


import java.util.Objects;
import java.util.Scanner;

import static com.ps.calcengine.MathEquation.*;

public class Main {
    public static void  main(String[] args) {

        if (args.length == 0) {
            performCalculation();
        } else if (args.length == 3) {
            handleCommandArgs(args);
        } else if (Objects.equals(args[0], "interactive")) {
            executeInteractively();
        }else {
            System.out.println("Wrong number of cmd line args");
        }
    }

    private static void performCalculation() {
        System.out.println("Calc Engine v1");

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('a',100.0d, 50.0d);
        equations[1] = new MathEquation('s', 125.0d, 25.0d);
        equations[2] = new MathEquation('m', 130.0d, 10.0d);
        equations[3] = new MathEquation('d', 50.0d, 15.0d);

        for(MathEquation eq: equations) {
            eq.execute();
            System.out.println(eq);
        }
        System.out.println("Average: " + getAverageResult());

        // useOverloads();

    }

    private static void useOverloads() {
        MathEquation eqOverload = new MathEquation('d');
        double val1=9.0d;
        double val2=4.0d;
        eqOverload.execute(val1, val2);
        System.out.println("Equation overload result: " + eqOverload.result);
    }


    private static void handleCommandArgs(String[] args) {
        char opCode = args[0].charAt(0);
        double val1 = Double.parseDouble(args[1]);
        double val2 = Double.parseDouble(args[2]);

        double res = execute(opCode, val1, val2);
        System.out.println(res);
    }

    static void executeInteractively() {
        System.out.println("enter a operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String usrInput = scanner.nextLine();
        String[] parts = usrInput.split(" ");
        performOperations(parts);
    }

    private static void performOperations(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double val1 = valueFromWord(parts[1]);
        double val2 = valueFromWord(parts[2]);

        double result = execute(opCode, val1, val2);
//        System.out.println(result);
        displayResult(opCode, val1, val2, result);
    }

    private static void displayResult(char opCode, double val1, double val2, double result) {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder sb = new StringBuilder();
        sb.append(val1).append(symbol).append(val2).append(" = ").append(result);
        System.out.println(sb.toString());
    }

    public static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol=' ';
        for (int i =0; i<opCodes.length; i++) {
            if(opCode == opCodes[i]){
                symbol = symbols[i];
            }
        }
        return symbol;
    }

    public static double execute(char opCode, double val1, double val2) {
        double result = 0;

        return result;
    }

    static char opCodeFromString(String operationName) {
        return operationName.charAt(0);
    }

    static double valueFromWord(String word) {
        String[] wordList = { "zero","one", "two","three", "four", "five", "six", "seven",
        "eight", "nine", "ten"};

        double value = 0d;

        for (int i = 0; i < wordList.length; i++) {
            if(word.equals(wordList[i])){
                value=i;
                break;
            }
        }
        return value;
    }
}
