package me.veloxdigitis.vservice.appliances;

import java.util.List;
import java.util.Optional;

public interface IApplianceService {

    List<Appliance> getAppliances();
    void addAppliance(Appliance appliance);
    Optional<Appliance> getAppliance(Long id);

}
