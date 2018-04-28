/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.ImpotTaxe;
import com.cellocash.model.Pays;
import com.cellocash.model.dao.BanqueCelloCashDao;
import com.cellocash.model.dao.ImpotTaxeDao;
import com.cellocash.model.dao.PaysDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author manukey
 */
@Stateless
public class ImpotTaxeImpl  extends GenericDaoImpl<ImpotTaxe> implements ImpotTaxeDao {

    @Override
    public ImpotTaxe createOrUpdate(ImpotTaxe p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImpotTaxe getDetail(long b) {
         try {
            ImpotTaxe u = em.find(ImpotTaxe.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ImpotTaxe> executeLazyQuery(String query, int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ImpotTaxe> findAllbyTypeImpot(long id) {
        
        List<ImpotTaxe> result = null;

        try {

            Query q = em.createQuery("SELECT l FROM ImpotTaxe l WHERE l.typeImpotTaxe.id =:id  ORDER BY l.designation DESC");
            q.setParameter("id", id);
//            q.setParameter("agence", IdAgenceBancaire);
            result = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    
}