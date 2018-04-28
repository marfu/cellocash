/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.OperationCelloCash;

import java.util.List;

/**
 *
 * @author marfu
 */
public interface OperationCelloCashDao extends GenericDao<OperationCelloCash>{
    public OperationCelloCash createOrUpdate(OperationCelloCash p);

  
    
    public List<OperationCelloCash> executeLazyQuery(String query, int first, int pageSize);
    
  

    public Long getRowCount(String query);
}
