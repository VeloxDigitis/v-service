package me.veloxdigitis.vservice.appliances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
        getAppliance(appliance.getId()).ifPresent(this::deleteAppliance);
        appliancesRepository.save(appliance);
    }

    @Override
    public Optional<Appliance> getAppliance(Long id) {
        return Optional.ofNullable(id).flatMap(a -> appliancesRepository.findById(a));
    }

    @Override
    public void deleteAppliance(Appliance appliance) {
        appliancesRepository.delete(appliance);
    }
}
