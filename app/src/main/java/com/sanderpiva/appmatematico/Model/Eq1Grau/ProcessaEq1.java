package com.sanderpiva.appmatematico.Model.Eq1Grau;

public class ProcessaEq1 {

    private double a;
    private double b;
    private String op;
    public ProcessaEq1(String resA, String resOperador, String resB) {
        a = Double.parseDouble(resA);
        op = resOperador;
        b = Double.parseDouble(resB);

    }

    public double calculaEq1(){

        if(op.equals("+"))
            return -b/a;
        else
            return b/a;

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getOp() {
        return op;
    }
}
