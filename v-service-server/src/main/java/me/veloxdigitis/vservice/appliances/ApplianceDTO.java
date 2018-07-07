package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.comments.CommentDTO;
import me.veloxdigitis.vservice.parameters.ParameterDTO;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplianceDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    private ApplianceState state = ApplianceState.WORKING;

    private Set<ParameterDTO> parameters;

    private Set<CommentDTO> comments;

    protected ApplianceDTO() {}

    public ApplianceDTO(Appliance appliance) {
        this.id = appliance.getId();
        this.name = appliance.getName();
        this.category = appliance.getCategory().getName();
        this.state = appliance.getState();
        this.parameters = appliance.getParameters().stream().map(ParameterDTO::new).collect(Collectors.toSet());
        this.comments = appliance.getComments().stream().map(CommentDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ParameterDTO> getParameters() {
        return parameters;
    }

    public void setParameters(Set<ParameterDTO> parameters) {
        this.parameters = parameters;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDTO> comments) {
        this.comments = comments;
    }

    public ApplianceState getState() {
        return state;
    }

    public void setState(ApplianceState state) {
        this.state = state;
    }
}
