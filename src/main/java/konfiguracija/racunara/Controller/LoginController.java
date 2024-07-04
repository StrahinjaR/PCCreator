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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String index() {
        return "index";
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
    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            RedirectAttributes redirectAttributes) {

        String sifrovanasifra = passwordEncoder.encode(password);
        try {
            repo.saveUser(username, sifrovanasifra, email);
            return "login"; // Uspesna registracija preusmerava na stranicu za prijavljivanje
        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("error", "Došlo je do greške prilikom registracije.");
            return "redirect:/register?error=true";
        }
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }



    @GetMapping("/login")
    String login() {
        return "login";
    }


}
