/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.cellocash.model.CommissionBusiness;

import com.cellocash.model.services.ICommissionBusinessService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marfu
 */

@Named(value = "commissionBusinessBean")
@ViewScoped
public class CommissionBusinessBean implements Serializable {
    
     @EJB
    private ICommissionBusinessService commissionBusinessService;
    
    
    private List<CommissionBusiness> allCommissionBusiness;

    public List<CommissionBusiness> getAllBCommissionBusiness() {
       return commissionBusinessService.getAll();
       // return allBanqueCelloCash;
    }

    public List<CommissionBusiness> getAllCommissionBusiness() {
         return commissionBusinessService.getAll();
        //////return allCommissionBusiness;
    }

    public void setAllCommissionBusiness(List<CommissionBusiness> allCommissionBusiness) {
        this.allCommissionBusiness = allCommissionBusiness;
    }

   
    
    
    
    
    
}
