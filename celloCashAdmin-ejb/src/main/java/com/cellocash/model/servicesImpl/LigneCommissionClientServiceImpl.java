/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Ligne_Commission_Client;
import com.cellocash.model.dao.LigneCommissionClientDao;
import com.cellocash.model.services.ILigneCommissionClientService;
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
@Local(ILigneCommissionClientService.class)
public class LigneCommissionClientServiceImpl implements ILigneCommissionClientService {

    @EJB
    private LigneCommissionClientDao ligneCommissionClientDao;

    @Override
    public Ligne_Commission_Client createOrUpdate(Ligne_Commission_Client u) {
        return ligneCommissionClientDao.createOrUpdate(u);
    }

    @Override
    public List<Ligne_Commission_Client> executeLazyQuery(String query, int first, int pageSize) {
        return ligneCommissionClientDao.executeLazyQuery(query, first, pageSize);
    }

    @Override
    public Long getRowCount(String query) {
        return ligneCommissionClientDao.getRowCount(query);
    }

    @Override
    public Ligne_Commission_Client findbyId(long id) {
        return ligneCommissionClientDao.findById(id);
    }

    @Override
    public List<Ligne_Commission_Client> findAllbyCommissionClientAndOperation(long idCommission, long idOperation) {
        return ligneCommissionClientDao.findAllbyCommissionClientAndOperation(idCommission, idOperation);
    }

    @Override
    public Ligne_Commission_Client getDetail(long id) {
        return ligneCommissionClientDao.getDetail(id);
    }

}
