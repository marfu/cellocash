/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.dao.BanqueCelloCashDao;
import com.cellocash.model.services.IBanqueCelloCashService;
import com.cellocash.security.service.ISecurityService;
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
@Local(IBanqueCelloCashService.class)
public class BanqueCelloCashServiceImpl implements IBanqueCelloCashService, Serializable{
    
    @EJB
    private BanqueCelloCashDao banqueCelloCashDao;
    
    
    @Override
    public List<Banque_Cellocash> executeLazyQuery(String query, int first, int pageSize) {
       return banqueCelloCashDao.executeLazyQuery(query, first, pageSize);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return banqueCelloCashDao.getRowCount(query);
    }

    @Override
    public Banque_Cellocash createOrUpdate(Banque_Cellocash b) {
          return banqueCelloCashDao.createOrUpdate(b);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banque_Cellocash getDetail(long id) {
        return banqueCelloCashDao.getDetail(id);
        
    }

    @Override
    public List<Banque_Cellocash> getAll() {
          return banqueCelloCashDao.findAll();
    }
     @Override
    public List<Banque_Cellocash> findAllByPays(long idpays) {
        return banqueCelloCashDao.findAllByPays(idpays);
    }
}
