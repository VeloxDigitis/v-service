package me.veloxdigitis.vservice.parameters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.veloxdigitis.vservice.appliances.Appliance;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class ApplianceParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "appliance_id")
    private Appliance appliance;

    protected ApplianceParameter() {}

    public ApplianceParameter(String name, String value) {
        this.name = name;
        this.value = value;
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