/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Banque_Cellocash;
import com.cellocash.model.services.IBanqueCelloCashService;

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
public class LazyBanqueCelloCashModel extends LazyDataModel<Banque_Cellocash> {
    
    
    @EJB
    private IBanqueCelloCashService banqueCelloCashService;

    private List<Banque_Cellocash> datasource;
    private long id;

    public LazyBanqueCelloCashModel() {
        
    }

    @Override
    public Banque_Cellocash getRowData(String rowKey) {
        for (Banque_Cellocash car : datasource) {
            if (car.getId().equals(rowKey)) {
                return car;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Banque_Cellocash banqueCelloCash) {
        return banqueCelloCash.getId();
    }

    @Override
    public List<Banque_Cellocash> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<Banque_Cellocash> data = new ArrayList<>();

        String request = "";
        String q = "";
        request = "SELECT b FROM Banque_Cellocash b where 1=1 ";
        q = "SELECT COUNT(b)  FROM Banque_Cellocash b where 1=1";

        //FILTERS 
        for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

            String filterProperty = it.next();
            String filterValue = (String) filters.get(filterProperty);

            request = request + " AND b." + filterProperty + " LIKE '" + filterValue + "%'";
            q = q + " AND b." + filterProperty + " LIKE '" + filterValue + "%'";
        }

//        // SORT 
//        
        if (sortField != null) {
            request = request + " ORDER BY b." + sortField;
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
        data = new FactoryBean().getBanqueCelloCashService().executeLazyQuery(request, first, pageSize);
        setWrappedData(data);
        setRowCount(new FactoryBean().getBanqueCelloCashService().getRowCount(q).intValue());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

    }
    
}
