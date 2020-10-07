package com.ipiecoles.java.java220;

import java.util.Objects;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */

public abstract class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return this.matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return this.dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche == null || dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return this.salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
    public Employe() {
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.prenom = prenom;
        this.nom = nom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete() {
        return LocalDate.now().getYear() - this.dateEmbauche.getYear();
    }

    public Integer getNbConges () {
        return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public String toString() {
        return "Employe{nom='" + this.nom + "', prenom='" + this.prenom + "', matricule='" + this.matricule + "', dateEmbauche="+ (this.dateEmbauche != null ? this.dateEmbauche.toString() : 0) + ", salaire=" + this.salaire + "}";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Employe employe2 = (Employe) other;
        if (this.nom == employe2.nom &&
            this.prenom == employe2.prenom &&
            (this.dateEmbauche != null ? this.dateEmbauche.equals(employe2.dateEmbauche) : true)  &&
            this.matricule == employe2.matricule &&
            (this.salaire != null ? this.salaire.equals(employe2.salaire) : true)) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.nom != null ? this.nom.hashCode() : 0,
                            this.prenom != null ? this.prenom.hashCode() : 0,
                            this.matricule != null ? this.matricule.hashCode() : 0,
                            this.dateEmbauche != null ? this.dateEmbauche.hashCode() : 0,
                            this.salaire != null ? this.salaire.hashCode() : 0);
    }
    public void augmenterSalaire(Double pourcentage) {
            this.salaire = this.salaire + this.salaire * pourcentage;
    }

    public abstract Double getPrimeAnnuelle();
}
