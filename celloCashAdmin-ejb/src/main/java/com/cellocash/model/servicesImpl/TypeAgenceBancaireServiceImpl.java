/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Type_Agence_Bancaire;
import com.cellocash.model.dao.TypeAgenceBancaireDao;
import com.cellocash.model.services.ITypeAgenceBancaireService;
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
@Local(ITypeAgenceBancaireService.class)
public class TypeAgenceBancaireServiceImpl implements ITypeAgenceBancaireService, Serializable{

    @EJB
    private TypeAgenceBancaireDao typeAgenceBancaireDao;
    
    
    @Override
    public List<Type_Agence_Bancaire> getAllTypeAgenceBancaire() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return typeAgenceBancaireDao.findAll();
    }

    @Override
    public Type_Agence_Bancaire getTypeAgenceBancaire(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        return typeAgenceBancaireDao.findById(id);
    }

   
}
