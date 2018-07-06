package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/appliances")
public class ApplianceController {

    private final IApplianceService applianceService;

    @Autowired
    public ApplianceController(IApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> listAppliances() {
        return ResponseEntity.ok(applianceService.getAppliances().stream().map(ApplianceDTO::new).collect(Collectors.toList()));
    }

    @RequestMapping(method = POST)
    public ResponseEntity<?> addAppliance(@Valid @RequestBody ApplianceDTO applianceDTO) {
        Appliance appliance = new Appliance();
        appliance.setName(applianceDTO.getName());
        appliance.setParameters(applianceDTO.getParameters().stream().map(p -> p.pack(appliance)).collect(Collectors.toSet()));
        appliance.setCategory(new Category(applianceDTO.getCategory()));

        applianceService.addAppliance(appliance);
        return listAppliances();
    }

}
