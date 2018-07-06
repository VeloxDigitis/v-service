package me.veloxdigitis.vservice.appliances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplianceService implements IApplianceService {

    private AppliancesRepository appliancesRepository;

    @Autowired
    public ApplianceService(AppliancesRepository appliancesRepository) {
        this.appliancesRepository = appliancesRepository;
    }

    @Override
    public List<Appliance> getAppliances() {
        return appliancesRepository.findAll();
    }

    @Override
    public void addAppliance(Appliance appliance) {
        appliancesRepository.save(appliance);
    }
}
