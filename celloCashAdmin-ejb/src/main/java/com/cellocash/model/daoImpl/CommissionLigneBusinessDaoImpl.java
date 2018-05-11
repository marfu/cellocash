/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Commission_Ligne_Business;
import com.cellocash.model.dao.CommissionLigneBusinessDao;
import com.cellocash.model.dto.CommissionBusinessDTO;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author marfu
 */
@Stateless
public class CommissionLigneBusinessDaoImpl extends GenericDaoImpl<Commission_Ligne_Business> implements CommissionLigneBusinessDao {

    @Override
    public Commission_Ligne_Business createOrUpdate(Commission_Ligne_Business b) {
        Commission_Ligne_Business temp;
        if (b.getId() != null) {
            temp = getDetail(b.getId());
        } else {
            temp = null;
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
    public Commission_Ligne_Business getDetail(long b) {
        try {
            Commission_Ligne_Business u = em.find(Commission_Ligne_Business.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CommissionBusinessDTO> executeLazyQuery(String query, int first, int pageSize) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Query q = em.createQuery(query);
        q.setFirstResult(first);
        q.setMaxResults(pageSize);
        List<CommissionBusinessDTO> listDto = new ArrayList<>();

        List<Object[]> resultObject = q.getResultList();
       System.out.println("------------------size+++++++++++++++++++++++++++++"+resultObject.size());
        for (int i = 0; i < resultObject.size(); i++) {
 
            CommissionBusinessDTO dto = new CommissionBusinessDTO();
            dto.setId((Long) resultObject.get(i)[0]);
            dto.setPays((String) resultObject.get(i)[1]);
            dto.setAgenceBancaire((String) resultObject.get(i)[2]);
            dto.setBanque((String) resultObject.get(i)[3]);
            dto.setOperationBusiness((String) resultObject.get(i)[4]);
            dto.setProgrammeBusiness((String) resultObject.get(i)[5]);
            dto.setDateEffet((Date) resultObject.get(i)[6]);
            //tauxParticipation.add(taux);
            listDto.add(i, dto);
            // tauxParticipation= Arrays.asList(1.38, 2.56, 4.3);
        }
        return listDto;
    }

    @Override
    public Long getRowCount(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Query q = em.createQuery(query);
        return (Long) q.getSingleResult();
    }

}
