/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Commission_Ligne_Business;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface CommissionLigneBusinessDao extends GenericDao<Commission_Ligne_Business>{
    
    
    public Commission_Ligne_Business createOrUpdate(Commission_Ligne_Business b);

    public Commission_Ligne_Business getDetail(long b);
    
    public List<Commission_Ligne_Business> executeLazyQuery(String query, int first, int pageSize);

    public Long getRowCount(String query);
}
