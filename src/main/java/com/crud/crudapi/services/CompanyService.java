package com.crud.crudapi.services;

import com.crud.crudapi.constants.ConstantsHelper;
import com.crud.crudapi.exception.ResourceServerErrorException;
import com.crud.crudapi.modal.Company;
import com.crud.crudapi.modal.Person;
import com.crud.crudapi.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    public CompanyRepository companyRepository;
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompanyById(Long id) {
        try {
           return this.companyRepository.getCompanyById(id);
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }

    public Company createCompany(Company company) {
        try {
            return this.companyRepository.save(company);
        } catch (Exception e) {
            throw new ResourceServerErrorException(ConstantsHelper.serverUnavailable);
        }
    }
}
