/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.bean.lazyModel;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Agence_Bancaire;
import com.cellocash.model.Ligne_Commission_Client;
import com.cellocash.model.Ligne_Commission_Taxe;
import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.ILigneCommissionClientService;
import com.cellocash.model.services.ILigneCommissionTaxeService;
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
public class lazyLigneCommissionTaxeModel extends LazyDataModel<Ligne_Commission_Taxe>{
    
      @EJB
    private ILigneCommissionTaxeService ligneCommissionClientService;

    private List<Ligne_Commission_Taxe> datasource;
    private long id;

    public lazyLigneCommissionTaxeModel() {
          
    }

    @Override
    public Ligne_Commission_Taxe getRowData(String rowKey) {
        for (Ligne_Commission_Taxe car : datasource) {
            if (car.getId().equals(rowKey)) {
                return car;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Ligne_Commission_Taxe ligneCommissionTaxe) {
        return ligneCommissionTaxe.getId();
    }

    @Override
    public List<Ligne_Commission_Taxe> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        System.out.println("xxxxxxxxxxxxxxxxxxx");
        List<Ligne_Commission_Taxe> data = new ArrayList<>();

        String request = "";
        String q = "";
        request = "SELECT lcc FROM Ligne_Commission_Taxe lcc  ";
        q = "SELECT COUNT(lcc)  FROM Ligne_Commission_Client lcc  ";

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
        data = new FactoryBean().getLigneCommissionTaxeService().executeLazyQuery(request, first, pageSize);
        setRowCount(new FactoryBean().getLigneCommissionTaxeService().getRowCount(q).intValue());
        System.out.println("xxxxxxxxxEnd lAzy model xxxxxxxxxx");
        return data;

    }
    
}
