package hitzseb.BilleterApp.service;

import hitzseb.BilleterApp.model.Category;
import hitzseb.BilleterApp.repo.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<Category> findCategoriesByUserId(Long userId) {
        return categoryRepo.findCategoriesByUserId(userId);
    }

    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }
}
