/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.HistoriqueConnection;
import com.cellocash.model.dao.HistoriqueConnectionDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author marfu
 */
@Stateless
public class HistoriqueConnectionDaoImpl extends GenericDaoImpl<HistoriqueConnection> implements HistoriqueConnectionDao{

    @Override
    public HistoriqueConnection createOrUpdate(HistoriqueConnection b) {
          HistoriqueConnection temp;
        if (b.getId()!=null){
           temp=getDetail(b.getId());
        }else{
            temp=null;
        }
    
        if (temp != null) {
            em.merge(b);
            em.flush();
            return b;
        } else {
            em.persist(b);
            return b;
        }
    }

    @Override
    public HistoriqueConnection getDetail(long b) {
         try {
            HistoriqueConnection u = em.find(HistoriqueConnection.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    
    }

    @Override
    public List<HistoriqueConnection> executeLazyQuery(String query, int first, int pageSize) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
        Query q = em.createQuery(query);
        q.setFirstResult(first);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

   

    @Override
    public Long getRowCount(String query) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Query q = em.createQuery(query);
        return (Long) q.getSingleResult();
    }
    
}
