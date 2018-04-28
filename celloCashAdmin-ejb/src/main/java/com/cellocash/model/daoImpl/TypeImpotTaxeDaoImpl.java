/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Pays;
import com.cellocash.model.TypeImpotTaxe;
import com.cellocash.model.dao.PaysDao;
import com.cellocash.model.dao.TypeImpotTaxeDao;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */
@Stateless
public class TypeImpotTaxeDaoImpl  extends GenericDaoImpl<TypeImpotTaxe> implements TypeImpotTaxeDao {

    @Override
    public TypeImpotTaxe createOrUpdate(TypeImpotTaxe p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypeImpotTaxe getDetail(long b) {
         try {
            TypeImpotTaxe u = em.find(TypeImpotTaxe.class, b);

            return u;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TypeImpotTaxe> executeLazyQuery(String query, int first, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getRowCount(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
