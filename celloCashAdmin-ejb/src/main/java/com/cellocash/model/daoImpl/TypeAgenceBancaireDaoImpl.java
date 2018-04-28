/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.daoImpl;

import com.cellocash.model.Type_Agence_Bancaire;
import com.cellocash.model.dao.TypeAgenceBancaireDao;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */
@Stateless
public class TypeAgenceBancaireDaoImpl  extends GenericDaoImpl<Type_Agence_Bancaire> implements TypeAgenceBancaireDao{

    @Override
    public Type_Agence_Bancaire createOrUpdate(Type_Agence_Bancaire b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type_Agence_Bancaire getDetail(long b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
