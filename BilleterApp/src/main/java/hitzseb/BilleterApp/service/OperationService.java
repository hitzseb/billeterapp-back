package hitzseb.BilleterApp.service;

import hitzseb.BilleterApp.model.Category;
import hitzseb.BilleterApp.model.Operation;
import hitzseb.BilleterApp.repo.OperationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OperationService {
    private final OperationRepo operationRepo;

    public List<Operation> findOperationsByUserId(Long userId) {
        return operationRepo.findOperationsByUserId(userId);
    }

    public Operation findOperationById(Long id) {
        return operationRepo.findById(id).orElse(null);
    }

    public void saveOperation(Operation operation) {
        operationRepo.save(operation);
    }

    public void deleteOperationById(Long id) {
        operationRepo.deleteById(id);
    }
}
