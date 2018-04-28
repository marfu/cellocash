/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.conveter;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.celloCashAdmin.beans.AgenceBancaireBean;
import com.cellocash.model.Type_Agence_Bancaire;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marfu
 */

@FacesConverter(value = "typeAgenceBancaireConverter")
public class TypeAgenceBancaireConveter implements Converter{
    
    
    
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String arg2) {
       try {
           
            System.err.println("argument============="+arg2);
			
			if (arg2 != null && !arg2.trim().equals("")) {
				return new FactoryBean().getTypeAgenceBancaireService().getTypeAgenceBancaire(Long.parseLong(arg2));
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

			Type_Agence_Bancaire typeAgenceBancaire = (Type_Agence_Bancaire) arg2;
			if (typeAgenceBancaire != null && typeAgenceBancaire.getId()!= null) {
				return "" + typeAgenceBancaire.getId();
			}
			return null;

		} else {
			return null;
		}
      //return ((Type_Agence_Bancaire)arg2).getId().toString();
    }
    
}
