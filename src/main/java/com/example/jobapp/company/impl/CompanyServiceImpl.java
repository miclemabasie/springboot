package com.example.jobapp.company.impl;

import com.example.jobapp.company.Company;
import com.example.jobapp.company.CompanyRepository;
import com.example.jobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        System.out.println(company);
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company updatedCompany = optionalCompany.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setIndustry(company.getIndustry());
            updatedCompany.setSize(company.getSize());
            updatedCompany.setWebsite(company.getWebsite());
            updatedCompany.setPhone_number(company.getPhone_number());
            updatedCompany.setDescription(company.getDescription());
            updatedCompany.setCreated_at(company.getCreated_at());
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;

        } catch (Exception e){
            return false;
        }
    }
}
