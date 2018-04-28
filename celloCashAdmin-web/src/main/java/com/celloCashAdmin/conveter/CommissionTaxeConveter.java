/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celloCashAdmin.conveter;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.model.Commission_Taxe;
import com.cellocash.model.Pays;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marfu
 */

@FacesConverter(value = "commissionTaxeConverter")
public class CommissionTaxeConveter implements Converter{

     @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String arg2) {
       try {
			
           
			if (arg2 != null && !arg2.trim().equals("")) {
				return new FactoryBean().getCommissionTaxeService().getDetail(Long.parseLong(arg2));
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
      if (arg2 != null && arg2 !="") {

			Commission_Taxe ct = (Commission_Taxe) arg2;
			if (ct != null && ct.getId()!= null) {
				return "" + ct.getId();
			}
			return null;

		} else {
			return null;
		}
      //return ((Type_Agence_Bancaire)arg2).getId().toString();
    }
    
}
