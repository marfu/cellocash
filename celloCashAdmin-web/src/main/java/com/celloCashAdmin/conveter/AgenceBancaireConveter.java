/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.conveter;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Agence_Bancaire;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author manukey
 */
@FacesConverter(value = "AgenceBancaireConverter")
public class AgenceBancaireConveter implements Converter{

    @Override
    public Object getAsObject(FacesContext arg0,  UIComponent arg1, String arg2) {
        
        try {

            if (arg2 != null && !arg2.trim().equals("")) {
                
                //return new FactoryBean().getBanqueCelloCashService.getPays(Long.parseLong(arg2));
                return new FactoryBean().getAgenceBancaireService().getDetail(Long.parseLong(arg2));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
         if (arg2 != null && arg2 !="") {

             Agence_Bancaire item = (Agence_Bancaire) arg2;
            if (item != null && item.getId() != null) {
                return "" + item.getId();
            }
            return null;

        } else {
            return null;
        }
    }
    
}