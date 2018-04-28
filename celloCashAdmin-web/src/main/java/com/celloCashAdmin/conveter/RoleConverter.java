package com.celloCashAdmin.conveter;

import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.security.service.entity.Role;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



@FacesConverter(value = "roleConverter")
public class RoleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		try {
			
			if (arg2 != null && !arg2.trim().equals("")) {
				return new FactoryBean().getSecurityService().getRoleById(arg2);
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
		if (arg2 != null) {

			Role role = (Role) arg2;
			if (role != null && role.getDesignation() != null) {
				return "" + role.getDesignation();
			}
			return null;

		} else {
			return null;
		}
	}

}
