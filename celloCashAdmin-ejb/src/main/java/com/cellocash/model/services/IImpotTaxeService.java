/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.ImpotTaxe;
import com.cellocash.model.Pays;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface IImpotTaxeService {
    
      public List<ImpotTaxe> getAllImpotTaxe();
      public List<ImpotTaxe> getAllImpotTaxeByTypeImpot(long id);
      public ImpotTaxe getImpotTaxe(long id);
    
}