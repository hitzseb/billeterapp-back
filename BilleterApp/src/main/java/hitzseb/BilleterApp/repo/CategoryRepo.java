package hitzseb.BilleterApp.repo;

import hitzseb.BilleterApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findCategoriesByUserId(Long user_id);
}
