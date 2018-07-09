package me.veloxdigitis.vservice.categories;

import java.util.Optional;
import java.util.Set;

public interface ICategoryService {

    Set<Category> getCategories();
    Optional<Category> findByName(String name);
    Category add(String name);

}
