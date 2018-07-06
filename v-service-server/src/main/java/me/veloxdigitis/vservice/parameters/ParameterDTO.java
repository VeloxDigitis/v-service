package me.veloxdigitis.vservice.parameters;

import me.veloxdigitis.vservice.appliances.Appliance;

import javax.validation.constraints.NotBlank;

public class ParameterDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String value;

    protected ParameterDTO() {}

    public ParameterDTO(ApplianceParameter parameter) {
        this.name = parameter.getName();
        this.value = parameter.getValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ApplianceParameter pack(Appliance appliance) {
        return new ApplianceParameter(name, value, appliance);
    }

}
