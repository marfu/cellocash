/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author marfu
 */
@Entity
public class CommissionBusiness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IDENTIFIANT_COMMISSION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE_TAXE", length = 5)
    private String code;

    @Column(name = "DESIGNATION_COMMISSION")
    private String designationCommission;

    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName = "IDENTIFIANT_AGENCE")
    private Agence_Bancaire agenceBancaire;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof CommissionBusiness)) {
            return false;
        }
        CommissionBusiness other = (CommissionBusiness) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignationCommission() {
        return designationCommission;
    }

    public void setDesignationCommission(String designationCommission) {
        this.designationCommission = designationCommission;
    }

    public Agence_Bancaire getAgenceBancaire() {
        return agenceBancaire;
    }

    public void setAgenceBancaire(Agence_Bancaire agenceBancaire) {
        this.agenceBancaire = agenceBancaire;
    }

    

}
