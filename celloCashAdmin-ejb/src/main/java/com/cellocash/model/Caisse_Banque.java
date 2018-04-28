/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author manukey
 */
@Entity
public class Caisse_Banque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_CELLOCASH", length = 5)
    private Long numeroCellocash;
    @Column(name = "SOLDE_MINIMUM")
    private double soldeMin;
    @Column(name = "SOLDE_MAXIMUM")
    private double soldeMax;
    @Column(name = "NOM_DU_CAISSIER")
    private String nomCaissier;
    @Column(name = "PERSONNE_A_CONTACTER")
    private String personneAContacter;
    @Column(name = "NUMERO_TELEPHONE", length = 15)
    private String numeroTelephone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDENTIFIANT_AGENCE_FK", referencedColumnName = "IDENTIFIANT_AGENCE")
    private Agence_Bancaire agenceBancaire;


    public Long getNumeroCellocash() {
        return numeroCellocash;
    }

    public void setNumeroCellocash(Long numeroCellocash) {
        this.numeroCellocash = numeroCellocash;
    }

    public double getSoldeMin() {
        return soldeMin;
    }

    public void setSoldeMin(double soldeMin) {
        this.soldeMin = soldeMin;
    }

    public double getSoldeMax() {
        return soldeMax;
    }

    public void setSoldeMax(double soldeMax) {
        this.soldeMax = soldeMax;
    }

    public String getNomCaissier() {
        return nomCaissier;
    }

    public void setNomCaissier(String nomCaissier) {
        this.nomCaissier = nomCaissier;
    }

    public String getPersonneAContacter() {
        return personneAContacter;
    }

    public void setPersonneAContacter(String personneAContacter) {
        this.personneAContacter = personneAContacter;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Agence_Bancaire getAgenceBancaire() {
        return agenceBancaire;
    }

    public void setAgenceBancaire(Agence_Bancaire agenceBancaire) {
        this.agenceBancaire = agenceBancaire;
    }
    
    

}
