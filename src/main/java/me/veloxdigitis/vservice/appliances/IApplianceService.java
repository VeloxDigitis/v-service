package me.veloxdigitis.vservice.appliances;

import java.util.List;

public interface IApplianceService {

    List<Appliance> getAppliances();
    void addAppliance(Appliance appliance);

}
