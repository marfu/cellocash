package com.celloCashAdmin.conveter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.celloCashAdmin.bean.util.FactoryBean;
import com.cellocash.security.service.entity.Authorization;


@FacesConverter(value = "permConverter")
public class PermConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		try {
			Long id = Long.parseLong(arg2);
			if (id != null && id > 0) {
				return new FactoryBean().getSecurityService().getPermissionsById(id);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {

			Authorization perm = (Authorization) arg2;
			if (perm.getPermissionId() > 0) {
				return "" + perm.getPermissionId();
			}
			return null;

		} else {
			return null;
		}
	}

}
