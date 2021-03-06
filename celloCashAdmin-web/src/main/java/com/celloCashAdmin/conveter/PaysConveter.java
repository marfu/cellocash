/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.conveter;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Pays;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marfu
 */

@FacesConverter(value = "paysConverter")
public class PaysConveter implements Converter{

     @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String arg2) {
       try {
			
           
			if (arg2 != null && !arg2.trim().equals("")) {
				return new FactoryBean().getPaysService().getPays(Long.parseLong(arg2));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object arg2) {
      if (arg2 != null) {

			Pays pays = (Pays) arg2;
			if (pays != null && pays.getId()!= null) {
				return "" + pays.getId();
			}
			return null;

		} else {
			return null;
		}
      //return ((Type_Agence_Bancaire)arg2).getId().toString();
    }
    
}
