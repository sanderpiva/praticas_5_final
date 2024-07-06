package com.sanderpiva.appmatematico.Model.Eq2Grau;

public class ProcessaEq2 {

    private Double resA, resB, resC, delta, raizDelta, x1, x2;
    private String resOperador1, resOperador2;

    public ProcessaEq2(String resA, String resOperador1, String resB, String resOperador2, String resC) {

        this.resA = Double.parseDouble(resA);
        this.resOperador1 = resOperador1;
        this.resB = Double.parseDouble(resB);
        this.resOperador2 = resOperador2;
        this.resC = Double.parseDouble(resC);
    }
    public Double getResA() {
        return resA;
    }

    public Double getResC() {

        if(this.resOperador2.equals("+")){
            return resC;
        }else{
            return -1*resC;
        }
    }

    public Double getResB() {

        if(this.resOperador1.equals("+")){
            return resB;
        }else{
            return -1*resB;
        }
    }

    public Double getComponente(){
        if(this.resOperador2.equals("+")){
            return -4*resA*resC;
        }else{
            return +4*resA*resC;
        }
    }
}
