package com.example.jobapp.company;
import com.example.jobapp.company.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company/")
public class CompanyController {
    final CompanyService companyService;
//

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    // Get all companies
    @GetMapping("/")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

}
