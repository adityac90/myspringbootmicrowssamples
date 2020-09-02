package org.cts.fse.cousefinder.controller;


import org.cts.fse.cousefinder.model.ApplicationUser;
import org.cts.fse.cousefinder.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class LoginController {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApplicationUser> signUp(@RequestBody ApplicationUser applicationUser) {
        final String encodedPassword = bCryptPasswordEncoder.encode(applicationUser.getPassword());
        applicationUser.setPassword(encodedPassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(applicationUser));
    }


}
