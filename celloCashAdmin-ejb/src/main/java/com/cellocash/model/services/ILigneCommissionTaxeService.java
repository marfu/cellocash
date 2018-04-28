/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Ligne_Commission_Taxe;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface ILigneCommissionTaxeService {
     public Ligne_Commission_Taxe createOrUpdate(Ligne_Commission_Taxe u);
    public List<Ligne_Commission_Taxe> executeLazyQuery(String query, int first, int pageSize);
    public Long getRowCount(String query);
    public Ligne_Commission_Taxe findbyId(long id);
    public Ligne_Commission_Taxe getDetail(long id);
    public  List<Ligne_Commission_Taxe> findAllbyCommissionTaxeAndOperation (long idCommission, long idOperation);
}
