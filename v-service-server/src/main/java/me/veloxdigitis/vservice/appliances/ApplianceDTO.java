package me.veloxdigitis.vservice.appliances;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.veloxdigitis.vservice.comments.CommentDTO;
import me.veloxdigitis.vservice.parameters.ParameterDTO;

import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplianceDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    private ApplianceState state = ApplianceState.WORKING;

    private List<ParameterDTO> parameters;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<CommentDTO> comments = Collections.emptyList();

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ApplianceState getState() {
        return state;
    }

    public void setState(ApplianceState state) {
        this.state = state;
    }

    public List<ParameterDTO> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDTO> parameters) {
        this.parameters = parameters;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
