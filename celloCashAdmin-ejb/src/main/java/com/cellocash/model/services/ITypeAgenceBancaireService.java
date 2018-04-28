/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Type_Agence_Bancaire;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface ITypeAgenceBancaireService {
     public List<Type_Agence_Bancaire> getAllTypeAgenceBancaire();
     public Type_Agence_Bancaire getTypeAgenceBancaire(Long id);
}
