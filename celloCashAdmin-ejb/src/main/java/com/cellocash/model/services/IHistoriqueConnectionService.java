/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.HistoriqueConnection;
import java.util.List;



/**
 *
 * @author marfu
 */

public interface IHistoriqueConnectionService {
    
    public HistoriqueConnection createOrUpdate(HistoriqueConnection u);
    public HistoriqueConnection getDetail(long id);
    public List<HistoriqueConnection> executeLazyQuery(String query, int first, int pageSize);
    public List<HistoriqueConnection> getAll();
    public Long getRowCount(String query);
   
}
