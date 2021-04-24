package com.omnidata.app2.Repositories;


import com.omnidata.app2.Models.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepo extends CrudRepository<Organisation,Integer> {


}
