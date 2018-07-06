package me.veloxdigitis.vservice.parameters;

import me.veloxdigitis.vservice.appliances.Appliance;

import java.util.Set;

public interface IParameterService {

    Set<ApplianceParameter> getAllApplianceParameters(Appliance appliance);

}
