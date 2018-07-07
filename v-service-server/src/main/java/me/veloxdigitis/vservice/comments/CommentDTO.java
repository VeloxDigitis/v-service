package me.veloxdigitis.vservice.comments;

import javax.validation.constraints.NotBlank;

public class CommentDTO {

    @NotBlank
    private String author;

    @NotBlank
    private String text;

    protected CommentDTO() {}

    public CommentDTO(Comment comment) {
        this.author = comment.getAuthor();
        this.text = comment.getText();
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
}
