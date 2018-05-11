/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.PalierCommission;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface PalierCommissionDao  extends GenericDao<PalierCommission>{
    public PalierCommission createOrUpdate(PalierCommission p);

    public PalierCommission getDetail(long b);
    
    public List<PalierCommission> executeLazyQuery(String query, int first, int pageSize);
    
  

    public Long getRowCount(String query);
}
