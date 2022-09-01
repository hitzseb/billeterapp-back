package hitzseb.BilleterApp.repo;

import hitzseb.BilleterApp.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepo extends JpaRepository<Operation, Long> {
    List<Operation> findOperationsByUserId(Long user_id);
}
