package hitzseb.BilleterApp.controller;

import hitzseb.BilleterApp.model.Category;
import hitzseb.BilleterApp.service.CategoryService;
import hitzseb.BilleterApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final UserService userService;

    @PostMapping("/new-category")
    public void newCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @GetMapping("/get-categories")
    @ResponseBody
    public List<Category> getCategories() {
        return categoryService.findCategoriesByUserId(userService.getCurrentUserId());
    }

    @PutMapping("/edit-category/{id}")
    public void editCategory(@PathVariable Long id, @RequestParam String name) {
        Category category = categoryService.findCategoryById(id);
        category.setName(name);
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/delete-category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
