/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellocash.model.services;

import com.cellocash.model.Pays;
import com.cellocash.model.ProgrammeFacturationBusiness;
import java.util.List;

/**
 *
 * @author marfu
 */
public interface IProgrammeFacturationBusinessService {
    
      public List<ProgrammeFacturationBusiness> getAll();
      public ProgrammeFacturationBusiness get(Long id);
    
}
