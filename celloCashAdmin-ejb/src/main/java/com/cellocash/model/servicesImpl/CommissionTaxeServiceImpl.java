/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Commission_Taxe;
import com.cellocash.model.dao.CommissionTaxeDao;
import com.cellocash.model.services.ICommissionTaxeService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author manukey
 */
@SuppressWarnings("serial")
@Stateless
@Local(ICommissionTaxeService.class)
public class CommissionTaxeServiceImpl implements ICommissionTaxeService{

    @EJB
    private CommissionTaxeDao commissionTaxeDao;
    
    
    
    @Override
    public Commission_Taxe createOrUpdate(Commission_Taxe u) {
        return commissionTaxeDao.createOrUpdate(u);
    }

    @Override
    public Commission_Taxe getDetail(long id ) {
         return commissionTaxeDao.getDetail(id);
    }

    @Override
    public List<Commission_Taxe> executeLazyQuery(String query, int first, int pageSize) {
        return commissionTaxeDao.executeLazyQuery(query, first, pageSize);
    }

    @Override
    public Long getRowCount(String query) {
        return commissionTaxeDao.getRowCount(query);
    }

    @Override
    public List<Commission_Taxe> findAllBanqueCello(long idBanque) {
        return commissionTaxeDao.findAllBanqueCello(idBanque);
    }
    
}