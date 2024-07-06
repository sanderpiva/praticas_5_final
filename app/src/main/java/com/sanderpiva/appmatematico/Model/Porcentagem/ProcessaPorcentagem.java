package com.sanderpiva.appmatematico.Model.Porcentagem;

public class ProcessaPorcentagem {

    private String valor1, valor2, op;
    public ProcessaPorcentagem(String resV1, String resV2, String resOp) {
        valor1 = resV1;
        valor2 = resV2;
        op = resOp;
    }
    public double calculaPorcentagem() {
        double v = (Double.parseDouble(valor1)*Double.parseDouble(valor2))/100;
        if(op.equals("+")){
            return (Double.parseDouble(valor1)) + v;
        }else if(op.equals("-")) {
            return (Double.parseDouble(valor1)) - v;
        }else{
            return 0;
        }
    }

    public double getValor1(){

        return Double.parseDouble(valor1);
    }

    public double getValor2(){

        return Double.parseDouble(valor2);
    }

    public String op(){

        return op;
    }
}
