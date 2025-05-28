package com.example.jobapp.company;
import com.example.jobapp.company.CompanyService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {
    final CompanyService companyService;
//

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    // Get all companies
    @GetMapping("")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findOne(@PathVariable Long id){
        Company company = companyService.findById(id);
        if(company != null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    crud

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created Successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Company company){
        boolean updated = companyService.updateCompany(company, id);
        if(updated){
            return new ResponseEntity<>("Updated Company Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error updating company", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            companyService.deleteCompany(id);
            return new ResponseEntity<>("Company successfully deleted", HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Error deleting company", HttpStatus.NOT_FOUND);
        }
    }
}
