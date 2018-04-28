/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Pays;
import com.cellocash.model.dao.PaysDao;
import com.cellocash.model.services.IPaysService;
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
@Local(IPaysService.class)
public class PaysServiceImpl implements IPaysService, Serializable{

    @EJB
    private PaysDao paysDao;
    
    @Override
    public List<Pays> getAllPays() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return paysDao.findAll();
    }

    @Override
    public Pays getPays(Long id) {
 return paysDao.findById(id);    }
    
}
