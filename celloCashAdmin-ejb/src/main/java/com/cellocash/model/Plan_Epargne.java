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
public class Plan_Epargne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_DU_PLAN_EPARGNE")
    private Long numeroPlanEpargne;
    @Column(name = "FREQUENCE_PRELEVEMENT")
    private String frequence;
    @Column(name = "DESIGNATION_DU_PLAN_EPARGNE")
    private String designation;
    @Column(name = "INTERET_APPLIQUE")
    private double interetApplique;
    @Column(name = "NOMBRE_DE_PERIODE")
    private int nombrePeriode;

    @Column(name = "DATE_DE_CREATION_DU_CHAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateCreationChamp;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "DATE_DE_SUPPRESSION")
    private Date dateSuppression;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName = "IDENTIFIANT_BANQUE")
    private Banque_Cellocash banqueCellocash;

    public Long getNumeroPlanEpargne() {
        return numeroPlanEpargne;
    }

    public void setNumeroPlanEpargne(Long numeroPlanEpargne) {
        this.numeroPlanEpargne = numeroPlanEpargne;
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

    public double getInteretApplique() {
        return interetApplique;
    }

    public void setInteretApplique(double interetApplique) {
        this.interetApplique = interetApplique;
    }

    public int getNombrePeriode() {
        return nombrePeriode;
    }

    public void setNombrePeriode(int nombrePeriode) {
        this.nombrePeriode = nombrePeriode;
    }

    public Date getDateCreationChamp() {
        return dateCreationChamp;
    }

    public void setDateCreationChamp(Date dateCreationChamp) {
        this.dateCreationChamp = dateCreationChamp;
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
