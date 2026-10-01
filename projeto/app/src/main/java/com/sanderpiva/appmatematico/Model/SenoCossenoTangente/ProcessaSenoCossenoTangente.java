package com.sanderpiva.appmatematico.Model.SenoCossenoTangente;

public class ProcessaSenoCossenoTangente {

    private double co, ca, hip;
    public ProcessaSenoCossenoTangente(String co, String ca, String hip) {

        this.co = Double.parseDouble(co);
        this.ca = Double.parseDouble(ca);
        this.hip = Double.parseDouble(hip);

    }

    public double resultadoSeno(){

        Double seno = this.co/this.hip;

        if(seno<=0){
            return 0;
        }else{

            return seno;
        }
    }


    public double resultadoCosseno(){

        Double cosseno = this.ca/this.hip;
        if(cosseno<=0){
            return 0;
        }else{

            return cosseno;
        }
    }


    public double resultadoTangente(){
        Double tangente = this.co/this.ca;

        if(tangente<=0){
            return 0;
        }else{

            return tangente;
        }
    }

    public double getCa() {
        if(this.ca<=0){
            return 0;
        }else{

            return this.ca;
        }
    }

    public double getCo() {
        if(this.co<=0){
            return 0;
        }else{

            return this.co;
        }
    }

    public double getHip() {
        if(this.hip<=0){
            return 0;
        }else{

            return this.hip;
        }
    }
}
