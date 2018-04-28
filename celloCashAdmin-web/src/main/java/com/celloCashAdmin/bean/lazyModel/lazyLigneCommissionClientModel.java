/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Ligne_Commission_Client;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.ILigneCommissionClientService;
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
public class lazyLigneCommissionClientModel extends LazyDataModel<Ligne_Commission_Client>{
    
      @EJB
    private ILigneCommissionClientService ligneCommissionClientService;

    private List<Ligne_Commission_Client> datasource;
    private long id;

    public lazyLigneCommissionClientModel() {
          
    }

    @Override
    public Ligne_Commission_Client getRowData(String rowKey) {
        for (Ligne_Commission_Client car : datasource) {
            if (car.getId().equals(rowKey)) {
                return car;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Ligne_Commission_Client ligneCommissionClient) {
        return ligneCommissionClient.getId();
    }

    @Override
    public List<Ligne_Commission_Client> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<Ligne_Commission_Client> data = new ArrayList<>();

        String request = "";
        String q = "";
        request = "SELECT lcc FROM Ligne_Commission_Client lcc  ";
        q = "SELECT COUNT(lcc)  FROM Ligne_Commission_Client lcc  LEFT JOIN lcc.commissionClient as b LEFT JOIN lcc.operationCellocah";

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
        data = new FactoryBean().getLigneCommissionClientService().executeLazyQuery(request, first, pageSize);
        setRowCount(new FactoryBean().getLigneCommissionClientService().getRowCount(q).intValue());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

    }
    
}
