/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Commission_Ligne_Business;
import com.cellocash.model.dto.CommissionBusinessDTO;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface ICommissionLigneBusinessService {

    public Commission_Ligne_Business createOrUpdate(Commission_Ligne_Business u);

    public Commission_Ligne_Business getDetail(long id);

    public List<CommissionBusinessDTO> executeLazyQuery(String query, int first, int pageSize);

    public List<Commission_Ligne_Business> getAll();

    public Long getRowCount(String query);
}
