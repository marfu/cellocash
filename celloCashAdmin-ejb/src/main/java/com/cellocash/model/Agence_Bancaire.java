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
import org.hibernate.annotations.Index;


/**
 *
 * @author manukey
 */
@Entity
public class Agence_Bancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFIANT_AGENCE")
    private Long id;

    @Column(name = "CODE_AGENCE", length = 3)
    private String code;

    @Column(name = "DESIGNATION_AGENCE")
    private String designation;

    @ManyToOne(optional = true)
    @JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName = "IDENTIFIANT_BANQUE")
    private Banque_Cellocash banqueCellocash;

    @ManyToOne
    @JoinColumn(name = "TYPE_AGENCE_BANCAIRE_FK", referencedColumnName = "TYPE_AGENCE_BANCAIRE")
    private Type_Agence_Bancaire TypeAgenceBancaire;

     @Column(name = "PREFIXE_COMPTE_ORDINAIRE")
    private int prefixeCpteOrdinaire;

    @Column(name = "PREFIXE_COMPTE_EPARGNE")
    private int prefixeCpteneEparg;
    
    @Column(name = "STATUT")
    private boolean statut;
   
    
    
    @Index(name = "pays_fk")
    private long pays_fk;
    
    
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Type_Agence_Bancaire getTypeAgenceBancaire() {
        return TypeAgenceBancaire;
    }

    public void setTypeAgenceBancaire(Type_Agence_Bancaire TypeAgenceBancaire) {
        this.TypeAgenceBancaire = TypeAgenceBancaire;
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
        if (!(object instanceof Agence_Bancaire)) {
            return false;
        }
        Agence_Bancaire other = (Agence_Bancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Banque_Cellocash getBanqueCellocash() {
        return banqueCellocash;
    }

    public void setBanqueCellocash(Banque_Cellocash banqueCellocash) {
        this.banqueCellocash = banqueCellocash;
    }

    public int getPrefixeCpteOrdinaire() {
        return prefixeCpteOrdinaire;
    }

    public void setPrefixeCpteOrdinaire(int prefixeCpteOrdinaire) {
        this.prefixeCpteOrdinaire = prefixeCpteOrdinaire;
    }

    public int getPrefixeCpteneEparg() {
        return prefixeCpteneEparg;
    }

    public void setPrefixeCpteneEparg(int prefixeCpteneEparg) {
        this.prefixeCpteneEparg = prefixeCpteneEparg;
    }

    public long getPays_fk() {
        return pays_fk;
    }

    public void setPays_fk(long pays_fk) {
        this.pays_fk = pays_fk;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    
    
   
}
