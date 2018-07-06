package me.veloxdigitis.vservice.appliances;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppliancesRepository extends CrudRepository<Appliance, Long> {

    List<Appliance> findAll();

}
