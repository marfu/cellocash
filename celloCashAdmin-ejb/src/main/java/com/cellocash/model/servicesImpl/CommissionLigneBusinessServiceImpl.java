/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Commission_Ligne_Business;
import com.cellocash.model.dao.CommissionLigneBusinessDao;
import com.cellocash.model.dto.CommissionBusinessDTO;
import com.cellocash.model.services.ICommissionLigneBusinessService;
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
@Local(ICommissionLigneBusinessService.class)

public class CommissionLigneBusinessServiceImpl implements ICommissionLigneBusinessService, Serializable{

     @EJB
    private CommissionLigneBusinessDao commissionLigneBusinessDao;
    
    
    @Override
    public Commission_Ligne_Business createOrUpdate(Commission_Ligne_Business u) {
          return commissionLigneBusinessDao.createOrUpdate(u);
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commission_Ligne_Business getDetail(long id) {
         return commissionLigneBusinessDao.getDetail(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommissionBusinessDTO> executeLazyQuery(String query, int first, int pageSize) {
         return commissionLigneBusinessDao.executeLazyQuery(query, first, pageSize);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commission_Ligne_Business> getAll() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
        return commissionLigneBusinessDao.getRowCount(query);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
