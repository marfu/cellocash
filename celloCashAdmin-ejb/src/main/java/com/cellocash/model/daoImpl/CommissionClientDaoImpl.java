/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Commissions_Client;
import com.cellocash.model.dao.CommissionClientDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author manukey
 */
@Stateless
public class CommissionClientDaoImpl extends GenericDaoImpl<Commissions_Client> implements CommissionClientDao {

    @Override
    public Commissions_Client createOrUpdate(Commissions_Client cc) {
        Commissions_Client temp;
        if (cc.getId()!=null) {
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
    public Commissions_Client getDetail(long b) {
        try {
            Commissions_Client u = em.find(Commissions_Client.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Commissions_Client> executeLazyQuery(String query, int first, int pageSize) {
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
    public List<Commissions_Client> findAllBanqueCelloAndAgenceBancaire(long idBanque, long IdAgenceBancaire) {

        List<Commissions_Client> result = null;

        try {

            Query q = em.createQuery("SELECT l FROM Commissions_Client l WHERE l.banqueCellocash.id =:banque and l.agenceBancaire.id=:agence ORDER BY l.designationCommission DESC");
            q.setParameter("banque", idBanque);
            q.setParameter("agence", IdAgenceBancaire);
            result = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }


}
