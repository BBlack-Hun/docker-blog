package kr.co.bblackhun.dockerblog.login.controller;

import kr.co.bblackhun.dockerblog.login.payload.JWTAuthResponse;
import kr.co.bblackhun.dockerblog.login.payload.LoginDto;
import kr.co.bblackhun.dockerblog.login.payload.SignUpDto;
import kr.co.bblackhun.dockerblog.system.security.JwtTokenProvider;
import kr.co.bblackhun.dockerblog.user.entity.Role;
import kr.co.bblackhun.dockerblog.user.entity.User;
import kr.co.bblackhun.dockerblog.user.repository.RoleRepository;
import kr.co.bblackhun.dockerblog.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/sign-in")
    public ResponseEntity<JWTAuthResponse> authenticationUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));


       SecurityContextHolder.getContext().setAuthentication(authentication);

       // get token from tokenProvider
        String token = tokenProvider.generateToken(authentication);

       return ResponseEntity.ok(new JWTAuthResponse(token));

    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
        // add check for username exists in DB
        if(userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB

        if(userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("email is already taken!!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        // USER 권한을 부여함..
        Role role = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
