package com.ps.calcengine;

import java.util.List;

import static com.ps.calcengine.MathOperation.*;

public class MathEquation {
    double val1;
    double val2;
    MathOperation opCode;
    double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public static double getAverageResult(){
        return sumOfResults/numberOfCalculations;
    }

    public MathEquation(){}
    public MathEquation(MathOperation opCode) {
        this.opCode=opCode;
    }

    public MathEquation(MathOperation opCode, double val1, double val2) {
        this(opCode);
        this.val1=val1;
        this.val2=val2;
    }

    @Override
    public String toString() {
        char symbol = opCode.getSymbol();
        StringBuilder sb = new StringBuilder();
        sb.append(val1).append(symbol).append(val2).append(" = ").append(result);
        return sb.toString();
    }



    void execute() {
        switch (opCode) {
            case ADD:
                result= val1 + val2;
                break;
            case SUBSTRACT:
                result= val1 - val2;
                break;
            case MULTIPLY:
                result= val1 * val2;
                break;
            case DIVIDE:
                if (val2 ==0 )
                    throw new ArithmeticException();
                result= val1 / val2;
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
