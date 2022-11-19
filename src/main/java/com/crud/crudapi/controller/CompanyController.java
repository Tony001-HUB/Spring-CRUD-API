package com.crud.crudapi.controller;

import com.crud.crudapi.modal.Company;
import com.crud.crudapi.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping()
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(this.companyService.createCompany(company), HttpStatus.OK);
    }
}
