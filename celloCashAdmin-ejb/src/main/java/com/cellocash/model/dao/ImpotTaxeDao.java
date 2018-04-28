/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.ImpotTaxe;
import com.cellocash.model.Pays;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface ImpotTaxeDao extends GenericDao<ImpotTaxe>{
    public ImpotTaxe createOrUpdate(ImpotTaxe p);

    public ImpotTaxe getDetail(long b);
    
    public List<ImpotTaxe> executeLazyQuery(String query, int first, int pageSize);
    public List<ImpotTaxe> findAllbyTypeImpot(long id);
    
  

    public Long getRowCount(String query);
}