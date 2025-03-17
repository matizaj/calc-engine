package com.ps.calcengine;

public class MathEquation {
    double val1;
    double val2;
    char opCode;
    double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public static double getAverageResult(){
        return sumOfResults/numberOfCalculations;
    }

    public MathEquation(){}
    public MathEquation(char opCode) {
        this.opCode=opCode;
    }

    public MathEquation(char opCode, double val1, double val2) {
        this(opCode);
        this.val1=val1;
        this.val2=val2;
    }

    @Override
    public String toString() {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder sb = new StringBuilder();
        sb.append(val1).append(symbol).append(val2).append(" = ").append(result);
        return sb.toString();
    }
    public char symbolFromOpCode(char opCode) {
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

    void execute() {
        switch (opCode) {
            case 'a':
                result= val1 + val2;
                break;
            case 's':
                result= val1 - val2;
                break;
            case 'm':
                result= val1 * val2;
                break;
            case 'd':
                result= val2 != 0 ? val1 / val2 : 0.0d;
                break;
        }

        numberOfCalculations++;
        sumOfResults+=result;
    }
    void execute(double val1, double val2) {
        this.val1=val1;
        this.val2=val2;

        execute();
    }
}
