package com.ecomm.DAO;

import java.util.List;

import com.ecomm.Model.Category;

public interface CategoryDAO {

	public List<Category> findAllCategories();
	public Category findCategoryById(int CategoryId);
	public Category findCategoryByName(String CategoryName);
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryId);
}
