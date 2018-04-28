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
 * @author manukey
 */
@Entity
public class Commission_Taxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFIANT_COMMISSION_TAXE")
    private Long id;

    @Column(name = "CODE_TAXE", length = 5)
    private String code;

    @Column(name = "DESIGNATION_COMMISSION")
    private String designationCommission;

    @Column(name = "DESIGNATION_DE_LA_TAXE")
    private String designationTaxe;
    @ManyToOne
    @JoinColumn(name = "IDENTIFIANT_BANQUE_FK", referencedColumnName = "IDENTIFIANT_BANQUE")
    private Banque_Cellocash banqueCellocash;



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

    public String getDesignationTaxe() {
        return designationTaxe;
    }

    public void setDesignationTaxe(String designationTaxe) {
        this.designationTaxe = designationTaxe;
    }

    public Banque_Cellocash getBanqueCellocash() {
        return banqueCellocash;
    }

    public void setBanqueCellocash(Banque_Cellocash banqueCellocash) {
        this.banqueCellocash = banqueCellocash;
    }

//    public Agence_Bancaire getAgenceBancaire() {
//        return agenceBancaire;
//    }
//
//    public void setAgenceBancaire(Agence_Bancaire agenceBancaire) {
//        this.agenceBancaire = agenceBancaire;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Commission_Taxe{" + "id=" + id + ", code=" + code + ", designationCommission=" + designationCommission + ", designationTaxe=" + designationTaxe + ", banqueCellocash=" + banqueCellocash + '}';
    }

   

}