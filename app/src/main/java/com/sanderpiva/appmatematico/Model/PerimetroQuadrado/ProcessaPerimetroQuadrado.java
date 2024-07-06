package com.sanderpiva.appmatematico.Model.PerimetroQuadrado;

public class ProcessaPerimetroQuadrado {

    private double lado;
    public ProcessaPerimetroQuadrado(String ladoQuadradoString) {

        lado = Double.parseDouble(ladoQuadradoString);
    }

    public double resultadoPerimetroQuadrado(){

        Double resPerimetro = 4*lado;
        if(resPerimetro<=0){
            return 0;
        }else {
            return resPerimetro;
        }
    }
}
