package com.revature.controllers;

import com.revature.dtos.LoginDTO;
import com.revature.dtos.RegisterDTO;
import com.revature.exceptions.InvalidUserException;
import com.revature.models.User;
import com.revature.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO, HttpSession session)  {
        try {
            Optional<User> userOptional = authService.findByCredentials(loginDTO.getUsername(), loginDTO.getPassword());
            session.setAttribute("user", userOptional.get());
            return ResponseEntity.ok(userOptional.get());
        }
        catch (InvalidUserException e){
            System.out.println(e.getStackTrace());
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
            return ResponseEntity.badRequest().build();
        }
    }
//    @PostMapping("/logout")
//    public ResponseEntity<Void> logout(HttpSession session) {
//        session.removeAttribute("user");
//        return ResponseEntity.ok().build();
//    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session)
    {
        if(session.getAttribute("user")==null)
            return ResponseEntity.ok().body("You are already signed out.");
        else
        {
            session.removeAttribute("user");
            return ResponseEntity.ok().body("You have been signed out.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
        User created = new User(
                0,
                registerDTO.getFirstName(),
                registerDTO.getLastName(),
                registerDTO.getUsername(),
                registerDTO.getPassword(),
                registerDTO.getEmail(),
                registerDTO.getAddress());
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(created));
    }


}
