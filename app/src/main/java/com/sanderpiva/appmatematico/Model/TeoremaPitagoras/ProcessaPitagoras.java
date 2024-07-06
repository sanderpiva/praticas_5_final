package com.sanderpiva.appmatematico.Model.TeoremaPitagoras;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ProcessaPitagoras {

    private double ca1PP, ca2PP, quadrados;

    public ProcessaPitagoras(String ca1, String ca2) {

        ca1PP = Double.parseDouble(ca1);
        ca2PP = Double.parseDouble(ca2);
        quadrados = (pow(ca1PP,2)+pow(ca2PP,2));

    }

    public double resultadoHipAoQuadrado(){
        if(quadrados<=0){
            return 0;
        }else{

            return quadrados;
        }
    }

    public double resultadoHip(){
        if(quadrados<=0){
            return 0;
        }else{

            return sqrt(quadrados);
        }
    }

    public double resultadoCa1(){
        if(ca1PP<=0){
            return 0;
        }else{

            return pow(ca1PP,2);
        }
    }

    public double resultadoCa2(){
        if(ca2PP<=0){
            return 0;
        }else{

            return pow(ca2PP,2);
        }
    }
}
