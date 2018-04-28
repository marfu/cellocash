/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.cellocash.model.Pays;
import com.cellocash.model.services.IPaysService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marfu
 */
@Named(value = "paysBean")
@ViewScoped
public class PaysBean implements Serializable {

    @EJB
    private IPaysService paysService;

    private List<Pays> allPays;

    public List<Pays> getAllPays() {
          return allPays=paysService.getAllPays();
       
    }

    public void setAllPays(List<Pays> allPays) {
        this.allPays = allPays;
    }

    

}
