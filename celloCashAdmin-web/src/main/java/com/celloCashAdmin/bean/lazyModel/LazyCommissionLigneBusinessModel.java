/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Commission_Ligne_Business;
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
public class LazyCommissionLigneBusinessModel extends LazyDataModel<Commission_Ligne_Business>{
    
     @EJB
    private ICommissionLigneBusinessService commissionLigneBusinessService;

    private List<Commission_Ligne_Business> datasource;
    private long id;

    public LazyCommissionLigneBusinessModel(long id) {
          this.id = id;
    }
    public LazyCommissionLigneBusinessModel() {
         
    }

    @Override
    public Commission_Ligne_Business getRowData(String rowKey) {
        for (Commission_Ligne_Business item : datasource) {
            if (item.getId().equals(rowKey)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Commission_Ligne_Business item) {
        return item.getId();
    }

    @Override
    public List<Commission_Ligne_Business> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<Commission_Ligne_Business> data = new ArrayList<>();

        String request = "";
        String q = "";
       // request = "SELECT ab FROM Agence_Bancaire ab  LEFT JOIN ab.banqueCellocash as b Where b.id= '" + id + "'";
       //// q = "SELECT COUNT(b)  FROM Agence_Bancaire ab LEFT JOIN ab.banqueCellocash as b Where b.id= '" + id + "'";
        
         request = "SELECT ab FROM Commission_Ligne_Business ab   where 1=1";
        q = "SELECT COUNT(ab)  FROM Commission_Ligne_Business ab   where 1=1";

        //FILTERS 
        for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

            String filterProperty = it.next();
            String filterValue = (String) filters.get(filterProperty);

            request = request + " AND ab." + filterProperty + " LIKE '" + filterValue + "%'";
            q = q + " AND ab." + filterProperty + " LIKE '" + filterValue + "%'";
        }

//        // SORT 
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
