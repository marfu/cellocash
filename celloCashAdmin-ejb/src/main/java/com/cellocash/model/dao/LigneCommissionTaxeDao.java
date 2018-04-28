/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Commission_Taxe;
import com.cellocash.model.Ligne_Commission_Taxe;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface LigneCommissionTaxeDao extends GenericDao<Ligne_Commission_Taxe>{
      public Ligne_Commission_Taxe createOrUpdate(Ligne_Commission_Taxe ab);

    public Ligne_Commission_Taxe getDetail(long b);
    
    public List<Ligne_Commission_Taxe> executeLazyQuery(String query, int first, int pageSize);
    public List<Ligne_Commission_Taxe> findAllbyCommissionTaxeAndOperation(long idCommission,long idOperation);
   

    public Long getRowCount(String query);
    
    
}