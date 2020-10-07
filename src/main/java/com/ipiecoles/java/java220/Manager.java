package com.ipiecoles.java.java220;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;

import org.joda.time.LocalDate;

public class Manager extends Employe {
    private HashSet<Technicien> equipe = new HashSet<Technicien>();

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
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
    @Override
    public void setSalaire(Double salaire) {
        Double multiplier = Double.parseDouble("0.".concat(Integer.toString(this.equipe.size())).concat("0"));
        Double res = salaire * (Entreprise.INDICE_MANAGER + multiplier);

        super.setSalaire(BigDecimal.valueOf(res).setScale(3, RoundingMode.HALF_UP).doubleValue());
    }

    private void augmenterSalaireEquipe(Double pourcentage) {
        for (Technicien equipier : this.equipe) {
            equipier.augmenterSalaire(pourcentage);
        }
    }

    @Override
    public void augmenterSalaire(Double pourcentage) {
        augmenterSalaireEquipe(pourcentage);
        super.augmenterSalaire(pourcentage);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
		this.ajoutTechnicienEquipe(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
	}
}
