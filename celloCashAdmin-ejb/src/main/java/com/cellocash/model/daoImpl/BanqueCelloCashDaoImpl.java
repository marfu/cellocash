/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.dao.BanqueCelloCashDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author marfu
 */
@Stateless

public class BanqueCelloCashDaoImpl  extends GenericDaoImpl<Banque_Cellocash> implements BanqueCelloCashDao  {
    
    public BanqueCelloCashDaoImpl() {
    }

    public BanqueCelloCashDaoImpl(Class<Banque_Cellocash> entityClass) {
        super(entityClass);
    }

    
     @Override
    public Banque_Cellocash createOrUpdate(Banque_Cellocash b) {
           Banque_Cellocash temp;
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
    public Banque_Cellocash getDetail(long b) {
         try {
            Banque_Cellocash u = em.find(Banque_Cellocash.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    
    }

    
    
    @Override
    public List<Banque_Cellocash> executeLazyQuery(String query, int first, int pageSize) {
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

    @Override
    public List<Banque_Cellocash> banqueByPays(long id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       List<Banque_Cellocash> result = null;
        try {
            
            Query q = em.createQuery("SELECT b FROM Banque_Cellocash b  Where b.pays.id= ?2");
            
            q.setParameter(2, id);
            result =  q.getResultList();
        } catch (NoResultException e) {
            // log.debug("No result forund for... ");
        }

        return result;  
    }
    
    
    
    @Override
    public List<Banque_Cellocash> findAllByPays(long id) {
        List<Banque_Cellocash> result = null;
        

        try {

            Query q = em.createQuery("SELECT b FROM Banque_Cellocash b WHERE b.pays.id =:pays ORDER BY b.nom DESC");
            q.setParameter("pays", id);
//            q.setParameter("operation", codeOperation);
            result = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    
}
