/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Commissions_Client;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface ICommissionClientService {
    public Commissions_Client createOrUpdate(Commissions_Client u);
    public Commissions_Client getDetail(long id);
    public List<Commissions_Client> executeLazyQuery(String query, int first, int pageSize);
    public List<Commissions_Client> findAllBanqueCelloAndAgenceBancaire(long idBanque,long idAgence);
    public Long getRowCount(String query);
}
