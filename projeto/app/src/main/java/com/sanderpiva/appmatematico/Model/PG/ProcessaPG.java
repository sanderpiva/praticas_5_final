package com.sanderpiva.appmatematico.Model.PG;


public class ProcessaPG {

    private double resA1, resNmenosUm, resQ;

    public ProcessaPG(String resA1, String resNmenosUm, String resQ) {

        this.resA1 = Double.parseDouble(resA1);
        this.resNmenosUm = Double.parseDouble(resNmenosUm);
        this.resQ = Double.parseDouble(resQ);
    }

    public double calculaAn() {

        double qElevadoNmenosUm = Math.pow(resQ, resNmenosUm);

        return this.resA1*qElevadoNmenosUm;
    }

    public double getResA1() {
        return resA1;
    }

    public double getResNmenosUm() {
        return resNmenosUm;
    }

    public double getResQ() {
        return resQ;
    }
}
