/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Commission_Ligne_Business;
import com.cellocash.model.dto.CommissionBusinessDTO;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.ICommissionLigneBusinessService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author marfu
 */


public class LazyCommissionLigneBusinessModel extends LazyDataModel<CommissionBusinessDTO>{
    
     @EJB
    private ICommissionLigneBusinessService commissionLigneBusinessService;

    private List<CommissionBusinessDTO> datasource;
    private long id;

    public LazyCommissionLigneBusinessModel(long id) {
          this.id = id;
    }
    public LazyCommissionLigneBusinessModel() {
         
    }

    @Override
    public CommissionBusinessDTO getRowData(String rowKey) {
        for (CommissionBusinessDTO item : datasource) {
            if (item.getId().equals(rowKey)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(CommissionBusinessDTO item) {
        return item.getId();
    }

    @Override
    public List<CommissionBusinessDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

       
        List<CommissionBusinessDTO> data = new ArrayList<>();

        String request = "";
        String q = "";
       
        
         request = "SELECT ab.id as id,p.designation as pays ,"
                 + "a.designation as agenceBancaire,"
                 + "b.nom as banque ,"
                 + "ab.operationCellocah.libelle as operationBusiness ,"
                 + "ab.programmeFacturationBusinesse.designation as programmeBusiness ,"
                 + "ab.dateEffet as dateEffet "
                 + "FROM Commission_Ligne_Business ab  "
                 + ",Banque_Cellocash b "
                 + ",Agence_Bancaire a "
                 + ",Pays p "
                 + "where (ab.banque_Cellocash_fk=b.id OR ab.banque_Cellocash_fk IS NULL) and (ab.pays_fk=p.id OR ab.pays_fk IS NULL) and (ab.agenceBancaire_fk=a.id OR ab.agenceBancaire_fk IS NULL)";
         
         q = "SELECT COUNT(ab)  FROM Commission_Ligne_Business ab   where 1=1";

        //FILTERS 
        for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

            String filterProperty = it.next();
            String filterValue = (String) filters.get(filterProperty);

            request = request + " AND " + filterProperty + " LIKE '" + filterValue + "%'";
            q = q + " AND " + filterProperty + " LIKE '" + filterValue + "%'";
        }
 
//        
        if (sortField != null) {
            request = request + " ORDER BY ab." + sortField;
            if (sortOrder.ordinal() == 0) {
                request = request + " ASC ";
            }
            if (sortOrder.ordinal() == 1) {
                request = request + " DESC ";
            }
        }
//        
//        
//        
        data = new FactoryBean().getCommissionLigneBusinessService().executeLazyQuery(request, first, pageSize);
        setWrappedData(data);
        setRowCount(new FactoryBean().getCommissionLigneBusinessService().getRowCount(q).intValue());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

        
        
       
        
        
        
        
        
        
        
        
        
        
    }
    
}
