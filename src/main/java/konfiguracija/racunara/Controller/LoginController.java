package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.Users;
import konfiguracija.racunara.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    @ResponseBody
    public String goH0me() {
        return "This is publickly accesible withing needing authentication ";
    }

    @GetMapping("/users/single")
    public ResponseEntity<Object> getMyDetails() {
        return ResponseEntity.ok(repo.findUserByUsername(getLoggedInUserDetails().getUsername()));
    }

    public UserDetails getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }

    @PostMapping("/user/save")
    public ResponseEntity<Object> saveUSer(@RequestBody Users ourUser) {
        ourUser.setPassword(passwordEncoder.encode(ourUser.getPassword()));
        Users result = repo.save(ourUser);

        return ResponseEntity.ok("USer Was Saved");


    }



    @GetMapping("/login")
    String login() {
        return "login";
    }


}
