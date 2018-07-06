package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.parameters.ParameterDTO;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplianceDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    private Set<ParameterDTO> parameters;

    protected ApplianceDTO() {}

    public ApplianceDTO(Appliance appliance) {
        this.name = appliance.getName();
        this.category = appliance.getCategory().getName();
        this.parameters = appliance.getParameters().stream().map(ParameterDTO::new).collect(Collectors.toSet());
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
}
