/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;


import com.cellocash.model.Commissions_Client;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface CommissionClientDao extends GenericDao<Commissions_Client>{
    
    public Commissions_Client createOrUpdate(Commissions_Client p);

    public Commissions_Client getDetail(long b);
    
    public List<Commissions_Client> executeLazyQuery(String query, int first, int pageSize);
    public List<Commissions_Client> findAllBanqueCelloAndAgenceBancaire(long idBanque,long IdAgenceBancaire);
   
  

    public Long getRowCount(String query);
}
