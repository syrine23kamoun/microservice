package com.assurance.assuranceback.Entity.CarrieresEntity;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> user) {
        String email = user.get("email");
        String password = user.get("password");

        // Fetch user from the database
        User dbUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate the password
        if (!passwordEncoder.matches(password, dbUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Extract roles (pass the full set of roles, not just one role)
        Set<Role> roles = dbUser.getRoles(); // Get all roles

        // Generate the JWT token with the roles
        Long userId = dbUser.getId();
        String token = jwtService.generateToken(email, roles, userId);

        return ResponseEntity.ok(Map.of("token", token));
    }

}