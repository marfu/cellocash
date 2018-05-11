/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.ProgrammeFacturationBusiness;
import com.cellocash.model.dao.ProgrammeFacturationBusinessDao;
import com.cellocash.model.services.IProgrammeFacturationBusinessService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */

@SuppressWarnings("serial")
@Stateless
@Local(IProgrammeFacturationBusinessService.class)
public class ProgrammeFacturationBusinessServiceImpl  implements IProgrammeFacturationBusinessService, Serializable{
    @EJB
    private ProgrammeFacturationBusinessDao programmeFacturationBusinessDao;
    
    @Override
    public List<ProgrammeFacturationBusiness> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return programmeFacturationBusinessDao.findAll();
    }

    @Override
    public ProgrammeFacturationBusiness get(Long id) {
 return programmeFacturationBusinessDao.findById(id);    }
    
}
