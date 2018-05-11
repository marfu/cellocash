/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dto;

import java.util.Date;

/**
 *
 * @author marfu
 */
public class CommissionBusinessDTO {

    private Long id;
    private String pays;
    private String agenceBancaire;
    private String banque;
    private String operationBusiness;
    private String programmeBusiness;
    private Date dateEffet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAgenceBancaire() {
        return agenceBancaire;
    }

    public void setAgenceBancaire(String agenceBancaire) {
        this.agenceBancaire = agenceBancaire;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getOperationBusiness() {
        return operationBusiness;
    }

    public void setOperationBusiness(String operationBusiness) {
        this.operationBusiness = operationBusiness;
    }

    public String getProgrammeBusiness() {
        return programmeBusiness;
    }

    public void setProgrammeBusiness(String programmeBusiness) {
        this.programmeBusiness = programmeBusiness;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }
   

    
}
