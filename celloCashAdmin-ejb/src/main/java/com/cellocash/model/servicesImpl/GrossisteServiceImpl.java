/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Grossiste;
import com.cellocash.model.services.IGrossisteService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */
@SuppressWarnings("serial")
@Stateless
@Local(IGrossisteService.class)
public class GrossisteServiceImpl implements IGrossisteService, Serializable{

    @Override
    public Grossiste createOrUpdate(Grossiste u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grossiste getDetail(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grossiste> executeLazyQuery(String query, int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grossiste> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
