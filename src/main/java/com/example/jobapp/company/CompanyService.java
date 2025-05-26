package com.example.jobapp.company;

import java.util.List;

public interface CompanyService {
    // define all interfaces for CRUD operations
    List<Company> findAll();

    Company findById(Long id);

    void createCompany(Company company);

    boolean updateCompany(Company company, Long id);

    boolean deleteCompany(Long id);
}
