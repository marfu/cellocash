/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Ligne_Commission_Client;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface LigneCommissionClientDao extends GenericDao<Ligne_Commission_Client> {

    public Ligne_Commission_Client createOrUpdate(Ligne_Commission_Client ab);

    public Ligne_Commission_Client getDetail(long b);

    public List<Ligne_Commission_Client> executeLazyQuery(String query, int first, int pageSize);

    public Long getRowCount(String query);
    
    public List<Ligne_Commission_Client> findAllbyCommissionClientAndOperation(long idCommission,long idOperation);
    

}
