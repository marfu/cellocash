/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Pays;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface PaysDao extends GenericDao<Pays>{
    public Pays createOrUpdate(Pays p);

    public Pays getDetail(long b);
    
    public List<Pays> executeLazyQuery(String query, int first, int pageSize);
    
  

    public Long getRowCount(String query);
}
