/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Agence_Bancaire;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface AgenceBancaireDao extends GenericDao<Agence_Bancaire>{
      public Agence_Bancaire createOrUpdate(Agence_Bancaire ab);

    public Agence_Bancaire getDetail(long b);
    
    public List<Agence_Bancaire> executeLazyQuery(String query, int first, int pageSize);

    public Long getRowCount(String query);
     public List<Agence_Bancaire> findAllByBanque(long idBanque);
}
