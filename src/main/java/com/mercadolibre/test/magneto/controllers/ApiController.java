package com.mercadolibre.test.magneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.test.magneto.business.ControllerBusiness;
import com.mercadolibre.test.magneto.dto.RequestDTO;
import com.mercadolibre.test.magneto.dto.ResponseDTO;

@RestController
@CrossOrigin
public class ApiController {

    @Autowired
    private ControllerBusiness controllerBusiness;

    @RequestMapping(value = {"/stats"}, method = {RequestMethod.GET})
    public ResponseEntity<ResponseDTO> stats() {
        return this.controllerBusiness.stats();
    }

    @RequestMapping(value = {"/mutant"}, method = {RequestMethod.POST})
    public ResponseEntity<?> mutant(@RequestBody RequestDTO req) {
        return this.controllerBusiness.mutant(req);
    }

}
