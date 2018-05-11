/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.HistoriqueConnection;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface HistoriqueConnectionDao extends GenericDao<HistoriqueConnection> {
    public HistoriqueConnection createOrUpdate(HistoriqueConnection b);

    public HistoriqueConnection getDetail(long b);
    
    public List<HistoriqueConnection> executeLazyQuery(String query, int first, int pageSize);
 

    public Long getRowCount(String query);
}
