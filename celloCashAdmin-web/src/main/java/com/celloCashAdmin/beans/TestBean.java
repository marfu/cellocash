/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.cellocash.model.CommissionBusiness;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marfu
 */
@Named(value = "commBusinessBean")
@ViewScoped
public class TestBean implements Serializable{

    private CommissionBusiness commissionBusiness;

    public CommissionBusiness getCommissionBusiness() {
        return commissionBusiness;
    }

    public void setCommissionBusiness(CommissionBusiness commissionBusiness) {
        this.commissionBusiness = commissionBusiness;
    }

    @PostConstruct
    public void init() {
        System.out.println("Liste Banque cello cash ");
        commissionBusiness = new CommissionBusiness();
        //return listImei;

    }

}
