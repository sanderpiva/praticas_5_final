package com.sanderpiva.appmatematico.Model.AreaQuadrado;


import static java.lang.Math.pow;

public class ProcessaAreaQuadrado {

    private double ladoQuadrado;
    public ProcessaAreaQuadrado(String ladoQuadradoString) {

        ladoQuadrado = Double.parseDouble(ladoQuadradoString);
    }

    public double resultadoAreaQuadrado(){

        if(ladoQuadrado<=0){
            return 0;
        }else{
            return pow(ladoQuadrado,2);
        }
    }
}
