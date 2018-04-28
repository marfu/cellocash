/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author manukey
 */
@Entity
public class Prets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_PRETS")
    private Long numeroPret;
    @Column(name = "TYPE_PRETS")
    private boolean typePret;
    @Column(name = "FREQUENCE")
    private String frequence;
    @Column(name = "DESIGNATION_DU_PRET")
    private String designation;
    @Column(name = "INTERET")
    private double interet;
    @Column(name = "NOMBRE_DE_REMBOURSEMENT")
    private int nombreRemboursement;
    @Column(name = "FACTEUR")
    private double facteur;
    @Column(name = "DATE_CREATION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "DATE_DE_SUPPRESSION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateSuppression;
    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName="IDENTIFIANT_BANQUE")
private Banque_Cellocash banqueCellocash;

    public Long getNumeroPret() {
        return numeroPret;
    }

    public void setNumeroPret(Long numeroPret) {
        this.numeroPret = numeroPret;
    }

    public boolean isTypePret() {
        return typePret;
    }

    public void setTypePret(boolean typePret) {
        this.typePret = typePret;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getInteret() {
        return interet;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }

    public int getNombreRemboursement() {
        return nombreRemboursement;
    }

    public void setNombreRemboursement(int nombreRemboursement) {
        this.nombreRemboursement = nombreRemboursement;
    }

    public double getFacteur() {
        return facteur;
    }

    public void setFacteur(double facteur) {
        this.facteur = facteur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public Banque_Cellocash getBanqueCellocash() {
        return banqueCellocash;
    }

    public void setBanqueCellocash(Banque_Cellocash banqueCellocash) {
        this.banqueCellocash = banqueCellocash;
    }

   

}
