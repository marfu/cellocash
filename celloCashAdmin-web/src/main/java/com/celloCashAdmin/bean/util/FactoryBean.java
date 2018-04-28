package com.celloCashAdmin.bean.util;


import com.cellocash.model.services.IAgenceBancaireService;
import com.cellocash.model.services.IBanqueCelloCashService;
import com.cellocash.model.services.ICommissionBusinessService;
import com.cellocash.model.services.ICommissionClientService;
import com.cellocash.model.services.ICommissionLigneBusinessService;
import com.cellocash.model.services.ICommissionTaxeService;
import com.cellocash.model.services.IGrossisteService;
import com.cellocash.model.services.IImpotTaxeService;
import com.cellocash.model.services.ILigneCommissionClientService;
import com.cellocash.model.services.ILigneCommissionTaxeService;
import com.cellocash.model.services.IOperationCelloCashService;
import com.cellocash.model.services.IPaysService;
import com.cellocash.model.services.ITypeAgenceBancaireService;
import com.cellocash.model.services.ITypeImpotTaxeService;
import com.cellocash.security.service.ISecurityService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class FactoryBean {

	private Context context;
//
//	private String earName;

	public FactoryBean() {

		try {
			context = new InitialContext();
			//earName = (String) context.lookup("java:module/");
		} catch (NamingException e) {
			e.printStackTrace();

		}

	}

	@SuppressWarnings("unchecked")
	protected <T> T getLocalService(Class<T> c, String name) throws NamingException {

		String uri = "java:module/"+name;

		return (T) context.lookup(uri);

	}

	public ISecurityService getSecurityService() {
		try {
			return getLocalService(ISecurityService.class, "SecurityServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
	public IBanqueCelloCashService getBanqueCelloCashService() {
		try {
			return getLocalService(IBanqueCelloCashService.class, "BanqueCelloCashServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        
        public IAgenceBancaireService getAgenceBancaireService() {
		try {
			return getLocalService(IAgenceBancaireService.class, "AgenceBancaireServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        public ITypeAgenceBancaireService getTypeAgenceBancaireService() {
		try {
			return getLocalService(ITypeAgenceBancaireService.class, "TypeAgenceBancaireServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        public IPaysService getPaysService() {
		try {
			return getLocalService(IPaysService.class, "PaysServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        public IOperationCelloCashService getOperationCelloCashService() {
		try {
			return getLocalService(IOperationCelloCashService.class, "OperationCelloCashServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        public ICommissionLigneBusinessService getCommissionLigneBusinessService() {
		try {
			return getLocalService(ICommissionLigneBusinessService.class, "CommissionLigneBusinessServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        public ICommissionBusinessService getCommissionBusinessService() {
		try {
			return getLocalService(ICommissionBusinessService.class, "CommissionBusinessServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        public IGrossisteService getGrossisteService() {
		try {
			return getLocalService(IGrossisteService.class, "GrossisteServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        
//	public IClientService getClientService() {
//		try {
//			return getLocalService(IClientService.class, "ClientServiceImpl");
//		} catch (NamingException e) {
//			throw new RuntimeException(e);
//		}
//	}
	

        
        
        public ICommissionClientService getCommissionClientService() {
		try {
			return getLocalService(ICommissionClientService.class, "CommissionClientServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        
        public ICommissionTaxeService getCommissionTaxeService() {
		try {
			return getLocalService(ICommissionTaxeService.class, "CommissionTaxeServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        
        public ILigneCommissionClientService getLigneCommissionClientService() {
		try {
			return getLocalService(ILigneCommissionClientService.class, "LigneCommissionClientServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

        
          
        public IImpotTaxeService getImpotTaxeService() {
		try {
			return getLocalService(IImpotTaxeService.class, "ImpotTaxeServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        public ILigneCommissionTaxeService getLigneCommissionTaxeService() {
		try {
			return getLocalService(ILigneCommissionTaxeService.class, "LigneCommissionTaxeServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
        


        public ITypeImpotTaxeService getTypeImpotTaxeService() {
		try {
			return getLocalService(ITypeImpotTaxeService.class, "TypeImpotTaxeServiceImpl");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
