package com.omnidata.app2.Controllers;

import com.omnidata.app2.Models.Organisation;
import com.omnidata.app2.Services.OrganisationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/organisations")
public class HomeController  {
    private final OrganisationService organisationService;

    public HomeController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/{id}")
    public Organisation getOrganisationById(@PathVariable int id){
       return organisationService.getOrganisationsById(id)
               .orElseThrow(()->
                       new ResponseStatusException(HttpStatus.NOT_FOUND,"organisation not found with id "+ id));
    }

    @GetMapping
    public Iterable<Organisation> getOrganisations(){
        return organisationService.getOrganisations();    }

}
