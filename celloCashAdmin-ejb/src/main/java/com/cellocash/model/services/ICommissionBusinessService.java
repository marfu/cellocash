/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.CommissionBusiness;

import java.util.List;

/**
 *
 * @author marfu
 */
public interface ICommissionBusinessService {
      public CommissionBusiness createOrUpdate(CommissionBusiness u);
    public CommissionBusiness findById(long id);
    public CommissionBusiness getDetailByCode(String id);
    public List<CommissionBusiness> executeLazyQuery(String query, int first, int pageSize);
    public List<CommissionBusiness> getAll();
    public Long getRowCount(String query);
}
