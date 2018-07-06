package me.veloxdigitis.vservice.parameters;

import me.veloxdigitis.vservice.appliances.Appliance;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class ApplianceParameter {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String value;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "appliance_id")
    private Appliance appliance;

    protected ApplianceParameter() {}

    public ApplianceParameter(String name, String value, Appliance appliance) {
        this.name = name;
        this.value = value;
        this.appliance = appliance;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public String toString() {
        return String.format("%s: %s [%d]", name, value, id);
    }
}