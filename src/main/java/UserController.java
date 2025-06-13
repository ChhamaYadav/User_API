import org.example.User;
import org.example.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(User user){
        return userService.signup(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginuser){
        return userService.login(loginuser.getEmail(),loginuser.getPassword());
    }
}
