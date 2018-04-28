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
public class Tontine_Cellocash implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_TONTINE")
    private Long numero;
@Column(name = "DESIGNATION_TONTINE",length = 50)
private String designation;
@Column(name = "ECHEANCE_DE_REMBOURSEMENT")
private int echeanceRemboursement;
@Column(name = "INTERET_FIN_PERIODE")
private double interetFinPeriode;
@Column(name = "ECHEANCE_REMBOURSEMENT_FORCE")
private int echeanceRemboursementForce;
@Column(name = "NOMBRE_DE_MEMBRE_DU_GROUPE")
private int nombreMembreGrpe;
@Column(name = "FREQUENCE_DE_REMBOURSEMENT")
private String frequence;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName="IDENTIFIANT_BANQUE")
private Banque_Cellocash banqueCellocash;
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getEcheanceRemboursement() {
        return echeanceRemboursement;
    }

    public void setEcheanceRemboursement(int echeanceRemboursement) {
        this.echeanceRemboursement = echeanceRemboursement;
    }

    public double getInteretFinPeriode() {
        return interetFinPeriode;
    }

    public void setInteretFinPeriode(double interetFinPeriode) {
        this.interetFinPeriode = interetFinPeriode;
    }

    public int getEcheanceRemboursementForce() {
        return echeanceRemboursementForce;
    }

    public void setEcheanceRemboursementForce(int echeanceRemboursementForce) {
        this.echeanceRemboursementForce = echeanceRemboursementForce;
    }

    public int getNombreMembreGrpe() {
        return nombreMembreGrpe;
    }

    public void setNombreMembreGrpe(int nombreMembreGrpe) {
        this.nombreMembreGrpe = nombreMembreGrpe;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public Banque_Cellocash getBanqueCellocash() {
        return banqueCellocash;
    }

    public void setBanqueCellocash(Banque_Cellocash banqueCellocash) {
        this.banqueCellocash = banqueCellocash;
    }
    

   
}
