/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.CommissionBusiness;

import com.cellocash.model.dao.CommissionBusinessDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author marfu
 */

@Stateless

public class CommissionBusinessDaoImpl extends GenericDaoImpl<CommissionBusiness> implements CommissionBusinessDao {

    @EJB
    private CommissionBusinessDao commissionBusinessDao;

    @Override
    public CommissionBusiness createOrUpdate(CommissionBusiness b) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return commissionBusinessDao.createOrUpdate(b);
    }

    @Override
    public CommissionBusiness getDetail(long b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             return commissionBusinessDao.findById(b);
    }

    @Override
    public List<CommissionBusiness> executeLazyQuery(String query, int first, int pageSize) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return commissionBusinessDao.executeLazyQuery(query, first, pageSize);
       
    }

    @Override
    public Long getRowCount(String query) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return commissionBusinessDao.getRowCount(query);
    }

    @Override
    public CommissionBusiness getDetailByCode(String b) {
CommissionBusiness result = null;
        try {
            
            Query q = em.createQuery("SELECT m FROM Commissions_Business m  Where m.code= ?2");
            
            q.setParameter(2, b);
            result =  (CommissionBusiness) q.getSingleResult();
            
            System.err.println("result"+result.toString());
        } catch (NoResultException e) {
            // log.debug("No result forund for... ");
        }

        return result;      }

}
