/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.dao.AgenceBancaireDao;
import com.cellocash.model.services.IAgenceBancaireService;
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
@Local(IAgenceBancaireService.class)
public class AgenceBancaireServiceImpl implements IAgenceBancaireService, Serializable{

     @EJB
    private AgenceBancaireDao agenceBancaireDao;
    
    
    @Override
    public Agence_Bancaire createOrUpdate(Agence_Bancaire u) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          return agenceBancaireDao.createOrUpdate(u);
    }

    @Override
    public Agence_Bancaire getDetail(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          return agenceBancaireDao.getDetail(id);
    }

    @Override
    public List<Agence_Bancaire> executeLazyQuery(String query, int first, int pageSize) {
        return agenceBancaireDao.executeLazyQuery(query, first, pageSize);
    }

    @Override
    public Long getRowCount(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return agenceBancaireDao.getRowCount(query);
    }
    @Override
    public List<Agence_Bancaire> findAllByBanque(long idBanqe) {
        return agenceBancaireDao.findAllByBanque(idBanqe);
    }
    
}
