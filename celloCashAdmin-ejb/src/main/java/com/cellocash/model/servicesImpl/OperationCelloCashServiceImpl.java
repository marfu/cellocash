/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.servicesImpl;

import com.cellocash.model.OperationCelloCash;

import com.cellocash.model.dao.OperationCelloCashDao;
import com.cellocash.model.services.IOperationCelloCashService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author marfu
 */

@SuppressWarnings("serial")
@Stateless
@Local(IOperationCelloCashService.class)

public class OperationCelloCashServiceImpl implements IOperationCelloCashService, Serializable {

    @EJB
    private OperationCelloCashDao operationCelloCashDao;

    @Override
    public List<OperationCelloCash> getAll() {
        return operationCelloCashDao.findAll();
    }

    @Override
    public OperationCelloCash findById(long code) {
        return operationCelloCashDao.findById(code);

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
