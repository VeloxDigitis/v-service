package me.veloxdigitis.vservice.appliances;

import me.veloxdigitis.vservice.categories.Category;
import me.veloxdigitis.vservice.comments.Comment;
import me.veloxdigitis.vservice.parameters.ApplianceParameter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "appliance")
@DynamicUpdate
public class Appliance {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private ApplianceState state = ApplianceState.WORKING;

    @OneToMany(mappedBy = "appliance", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ApplianceParameter> parameters = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(mappedBy = "appliance", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = Collections.emptyList();

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

    public ApplianceState getState() {
        return state;
    }

    public void setState(ApplianceState state) {
        this.state = state;
    }

    public Set<ApplianceParameter> getParameters() {
        return parameters;
    }

    public void setParameters(Set<ApplianceParameter> parameters) {
        this.parameters = parameters;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return String.format("%s [%d]", name, id);
    }
}
