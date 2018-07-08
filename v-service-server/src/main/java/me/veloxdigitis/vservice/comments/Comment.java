package me.veloxdigitis.vservice.comments;

import me.veloxdigitis.vservice.appliances.Appliance;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String author;
    private String text;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date time;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "appliance_id")
    private Appliance appliance;

    protected Comment() {}

    public Comment(String author, String text, Appliance appliance) {
        this.author = author;
        this.text = text;
        this.appliance = appliance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    @Override
    public String toString() {
        return String.format("%s: %s [%d]", author, text, id);
    }
}