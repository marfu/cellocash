/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.ProgrammeFacturationBusiness;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface ProgrammeFacturationBusinessDao extends GenericDao<ProgrammeFacturationBusiness>{
    public ProgrammeFacturationBusiness createOrUpdate(ProgrammeFacturationBusiness p);

    public ProgrammeFacturationBusiness getDetail(long b);
    
    public List<ProgrammeFacturationBusiness> executeLazyQuery(String query, int first, int pageSize);
    
  

    public Long getRowCount(String query);
}
