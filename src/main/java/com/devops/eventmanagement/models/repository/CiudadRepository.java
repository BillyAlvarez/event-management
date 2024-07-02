package com.devops.eventmanagement.models.repository;

import com.devops.eventmanagement.models.entity.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Long> {


}
