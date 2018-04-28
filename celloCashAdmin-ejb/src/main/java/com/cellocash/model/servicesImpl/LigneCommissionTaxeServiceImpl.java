/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Ligne_Commission_Client;
import com.cellocash.model.Ligne_Commission_Taxe;
import com.cellocash.model.dao.LigneCommissionClientDao;
import com.cellocash.model.dao.LigneCommissionTaxeDao;
import com.cellocash.model.services.ILigneCommissionClientService;
import com.cellocash.model.services.ILigneCommissionTaxeService;
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
@Local(ILigneCommissionTaxeService.class)
public class LigneCommissionTaxeServiceImpl implements ILigneCommissionTaxeService {

    @EJB
    private LigneCommissionTaxeDao ligneCommissionTaxeDao;

    @Override
    public Ligne_Commission_Taxe createOrUpdate(Ligne_Commission_Taxe u) {
        return ligneCommissionTaxeDao.createOrUpdate(u);
    }

    @Override
    public List<Ligne_Commission_Taxe> executeLazyQuery(String query, int first, int pageSize) {
        return ligneCommissionTaxeDao.executeLazyQuery(query, first, pageSize);
    }

    @Override
    public Long getRowCount(String query) {
        return ligneCommissionTaxeDao.getRowCount(query);
    }

    @Override
    public Ligne_Commission_Taxe findbyId(long id) {
        return ligneCommissionTaxeDao.findById(id);
    }

    @Override
    public List<Ligne_Commission_Taxe> findAllbyCommissionTaxeAndOperation(long idCommission, long idOperation) {
        return ligneCommissionTaxeDao.findAllbyCommissionTaxeAndOperation(idCommission, idOperation);
    }

    @Override
    public Ligne_Commission_Taxe getDetail(long id) {
        return ligneCommissionTaxeDao.getDetail(id);
    }

}
