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
import org.hibernate.annotations.Index;

/**
 *
 * @author manukey
 */
@Entity

public class Commission_Ligne_Business implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REFERENCE_COMMISSION_BUSINESS")
    private String reference;
    @Column(name = "DESIGNATION_COMMISSION")
    private String designationCommission;
    @Column(name = "NUMERO_LIGNE_BUSINESS")
    private int numeroLigne;
    @Column(name = "DATE_EFFET")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEffet;
    
     @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFin;
    
    @Column(name = "MONTANT_BORNE_SUPERIEUR")
    private double mntBorneSup;
    @Column(name = "TYPE_DE_VALEUR")
    private boolean typeValeur;
    @Column(name = "COMMISSION_EN_VALEUR_CLIENT")
    private double commissionEnValeur;
    @Column(name = "COMMISSION_EN_POURCENTAGE_CLIENT")
    private double commissionEnPourcentage;
    @Column(name = "PART_COMMISSION_DEALER_EN_VALEUR")
    private double partCommissionDealerValeur;
    @Column(name = "PART_COMMISSION_DEALER_EN_POURCENTAGE")
    private double partCommissionDealerPourcentage;
    @Column(name = "PART_COMMISSION_SUB_DEALER_EN_VALEUR")
    private double partCommissionSubDealerValeur;
    @Column(name = "PART_COMMISSION_SUB_DEALER_EN_POURCENTAGE")
    private double partCommissionSubDealerPourcentage;
    
    
    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_ProgrammeFacturationBusiness_FK", referencedColumnName = "id")
    private ProgrammeFacturationBusiness programmeFacturationBusinesse;
    
    
    @Index(name = "bankque_fk")
    private long banque_Cellocash_fk;
    
    
     @Index(name = "agenceBancaire_fk")
    private long agenceBancaire_fk;
    
     
     @Index(name = "pays_fk")
    private long pays_fk;
    
    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_OPERATION_CELLOCASH_FK", referencedColumnName = "IDENTIFIANT_OPERATION")
    private OperationCelloCash operationCellocah;
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignationCommission() {
        return designationCommission;
    }

    public void setDesignationCommission(String designationCommission) {
        this.designationCommission = designationCommission;
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

    public double getCommissionEnPourcentage() {
        return commissionEnPourcentage;
    }

    public void setCommissionEnPourcentage(double commissionEnPourcentage) {
        this.commissionEnPourcentage = commissionEnPourcentage;
    }

    public double getPartCommissionDealerValeur() {
        return partCommissionDealerValeur;
    }

    public void setPartCommissionDealerValeur(double partCommissionDealerValeur) {
        this.partCommissionDealerValeur = partCommissionDealerValeur;
    }

    public double getPartCommissionDealerPourcentage() {
        return partCommissionDealerPourcentage;
    }

    public void setPartCommissionDealerPourcentage(double partCommissionDealerPourcentage) {
        this.partCommissionDealerPourcentage = partCommissionDealerPourcentage;
    }

    public double getPartCommissionSubDealerValeur() {
        return partCommissionSubDealerValeur;
    }

    public void setPartCommissionSubDealerValeur(double partCommissionSubDealerValeur) {
        this.partCommissionSubDealerValeur = partCommissionSubDealerValeur;
    }

    public double getPartCommissionSubDealerPourcentage() {
        return partCommissionSubDealerPourcentage;
    }

    public void setPartCommissionSubDealerPourcentage(double partCommissionSubDealerPourcentage) {
        this.partCommissionSubDealerPourcentage = partCommissionSubDealerPourcentage;
    }

    public OperationCelloCash getOperationCellocah() {
        return operationCellocah;
    }

    public void setOperationCellocah(OperationCelloCash operationCellocah) {
        this.operationCellocah = operationCellocah;
    }

    public long getBanque_Cellocash_fk() {
        return banque_Cellocash_fk;
    }

    public void setBanque_Cellocash_fk(long banque_Cellocash_fk) {
        this.banque_Cellocash_fk = banque_Cellocash_fk;
    }

    public long getAgenceBancaire_fk() {
        return agenceBancaire_fk;
    }

    public void setAgenceBancaire_fk(long agenceBancaire_fk) {
        this.agenceBancaire_fk = agenceBancaire_fk;
    }

    public long getPays_fk() {
        return pays_fk;
    }

    public void setPays_fk(long pays_fk) {
        this.pays_fk = pays_fk;
    }

    public ProgrammeFacturationBusiness getProgrammeFacturationBusinesse() {
        return programmeFacturationBusinesse;
    }

    public void setProgrammeFacturationBusinesse(ProgrammeFacturationBusiness programmeFacturationBusinesse) {
        this.programmeFacturationBusinesse = programmeFacturationBusinesse;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

}
