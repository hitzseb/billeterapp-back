package hitzseb.BilleterApp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import hitzseb.BilleterApp.model.Category;
import hitzseb.BilleterApp.model.Operation;
import hitzseb.BilleterApp.service.OperationService;
import hitzseb.BilleterApp.service.UserService;
import hitzseb.BilleterApp.util.Type;
import hitzseb.BilleterApp.util.Views;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OperationController {
    private final OperationService operationService;
    private final UserService userService;

    @PostMapping("/new-operation")
    public void newOperation(@RequestBody Operation operation) {
        operationService.saveOperation(operation);
    }

    @JsonView(Views.Public.class)
    @GetMapping("/get-operations")
    @ResponseBody
    public List<Operation> getOperations() {
        return operationService.findOperationsByUserId(userService.getCurrentUserId());
    }

    @PutMapping("/edit-operation/{id}")
    public void editOperation(@PathVariable Long id, @RequestParam String description,
                              @RequestParam Float amount, @RequestParam Type type,
                              @RequestParam Category category, @RequestParam String date) {
        Operation operation = operationService.findOperationById(id);
        operation.setDescription(description);
        operation.setAmount(amount);
        operation.setType(type);
        operation.setCategory(category);
        operation.setDate(date);
        operationService.saveOperation(operation);
    }

    @DeleteMapping("/delete-operation/{id}")
    public void deleteOperation(@PathVariable Long id) {
        operationService.deleteOperationById(id);
    }
}
