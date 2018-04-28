/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Commission_Taxe;
import com.cellocash.model.Commissions_Client;
import com.cellocash.model.dao.CommissionClientDao;
import com.cellocash.model.dao.CommissionTaxeDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author manukey
 */
@Stateless
public class CommissionTaxeDaoImpl extends GenericDaoImpl<Commission_Taxe> implements CommissionTaxeDao {

    @Override
    public Commission_Taxe createOrUpdate(Commission_Taxe cc) {
        Commission_Taxe temp;
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
    public Commission_Taxe getDetail(long b) {
        try {
            Commission_Taxe u = em.find(Commission_Taxe.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Commission_Taxe> executeLazyQuery(String query, int first, int pageSize) {
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
    public List<Commission_Taxe> findAllBanqueCello(long idBanque) {
//    public List<Commission_Taxe> findAllBanqueCelloAndAgenceBancaire(long idBanque, long IdAgenceBancaire) {

        List<Commission_Taxe> result = null;

        try {

//            Query q = em.createQuery("SELECT l FROM Commission_Taxe l WHERE l.banqueCellocash.id =:banque and l.agenceBancaire.id=:agence ORDER BY l.designationCommission DESC");
            Query q = em.createQuery("SELECT l FROM Commission_Taxe l WHERE l.banqueCellocash.id =:banque  ORDER BY l.designationCommission DESC");
            q.setParameter("banque", idBanque);
//            q.setParameter("agence", IdAgenceBancaire);
            result = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }


}