package com.omnidata.app2.Seeder;


import com.omnidata.app2.Models.Organisation;
import com.omnidata.app2.Services.OrganisationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class dataSeeder implements CommandLineRunner {

    private OrganisationService organisationService;

    public dataSeeder(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @Override
    public void run(String... args)  {
        organisationService.createOrganizations(
                List.of( new Organisation("omnishore","It"),
                        new Organisation("Roka","Industry"),
                        new Organisation("Iru","Transport")
                        ));
    }
}
