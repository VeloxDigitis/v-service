package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.comments.CommentDTO;
import me.veloxdigitis.vservice.parameters.ParameterDTO;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplianceDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    private ApplianceState state = ApplianceState.WORKING;

    private List<ParameterDTO> parameters;

    private List<CommentDTO> comments;

    protected ApplianceDTO() {}

    public ApplianceDTO(Appliance appliance) {
        this.id = appliance.getId();
        this.name = appliance.getName();
        this.category = appliance.getCategory().getName();
        this.state = appliance.getState();
        this.parameters = appliance.getParameters().stream().map(ParameterDTO::new).collect(Collectors.toList());
        this.comments = appliance.getComments().stream().map(CommentDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ParameterDTO> getParameters() {
        return parameters;
    }

    public String getCategory() {
        return category;
    }

    public ApplianceState getState() {
        return state;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }
}
