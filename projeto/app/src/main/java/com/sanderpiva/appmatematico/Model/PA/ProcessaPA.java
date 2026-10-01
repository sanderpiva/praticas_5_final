package com.sanderpiva.appmatematico.Model.PA;

public class ProcessaPA {

    private double resA1, resNmenosUm, resR;

    public ProcessaPA(String resA1, String resNmenosUm, String resR) {

        this.resA1 = Double.parseDouble(resA1);
        this.resNmenosUm = Double.parseDouble(resNmenosUm);
        this.resR = Double.parseDouble(resR);

    }

    public double calculaAn() {
        double respostaAn = this.resA1 + this.resNmenosUm * this.resR;
        return respostaAn;
    }

    public double getResA1() {
        return resA1;
    }

    public double getResNmenosUm() {
        return resNmenosUm;
    }

    public double getResR() {
        return resR;
    }
}
