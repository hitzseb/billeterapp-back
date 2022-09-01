package hitzseb.BilleterApp.controller;

import hitzseb.BilleterApp.model.User;
import hitzseb.BilleterApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public void signUp(@RequestBody User user) {
        userService.signUpUser(user);
    }
}
