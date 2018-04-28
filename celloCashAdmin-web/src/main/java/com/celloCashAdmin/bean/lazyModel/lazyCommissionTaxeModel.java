/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Commission_Taxe;
import com.cellocash.model.services.ICommissionTaxeService;
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
public class lazyCommissionTaxeModel extends LazyDataModel<Commission_Taxe>{
     @EJB
    private ICommissionTaxeService commissionTaxeService;

    private List<Commission_Taxe> datasource;
    private long id;

    public lazyCommissionTaxeModel() {
          
    }

    @Override
    public Commission_Taxe getRowData(String rowKey) {
        for (Commission_Taxe cc : datasource) {
            if (cc.getId().equals(rowKey)) {
                return cc;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Commission_Taxe cc) {
        return cc.getId();
    }

    @Override
    public List<Commission_Taxe> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<Commission_Taxe> data = new ArrayList<>();

        String request = "";
        String q = "";
        request = "SELECT cc FROM Commission_Taxe cc  ";
        q = "SELECT COUNT(cc)  FROM Commission_Taxe cc  ";

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
        data = new FactoryBean().getCommissionTaxeService().executeLazyQuery(request, first, pageSize);
        setWrappedData(data);
        setRowCount(new FactoryBean().getCommissionTaxeService().getRowCount(q).intValue());
        
        System.out.println("fdfd "+data.toString());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

    }
    
}
