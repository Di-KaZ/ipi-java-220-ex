package com.ipiecoles.java.java220;

import java.util.HashSet;

public class Manager extends Employe {
    private HashSet<Technicien> equipe = new HashSet<Technicien>();

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase();
    }
    public HashSet<Technicien> getEquipe() {
        return equipe;
    }
    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }
    public void ajoutTechnicienEquipe(Technicien technicien) {
        this.equipe.add(technicien);
    }
}
