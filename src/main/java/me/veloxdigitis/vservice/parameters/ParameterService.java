package me.veloxdigitis.vservice.parameters;

import me.veloxdigitis.vservice.appliances.Appliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class ParameterService implements IParameterService {

    private final ParameterRepository parameterRepository;

    @Autowired
    public ParameterService(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public Set<ApplianceParameter> getAllApplianceParameters(Appliance appliance) {
        return Collections.emptySet();
    }
}
