package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.HistoriqueConnection;
import com.cellocash.model.services.IHistoriqueConnectionService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import org.primefaces.model.SortOrder;
import org.primefaces.model.LazyDataModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marfu
 */
public class LazyHistoriqueConnexionModel extends LazyDataModel<HistoriqueConnection>  {
     @EJB
    private IHistoriqueConnectionService banqueCelloCashService;

    private List<HistoriqueConnection> datasource;
    private long id;

    public LazyHistoriqueConnexionModel () {
        
    }

    @Override
    public HistoriqueConnection getRowData(String rowKey) {
        for (HistoriqueConnection car : datasource) {
            if (car.getId().equals(rowKey)) {
                return car;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(HistoriqueConnection banqueCelloCash) {
        return banqueCelloCash.getId();
    }

    @Override
    public List<HistoriqueConnection> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<HistoriqueConnection> data = new ArrayList<>();

        String request = "";
        String q = "";
        request = "SELECT b FROM HistoriqueConnection b where 1=1 ";
        q = "SELECT COUNT(b)  FROM HistoriqueConnection b where 1=1";

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
        data = new FactoryBean().getHistoriqueConnectionService().executeLazyQuery(request, first, pageSize);
        setWrappedData(data);
        setRowCount(new FactoryBean().getBanqueCelloCashService().getRowCount(q).intValue());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

    }
    
}
