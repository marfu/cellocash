/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Commission_Taxe;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface CommissionTaxeDao extends GenericDao<Commission_Taxe>{
      public Commission_Taxe createOrUpdate(Commission_Taxe ab);

    public Commission_Taxe getDetail(long b);
    
    public List<Commission_Taxe> executeLazyQuery(String query, int first, int pageSize);
//     public List<Commission_Taxe> findAllBanqueCelloAndAgenceBancaire(long idBanque,long IdAgenceBancaire);
     public List<Commission_Taxe> findAllBanqueCello(long idBanque);
   

    public Long getRowCount(String query);
    
    
}