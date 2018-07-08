package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.categories.Category;
import me.veloxdigitis.vservice.categories.ICategoryService;
import me.veloxdigitis.vservice.comments.Comment;
import me.veloxdigitis.vservice.comments.CommentDTO;
import me.veloxdigitis.vservice.comments.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/appliances")
public class ApplianceController {

    private final IApplianceService applianceService;
    private final ICategoryService categoryService;
    private final ICommentService commentService;

    @Autowired
    public ApplianceController(IApplianceService applianceService, ICategoryService categoryService, ICommentService commentService) {
        this.applianceService = applianceService;
        this.categoryService = categoryService;
        this.commentService = commentService;
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
        appliance.setState(applianceDTO.getState());

        String categoryName = applianceDTO.getCategory();
        appliance.setCategory(categoryService.findByName(categoryName).orElse(new Category(categoryName)));

        applianceService.addAppliance(appliance);
        return ResponseEntity.ok(new ApplianceDTO(appliance));
    }

    @RequestMapping(value = "{id}", method = GET)
    public ResponseEntity<?> get(@PathVariable Long id) {
        return applianceService.getAppliance(id).
                map(ApplianceDTO::new).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return applianceService.getAppliance(id).map(a -> {
            applianceService.deleteAppliance(a);
            return listAppliances();
        }).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "{id}/comment", method = POST)
    public ResponseEntity<?> comment(@Valid @RequestBody CommentDTO commentDTO, @PathVariable Long id) {
        return applianceService.getAppliance(id).
                map(appliance -> commentService.comment(
                        new Comment(commentDTO.getAuthor(), commentDTO.getText(), appliance))).
                map(CommentDTO::new).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value ="{id}", method = PATCH)
    public ResponseEntity<?> setState(@RequestBody String state, @PathVariable Long id) {
        applianceService.getAppliance(id).ifPresent(a -> applianceService.setState(a, ApplianceState.valueOf(state)));
        return get(id);
    }

}
