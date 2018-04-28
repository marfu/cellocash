/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;


import com.cellocash.model.CommissionBusiness;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface CommissionBusinessDao extends GenericDao<CommissionBusiness>{
    
    public CommissionBusiness createOrUpdate(CommissionBusiness b);

    public CommissionBusiness getDetail(long b);
    public CommissionBusiness getDetailByCode(String b);
    
    public List<CommissionBusiness> executeLazyQuery(String query, int first, int pageSize);
    

    public Long getRowCount(String query);
    
}
