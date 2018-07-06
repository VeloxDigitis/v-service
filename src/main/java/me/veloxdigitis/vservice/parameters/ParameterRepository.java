package me.veloxdigitis.vservice.parameters;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ParameterRepository extends CrudRepository<ApplianceParameter, Long> {

    Set<ApplianceParameter> findAllBy();

}
