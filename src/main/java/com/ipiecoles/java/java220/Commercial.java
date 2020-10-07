package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;

public class Commercial extends Employe {
    private Double caAnnuel;
    private Integer performance;

    public boolean performanceEgale(Integer performance) {
        if (performance == null)
            return false;
        return this.performance.equals(performance);
    }

    public Double getCaAnnuel() {
        return this.caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Integer getPerformance() {
        return performance;
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
    public Commercial() {

    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom , prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        super(nom , prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = performance;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null ||
        this.getClass() != other.getClass() ||
        !super.equals(other) ||
        !this.caAnnuel.equals(((Commercial)other).getCaAnnuel()))
        return false;
        return true;
    }

    public Note equivalenceNote() {
        switch (this.performance) {
            case 0:
                return Note.INSUFFISANT;
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
            default:
                return null;
        }
    }
}
