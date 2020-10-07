package com.ipiecoles.java.java220;
import java.util.Objects;

import org.joda.time.LocalDate;

public class Technicien extends Employe implements Comparable<Technicien> {
    private Integer grade;

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public Technicien() {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        String multiplier = "1.".concat(this.grade.toString()).concat("0");

        super.setSalaire(salaire * Double.parseDouble(multiplier));
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + super.getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + Entreprise.primeAnnuelleBase() * ((double) this.grade / 10)  + (Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete());
    }

    @Override
    public int compareTo(Technicien other) {
        if (this.grade > other.getGrade())
            return 1;
        if (this.grade < other.getGrade())
            return -1;
        return 0;
    }
    @Override
    public int hashCode() {
        return  Objects.hash(super.hashCode(), this.grade != null ? this.grade.hashCode() : 0);
    }
}
