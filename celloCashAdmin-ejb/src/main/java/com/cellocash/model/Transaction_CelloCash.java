/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author manukey
 */
@Entity
public class Transaction_CelloCash implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "REFERENCE_TRANSACTION")
    private String reference;
    @Column(name = "DATE_TRANSACTION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTransaction;
    @Column(name = "MONTANT_CREDIT")
    private BigDecimal montantCredit;
    @Column(name = "MONTANT_DEBIT")
    private BigDecimal montantDebit;
    @Column(name = "SOLDE_COMPTE")
    private BigDecimal soldeCompte;
    @Column(name = "DESIGNATION_TRANSACTION")
    private String designation;
    @Column(name = "COMMENTAIRE_TRANSACTON")
    private String commentaire;

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

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public BigDecimal getMontantCredit() {
        return montantCredit;
    }

    public void setMontantCredit(BigDecimal montantCredit) {
        this.montantCredit = montantCredit;
    }

    public BigDecimal getMontantDebit() {
        return montantDebit;
    }

    public void setMontantDebit(BigDecimal montantDebit) {
        this.montantDebit = montantDebit;
    }

    public BigDecimal getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(BigDecimal soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction_CelloCash)) {
            return false;
        }
        Transaction_CelloCash other = (Transaction_CelloCash) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ceenet.cellocash.model.Transaction_CelloCash[ id=" + id + " ]";
    }

}
