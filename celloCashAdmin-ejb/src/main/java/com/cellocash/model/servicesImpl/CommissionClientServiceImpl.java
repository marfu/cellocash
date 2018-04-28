/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Commissions_Client;
import com.cellocash.model.dao.CommissionClientDao;
import com.cellocash.model.services.ICommissionClientService;
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
@Local(ICommissionClientService.class)
public class CommissionClientServiceImpl implements ICommissionClientService{

    @EJB
    private CommissionClientDao commissionClientDao;
    
    
    
    @Override
    public Commissions_Client createOrUpdate(Commissions_Client u) {
        return commissionClientDao.createOrUpdate(u);
    }

    @Override
    public Commissions_Client getDetail(long id ) {
         return commissionClientDao.getDetail(id);
    }

    @Override
    public List<Commissions_Client> executeLazyQuery(String query, int first, int pageSize) {
        return commissionClientDao.executeLazyQuery(query, first, pageSize);
    }

    @Override
    public Long getRowCount(String query) {
        return commissionClientDao.getRowCount(query);
    }

    @Override
    public List<Commissions_Client> findAllBanqueCelloAndAgenceBancaire(long idBanque, long idAgence) {
        return commissionClientDao.findAllBanqueCelloAndAgenceBancaire(idBanque, idAgence);
    }
    
}
