package me.veloxdigitis.vservice.comments;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class CommentDTO {

    @NotBlank
    private String author;

    @NotBlank
    private String text;

    private Date time;

    protected CommentDTO() {}

    public CommentDTO(Comment comment) {
        this.author = comment.getAuthor();
        this.text = comment.getText();
        this.time = comment.getTime();
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
}
