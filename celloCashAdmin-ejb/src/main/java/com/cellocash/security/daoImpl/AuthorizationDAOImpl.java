package com.cellocash.security.daoImpl;


import com.cellocash.security.dao.IAuthorizationDAO;
import com.cellocash.security.service.entity.Authorization;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@Local(IAuthorizationDAO.class)
public class AuthorizationDAOImpl  implements IAuthorizationDAO{

	@PersistenceContext
	protected EntityManager em;

	@Override
	public Authorization create(Authorization entity) {
		Authorization a = get(entity.getPermissionId());
		if (a != null) {

			em.merge(entity);
			return entity;

		} else {
			em.persist(entity);
			return entity;
		}
	}

	@Override
	public Authorization get(long entityId) {
		try {
			Authorization u = em.find(Authorization.class, entityId);

			return u;

		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public boolean remove(Authorization entity) {
		Authorization a = get(entity.getPermissionId());
		if (null != a) {
			em.remove(a);
			return true;
		}
		return false;
	}

	@Override
	public Authorization update(Authorization entity) {
		Authorization a = get(entity.getPermissionId());
		if (a != null) {
			em.merge(entity);
			return entity;

		} else {
			return create(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authorization> getAllPermissions() {
		try {
			return em.createNamedQuery("RolePermission.getAllPermissions")
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Authorization> getPermissionByRecipient(String recipient) {
		try {
			return em
					.createNamedQuery("RolePermission.getPermissionByRecipiant")
					.setParameter("recipient", recipient).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authorization> getPermissionByTarget(String target) {
		try {
			return em.createNamedQuery("RolePermission.getPermissionByTarget")
					.setParameter("target", target).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authorization> getPermissionByAction(String action) {
		try {
			return em.createNamedQuery("RolePermission.getPermissionByAction")
					.setParameter("action", action).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authorization> getPermissionsForRole(String roleId) {
		try {
			Query query = em
					.createQuery("SELECT dt FROM Role a JOIN a.permission dt  WHERE a.designation=:designation ");
			query.setParameter("designation", roleId);
			return  query.getResultList();
		
		} catch (Exception e) {
			return null;
		}
	}

}
