/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.OperationCelloCash;

import java.util.List;

/**
 *
 * @author marfu
 */
public interface IOperationCelloCashService {
     public List<OperationCelloCash> getAll();
      public OperationCelloCash findById(long id);
}
