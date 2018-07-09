package me.veloxdigitis.vservice.config;

import me.veloxdigitis.vservice.categories.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private CategoryService categoryService;

    @Autowired
    public DataLoader(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void run(ApplicationArguments args) {
        categoryService.add("Computer");
        categoryService.add("Refrigerator");
        categoryService.add("Fridge");
        categoryService.add("Cooker");
        categoryService.add("Freezer");
        categoryService.add("Washer");
        categoryService.add("TV Set");
        categoryService.add("Washing machine");
    }
}