/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.TypeImpotTaxe;
import com.cellocash.model.dao.TypeImpotTaxeDao;
import com.cellocash.model.services.ITypeImpotTaxeService;
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
@Local(ITypeImpotTaxeService.class)
public class TypeImpotTaxeServiceImpl implements ITypeImpotTaxeService, Serializable{

    @EJB
    private TypeImpotTaxeDao typeImpotTaxeDao;
    
    @Override
    public List<TypeImpotTaxe> getAllType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return typeImpotTaxeDao.findAll();
    }


     @Override
    public TypeImpotTaxe getDetail(long id) {
         return typeImpotTaxeDao.getDetail(id);
    }
    
}
