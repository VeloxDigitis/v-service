package me.veloxdigitis.vservice.appliances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        return ResponseEntity.ok(applianceService.getAppliances());
    }

    @RequestMapping(method = POST)
    public ResponseEntity<?> addAppliance(@Valid @RequestBody ApplianceDTO applianceDTO) {
        applianceService.addAppliance(new Appliance(applianceDTO.getName()));
        return listAppliances();
    }

}
