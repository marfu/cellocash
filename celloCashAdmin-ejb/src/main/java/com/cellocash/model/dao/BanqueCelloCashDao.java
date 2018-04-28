/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.dao;

import com.cellocash.model.Banque_Cellocash;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface BanqueCelloCashDao extends GenericDao<Banque_Cellocash>{
    
    public Banque_Cellocash createOrUpdate(Banque_Cellocash b);

    public Banque_Cellocash getDetail(long b);
    
    public List<Banque_Cellocash> executeLazyQuery(String query, int first, int pageSize);
    public List<Banque_Cellocash> banqueByPays(long id);

    public Long getRowCount(String query);
    public List<Banque_Cellocash> findAllByPays(long id);
}
