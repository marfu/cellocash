/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Grossiste;
import com.cellocash.model.dao.GrossisteDao;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */
@Stateless

public class GrossisteDaoImpl extends GenericDaoImpl<Grossiste> implements GrossisteDao{
     @Override
    public Grossiste createOrUpdate(Grossiste p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public List<Grossiste> executeLazyQuery(String query, int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grossiste getDetail(long b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
