package com.sanderpiva.appmatematico.Model.Proporcao;

public class ProcessaProporcao {

    private double A, B, C;

    public ProcessaProporcao(String A, String B, String C) {

        this.A=Double.parseDouble(A);
        this.B=Double.parseDouble(B);
        this.C=Double.parseDouble(C);

    }

    public double calculaProporcao(){

        double numerador = this.C * this.B;
        double denominador = this.A;

        if((numerador / denominador)<0){
            return 0;
        }
        return numerador / denominador;

    }

    public double getV1(){

        return this.A;
    }

    public double getV2(){

        return this.B;

    }

    public double getV3(){

        return this.C;
    }
}
