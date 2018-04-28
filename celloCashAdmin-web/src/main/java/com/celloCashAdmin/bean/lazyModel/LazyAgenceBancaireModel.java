/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.services.IAgenceBancaireService;
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
public class LazyAgenceBancaireModel extends LazyDataModel<Agence_Bancaire>{
    
     @EJB
    private IAgenceBancaireService banqueCelloCashService;

    private List<Agence_Bancaire> datasource;
    private long id;

    public LazyAgenceBancaireModel(long id) {
          this.id = id;
    }
    public LazyAgenceBancaireModel() {
         
    }

    @Override
    public Agence_Bancaire getRowData(String rowKey) {
        for (Agence_Bancaire car : datasource) {
            if (car.getId().equals(rowKey)) {
                return car;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Agence_Bancaire banqueCelloCash) {
        return banqueCelloCash.getId();
    }

    @Override
    public List<Agence_Bancaire> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<Agence_Bancaire> data = new ArrayList<>();

        String request = "";
        String q = "";
       // request = "SELECT ab FROM Agence_Bancaire ab  LEFT JOIN ab.banqueCellocash as b Where b.id= '" + id + "'";
       //// q = "SELECT COUNT(b)  FROM Agence_Bancaire ab LEFT JOIN ab.banqueCellocash as b Where b.id= '" + id + "'";
        
         request = "SELECT ab FROM Agence_Bancaire ab  LEFT JOIN ab.banqueCellocash as b where 1=1";
        q = "SELECT COUNT(b)  FROM Agence_Bancaire ab LEFT JOIN ab.banqueCellocash as b where 1=1";

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
        data = new FactoryBean().getAgenceBancaireService().executeLazyQuery(request, first, pageSize);
        setWrappedData(data);
        setRowCount(new FactoryBean().getAgenceBancaireService().getRowCount(q).intValue());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

    }
    
}
