package com.omnidata.app1.Feign;


import com.omnidata.app1.Model.Organisation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="organisation-service")
public interface OrganisationServiceFeign {
    @GetMapping(path = "/api/organisations/{id}")
    Organisation getOrganisationById(@PathVariable int id);

}
