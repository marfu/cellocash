/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Banque_Cellocash;
import java.util.List;



/**
 *
 * @author marfu
 */

public interface IBanqueCelloCashService {
    
    public Banque_Cellocash createOrUpdate(Banque_Cellocash u);
    public Banque_Cellocash getDetail(long id);
    public List<Banque_Cellocash> executeLazyQuery(String query, int first, int pageSize);
    public List<Banque_Cellocash> getAll();
    public Long getRowCount(String query);
    public List<Banque_Cellocash> findAllByPays(long idpays);
}
