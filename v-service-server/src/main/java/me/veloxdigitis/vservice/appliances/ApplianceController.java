package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.categories.Category;
import me.veloxdigitis.vservice.categories.ICategoryService;
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
    private final ICategoryService categoryService;

    @Autowired
    public ApplianceController(IApplianceService applianceService, ICategoryService categoryService) {
        this.applianceService = applianceService;
        this.categoryService = categoryService;
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

        String categoryName = applianceDTO.getCategory();
        appliance.setCategory(categoryService.findByName(categoryName).orElse(new Category(categoryName)));

        applianceService.addAppliance(appliance);
        return listAppliances();
    }

}
