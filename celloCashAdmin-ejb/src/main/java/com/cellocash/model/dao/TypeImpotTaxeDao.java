/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Pays;
import com.cellocash.model.TypeImpotTaxe;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface TypeImpotTaxeDao extends GenericDao<TypeImpotTaxe>{
    public TypeImpotTaxe createOrUpdate(TypeImpotTaxe p);

    public TypeImpotTaxe getDetail(long b);
    
    public List<TypeImpotTaxe> executeLazyQuery(String query, int first, int pageSize);
    
  

    public Long getRowCount(String query);
}
