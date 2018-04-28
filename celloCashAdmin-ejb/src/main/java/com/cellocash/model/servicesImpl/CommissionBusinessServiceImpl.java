/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.CommissionBusiness;

import com.cellocash.model.dao.CommissionBusinessDao;
import com.cellocash.model.services.ICommissionBusinessService;
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
@Local(ICommissionBusinessService.class)
public class CommissionBusinessServiceImpl implements ICommissionBusinessService, Serializable {

    @EJB
    private CommissionBusinessDao commissionBusinessDao;

    @Override
    public CommissionBusiness createOrUpdate(CommissionBusiness u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CommissionBusiness findById(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("return xxxxxxxxxxxxxxxxxxxxxxxxxxxx"+commissionBusinessDao.findById(id).toString());
        return commissionBusinessDao.findById(id);
    }

    @Override
    public List<CommissionBusiness> executeLazyQuery(String query, int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommissionBusiness> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return commissionBusinessDao.findAll();
    }

    @Override
    public Long getRowCount(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CommissionBusiness getDetailByCode(String id) {
        return commissionBusinessDao.getDetailByCode(id);
    }

}
