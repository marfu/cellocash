/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Pays;
import com.cellocash.model.Type_Agence_Bancaire;

/**
 *
 * @author marfu
 */
public interface TypeAgenceBancaireDao extends GenericDao<Type_Agence_Bancaire>{
    
     public Type_Agence_Bancaire createOrUpdate(Type_Agence_Bancaire b);

    public Type_Agence_Bancaire getDetail(long b);
    
 
    
    
}
