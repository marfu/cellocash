/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Ligne_Commission_Client;
import com.cellocash.model.dao.LigneCommissionClientDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author manukey
 */
@Stateless
public class LigneCommissionClientDaoImpl extends GenericDaoImpl<Ligne_Commission_Client> implements LigneCommissionClientDao{

    @Override
    public Ligne_Commission_Client createOrUpdate(Ligne_Commission_Client cc) {
        Ligne_Commission_Client temp;
        if (cc.getId()!= null) {
            temp = getDetail(cc.getId());
        } else {
            temp = null;
        }

        if (temp != null) {
            em.merge(cc);
            em.flush();
            return cc;
        } else {
            em.persist(cc);
            return cc;
        }
    }

    @Override
    public Ligne_Commission_Client getDetail(long b) {
          try {
            Ligne_Commission_Client u = em.find(Ligne_Commission_Client.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Ligne_Commission_Client> executeLazyQuery(String query, int first, int pageSize) {
         Query q = em.createQuery(query);
        q.setFirstResult(first);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    @Override
    public Long getRowCount(String query) {
         Query q = em.createQuery(query);
        return (Long) q.getSingleResult();
    }

    @Override
    public List<Ligne_Commission_Client> findAllbyCommissionClientAndOperation(long idCommission, long idOperation) {
        List<Ligne_Commission_Client> result = null;
        

        try {

            Query q = em.createQuery("SELECT l FROM Ligne_Commission_Client l WHERE l.commissionClient.id =:commission and l.operationCellocah.id=:operation ORDER BY l.dateEffet DESC");
            q.setParameter("commission", idCommission);
            q.setParameter("operation", idOperation);
            result = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    
}
