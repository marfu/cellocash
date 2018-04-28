/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.Pays;
import com.cellocash.model.dao.BanqueCelloCashDao;
import com.cellocash.model.dao.PaysDao;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */
@Stateless
public class PaysDaoImpl  extends GenericDaoImpl<Pays> implements PaysDao {

    @Override
    public Pays createOrUpdate(Pays p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pays getDetail(long b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pays> executeLazyQuery(String query, int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
