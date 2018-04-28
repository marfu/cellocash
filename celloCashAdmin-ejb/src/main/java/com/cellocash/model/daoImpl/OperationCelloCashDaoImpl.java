/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.OperationCelloCash;

import com.cellocash.model.dao.OperationCelloCashDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author marfu
 */

@Stateless
public class OperationCelloCashDaoImpl extends GenericDaoImpl<OperationCelloCash> implements OperationCelloCashDao {

    @Override
    public OperationCelloCash createOrUpdate(OperationCelloCash p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public List<OperationCelloCash> executeLazyQuery(String query, int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
