/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.ImpotTaxe;
import com.cellocash.model.Pays;
import com.cellocash.model.dao.ImpotTaxeDao;
import com.cellocash.model.dao.PaysDao;
import com.cellocash.model.services.IImpotTaxeService;
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
@Local(IImpotTaxeService.class)
public class ImpotTaxeServiceImpl implements IImpotTaxeService, Serializable{

    @EJB
    private ImpotTaxeDao impotTaxeDao;
    
    @Override
    public List<ImpotTaxe> getAllImpotTaxe() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return impotTaxeDao.findAll();
    }


     @Override
    public ImpotTaxe getImpotTaxe(long id) {
         return impotTaxeDao.getDetail(id);
    }

    @Override
    public List<ImpotTaxe> getAllImpotTaxeByTypeImpot(long id) {
        return impotTaxeDao.findAllbyTypeImpot(id);
    }
    
}