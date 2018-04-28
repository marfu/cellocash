/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.celloCashAdmin.bean.lazyModel.LazyGrossisteModel;
import com.cellocash.model.Grossiste;
import com.cellocash.model.services.IGrossisteService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author marfu
 */

@Named(value = "grossistesBean")
@ViewScoped
public class GrossistesBean implements Serializable{
     @EJB
    private IGrossisteService grossisteService;
     private LazyDataModel<Grossiste> lazyModel;
      private Grossiste selectedGrossiste;

    public LazyDataModel<Grossiste> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Grossiste> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public Grossiste getSelectedGrossiste() {
        return selectedGrossiste;
    }

    public void setSelectedGrossiste(Grossiste selectedGrossiste) {
        this.selectedGrossiste = selectedGrossiste;
    }
      
      @PostConstruct
    public void init() {
        System.out.println("Liste Banque cello cash ");

        //return listImei;
        lazyModel = new LazyGrossisteModel();
        System.out.println("liste banque ====================================" + lazyModel);
    }

      
}
