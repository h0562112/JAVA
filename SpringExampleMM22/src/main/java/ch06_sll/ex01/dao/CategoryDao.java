package ch06_sll.ex01.dao;

import java.util.List;

import ch06_sll.ex01.model.Category;

public interface CategoryDao {

	Category findById(Integer id);

	Category findByName(String categoryName);
	
	Category save(Category category);

	List<Category> findAll();
}
