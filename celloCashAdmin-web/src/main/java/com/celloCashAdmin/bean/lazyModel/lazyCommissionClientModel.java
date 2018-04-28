/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Commissions_Client;
import com.cellocash.model.services.ICommissionClientService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author manukey
 */
public class lazyCommissionClientModel extends LazyDataModel<Commissions_Client>{
     @EJB
    private ICommissionClientService commissionClientService;

    private List<Commissions_Client> datasource;
    private long id;

    public lazyCommissionClientModel() {
          
    }

    @Override
    public Commissions_Client getRowData(String rowKey) {
        for (Commissions_Client cc : datasource) {
            if (cc.getId().equals(rowKey)) {
                return cc;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Commissions_Client cc) {
        return cc.getId();
    }

    @Override
    public List<Commissions_Client> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<Commissions_Client> data = new ArrayList<>();

        String request = "";
        String q = "";
        request = "SELECT cc FROM Commissions_Client cc  LEFT JOIN cc.banqueCellocash as b left join cc.agenceBancaire as ab";
        q = "SELECT COUNT(cc)  FROM Commissions_Client cc  LEFT JOIN cc.banqueCellocash as b left join cc.agenceBancaire as ab";

        //FILTERS 
        for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {

            String filterProperty = it.next();
            String filterValue = (String) filters.get(filterProperty);

            request = request + " AND i." + filterProperty + " LIKE '" + filterValue + "%'";
            q = q + " AND i." + filterProperty + " LIKE '" + filterValue + "%'";
        }

//        // SORT 
//        
        if (sortField != null) {
            request = request + " ORDER BY i." + sortField;
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
        data = new FactoryBean().getCommissionClientService().executeLazyQuery(request, first, pageSize);
        setWrappedData(data);
        setRowCount(new FactoryBean().getCommissionClientService().getRowCount(q).intValue());
        
        System.out.println("fdfd "+data.toString());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

    }
    
}
