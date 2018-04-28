/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Commission_Taxe;
import java.util.List;

/**
 *
 * @author manukey
 */
public interface ICommissionTaxeService {
    public Commission_Taxe createOrUpdate(Commission_Taxe u);
    public Commission_Taxe getDetail(long id);
    public List<Commission_Taxe> executeLazyQuery(String query, int first, int pageSize);
//    public List<Commission_Taxe> findAllBanqueCelloAndAgenceBancaire(long idBanque,long idAgence);
    public List<Commission_Taxe> findAllBanqueCello(long idBanque);
    public Long getRowCount(String query);
}