/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Agence_Bancaire;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface IAgenceBancaireService {
     public Agence_Bancaire createOrUpdate(Agence_Bancaire u);
    public Agence_Bancaire getDetail(long id);
    public List<Agence_Bancaire> executeLazyQuery(String query, int first, int pageSize);
    public Long getRowCount(String query);
     public List<Agence_Bancaire> findAllByBanque(long idBanqe);
}
