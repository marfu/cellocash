/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.beans;

import com.cellocash.model.ProgrammeFacturationBusiness;
import com.cellocash.model.services.IProgrammeFacturationBusinessService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marfu
 */

@Named(value = "programmeFacturationBean")
@ViewScoped
public class ProgrammeFacturationBusinessBean {
    @EJB
    private IProgrammeFacturationBusinessService paysService;

    private List<ProgrammeFacturationBusiness> allProgrammeFacturation;

    public List<ProgrammeFacturationBusiness> getAllProgrammeFacturation() {
          return allProgrammeFacturation=paysService.getAll();
       
    }

    public void setAllProgrammeFacturation(List<ProgrammeFacturationBusiness> allPays) {
        this.allProgrammeFacturation = allPays;
    }
}
