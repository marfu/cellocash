/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Grossiste;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface GrossisteDao extends GenericDao<Grossiste>{
     public Grossiste createOrUpdate(Grossiste b);

    public Grossiste getDetail(long b);
    
    public List<Grossiste> executeLazyQuery(String query, int first, int pageSize);

    public Long getRowCount(String query);
}
