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
public class Ligne_Commission_Taxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    @Column(name = "REFERENCE_TAXE")
    private String reference;
    @Column(name = "TYPE_TAXE")
    private boolean typeTaxe;
    @Column(name = "DESIGNATION_TAXE", length = 50)
    private String designationTaxe;
    @Column(name = "NUMERO_LIGNE")
    private int numeroLigne;
    @Column(name = "DATE_EFFET")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEffet;
    @Column(name = "MONTANT_BORNE_SUPERIEUR")
    private double mntBorneSup;
    @Column(name = "TYPE_VALEUR")
    private boolean typeValeur;
    @Column(name = "TAXE_EN_VALEUR")
    private double taxeEnValeur;
    @Column(name = "TAXE_EN_POURCENTAGE")
    private int taxeEnPourcentage;

    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_COMMISSION_TAXE_FK", referencedColumnName = "IDENTIFIANT_COMMISSION_TAXE")
    private Commission_Taxe commissionTaxe;

    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_OPERATION_CELLOCASH_FK", referencedColumnName = "IDENTIFIANT_OPERATION")
    private OperationCelloCash operationCellocah;
    
    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_IMPOT_TAXE_FK", referencedColumnName = "IDENTIFIANT_IMPOT_TAXE")
    private ImpotTaxe impotTaxe;

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

    public boolean isTypeTaxe() {
        return typeTaxe;
    }

    public void setTypeTaxe(boolean typeTaxe) {
        this.typeTaxe = typeTaxe;
    }

    public String getDesignationTaxe() {
        return designationTaxe;
    }

    public void setDesignationTaxe(String designationTaxe) {
        this.designationTaxe = designationTaxe;
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

    public double getTaxeEnValeur() {
        return taxeEnValeur;
    }

    public void setTaxeEnValeur(double taxeEnValeur) {
        this.taxeEnValeur = taxeEnValeur;
    }

    public int getTaxeEnPourcentage() {
        return taxeEnPourcentage;
    }

    public void setTaxeEnPourcentage(int taxeEnPourcentage) {
        this.taxeEnPourcentage = taxeEnPourcentage;
    }

    public Commission_Taxe getCommissionTaxe() {
        return commissionTaxe;
    }

    public void setCommissionTaxe(Commission_Taxe commissionTaxe) {
        this.commissionTaxe = commissionTaxe;
    }

    public OperationCelloCash getOperationCellocah() {
        return operationCellocah;
    }

    public void setOperationCellocah(OperationCelloCash operationCellocah) {
        this.operationCellocah = operationCellocah;
    }

    public ImpotTaxe getImpotTaxe() {
        return impotTaxe;
    }

    public void setImpotTaxe(ImpotTaxe impotTaxe) {
        this.impotTaxe = impotTaxe;
    }

   

   

}