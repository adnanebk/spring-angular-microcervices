package com.omnidata.app2.Services;

import com.omnidata.app2.Models.Organisation;
import com.omnidata.app2.Repositories.OrganisationRepo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrganisationService {

    private OrganisationRepo organisationRepo;

    public OrganisationService(OrganisationRepo organisationRepo) {
        this.organisationRepo = organisationRepo;
    }

    public void createOrganization(Organisation organisation) {
        organisationRepo.save(organisation);
    }

    public void createOrganizations(List<Organisation> organisation) {
        organisationRepo.saveAll(organisation);
    }

    public Optional<Organisation> getOrganisationsById(int id) {
        return  organisationRepo.findById(id);
    }
    public Iterable<Organisation> getOrganisations() {
        return  organisationRepo.findAll();
    }
}
