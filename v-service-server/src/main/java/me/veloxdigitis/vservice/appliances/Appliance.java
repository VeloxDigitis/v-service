package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.parameters.ApplianceParameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "appliance")
public class Appliance {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "appliance", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ApplianceParameter> parameters = new HashSet<>();

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

    public Set<ApplianceParameter> getParameters() {
        return parameters;
    }

    public void setParameters(Set<ApplianceParameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return String.format("%s [%d]", name, id);
    }
}
