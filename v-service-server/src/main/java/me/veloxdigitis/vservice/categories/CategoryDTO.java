package me.veloxdigitis.vservice.categories;

public class CategoryDTO {

    private String name;

    public CategoryDTO(Category category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
