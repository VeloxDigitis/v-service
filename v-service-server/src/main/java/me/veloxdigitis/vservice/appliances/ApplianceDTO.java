package me.veloxdigitis.vservice.appliances;

import javax.validation.constraints.NotBlank;

public class ApplianceDTO {

    @NotBlank
    private String name;

    protected ApplianceDTO() {}

    public ApplianceDTO(Appliance appliance) {
        this.name = appliance.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
