package com.ipiecoles.java.java220;

public class Commercial extends Employe {
    private Double caAnnuel;

    public Double getCaAnnuel() {
        return this.caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    @Override
    public Double getPrimeAnnuelle() {
        if (caAnnuel == null)
            return 500.0;
        Double res = Math.ceil(caAnnuel * 0.05);
        if (res < 500.0)
            return 500.0;
        else
            return res;
    }

}
