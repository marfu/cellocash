package com.cellocash.security.service.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "param_secu_role_permission")
public class Authorization implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7310382081034246253L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long permissionId;

    @Column(name = "nom", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    private Authorization menuParent;

    public Authorization() {
    }

    public long getPermissionId() {

        return permissionId;

    }

    public void setPermissionId(long permissionId) {

        this.permissionId = permissionId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Authorization getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(Authorization menuParent) {
        this.menuParent = menuParent;
    }

}
