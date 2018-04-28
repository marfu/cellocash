/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Grossiste;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface IGrossisteService {
     
    public Grossiste createOrUpdate(Grossiste u);
    public Grossiste getDetail(long id);
    public List<Grossiste> executeLazyQuery(String query, int first, int pageSize);
    public List<Grossiste> getAll();
    public Long getRowCount(String query);
}
