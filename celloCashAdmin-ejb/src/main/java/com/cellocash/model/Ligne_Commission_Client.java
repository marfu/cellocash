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

public class Ligne_Commission_Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Id
    @Column(name = "REFERENCE_COMMISSION_CLIENT")
    private String reference;
 
    @Column(name = "NUMERO_LIGNE")
    private int numeroLigne;
    @Column(name = "DATE_EFFET")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEffet;
    @Column(name = "COMMISSION_BORNE_SUPERIEUR")
    private double mntBorneSup;
    @Column(name = "TYPE_VALEUR")
    private boolean typeValeur;
    @Column(name = "COMMISSION_EN_VALEUR")
    private double commissionEnValeur;
    @Column(name = "COMMISSION_EN_POURCENTAGE")
    private int commissionEnPourcentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_TAXE_FK", referencedColumnName = "CODE_TAXE")
    private Commissions_Client commissionClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODE_OPERATION_FK", referencedColumnName = "CODE_OPERATION")
    private OperationCelloCash operationCellocah;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getNumeroLigne() {
        return numeroLigne;
    }

    public void setNumeroLigne(int numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public double getMntBorneSup() {
        return mntBorneSup;
    }

    public void setMntBorneSup(double mntBorneSup) {
        this.mntBorneSup = mntBorneSup;
    }

    public boolean isTypeValeur() {
        return typeValeur;
    }

    public void setTypeValeur(boolean typeValeur) {
        this.typeValeur = typeValeur;
    }

    public double getCommissionEnValeur() {
        return commissionEnValeur;
    }

    public void setCommissionEnValeur(double commissionEnValeur) {
        this.commissionEnValeur = commissionEnValeur;
    }

    public int getCommissionEnPourcentage() {
        return commissionEnPourcentage;
    }

    public void setCommissionEnPourcentage(int commissionEnPourcentage) {
        this.commissionEnPourcentage = commissionEnPourcentage;
    }

    public Commissions_Client getCommissionClient() {
        return commissionClient;
    }

    public void setCommissionClient(Commissions_Client commissionClient) {
        this.commissionClient = commissionClient;
    }

   

    public OperationCelloCash getOperationCellocah() {
        return operationCellocah;
    }

    public void setOperationCellocah(OperationCelloCash operationCellocah) {
        this.operationCellocah = operationCellocah;
    }

    
   

}
