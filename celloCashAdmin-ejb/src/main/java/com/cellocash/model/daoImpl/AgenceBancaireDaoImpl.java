/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.dao.AgenceBancaireDao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;


/**
 *
 * @author marfu
 */
@Stateless
public class AgenceBancaireDaoImpl extends GenericDaoImpl<Agence_Bancaire> implements AgenceBancaireDao  {

    @Override
    public Agence_Bancaire createOrUpdate(Agence_Bancaire ab) {
              System.out.println("id============================================"+ab.getId());
  
          Agence_Bancaire temp;
        if (ab.getId()!=null){
           temp=getDetail(ab.getId());
        }else{
            temp=null;
        }
    
        if (temp != null) {
            em.merge(ab);
            em.flush();
            return ab;
        } else {
            em.persist(ab);
            return ab;
        }
    }

    @Override
    public Agence_Bancaire getDetail(long b) {
         try {
            Agence_Bancaire u = em.find(Agence_Bancaire.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Agence_Bancaire> executeLazyQuery(String query, int first, int pageSize) {
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
    public List<Agence_Bancaire> findAllByBanque(long idBanque) {
         List<Agence_Bancaire> result = null;
        

        try {

            Query q = em.createQuery("SELECT b FROM Agence_Bancaire b WHERE b.banqueCellocash.id =:banque ORDER BY b.designation DESC");
            q.setParameter("banque", idBanque);
//            q.setParameter("operation", codeOperation);
            result = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

}
