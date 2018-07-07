package me.veloxdigitis.vservice.categories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Set<Category> findAll();
    Optional<Category> findByName(String name);
}
