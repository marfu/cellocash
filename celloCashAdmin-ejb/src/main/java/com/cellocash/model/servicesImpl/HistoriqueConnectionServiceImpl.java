/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.HistoriqueConnection;
import com.cellocash.model.dao.HistoriqueConnectionDao;
import com.cellocash.model.services.IHistoriqueConnectionService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */

@SuppressWarnings("serial")
@Stateless
@Local(IHistoriqueConnectionService.class)
public class HistoriqueConnectionServiceImpl implements IHistoriqueConnectionService, Serializable{

      @EJB
    private HistoriqueConnectionDao historiqueConnectionDao;
    
    
    @Override
    public HistoriqueConnection createOrUpdate(HistoriqueConnection u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return historiqueConnectionDao.createOrUpdate(u);
        
    }

    @Override
    public HistoriqueConnection getDetail(long id) {
        return historiqueConnectionDao.getDetail(id);
    }

    @Override
    public List<HistoriqueConnection> executeLazyQuery(String query, int first, int pageSize) {
       return historiqueConnectionDao.executeLazyQuery(query, first, pageSize);
    }

    @Override
    public List<HistoriqueConnection> getAll() {
      return historiqueConnectionDao.findAll();
    }

    @Override
    public Long getRowCount(String query) {
        return historiqueConnectionDao.getRowCount(query);
    }
    
}
