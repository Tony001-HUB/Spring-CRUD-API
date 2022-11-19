package com.crud.crudapi.repository;

import com.crud.crudapi.modal.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company getCompanyById(Long companyId);
}
