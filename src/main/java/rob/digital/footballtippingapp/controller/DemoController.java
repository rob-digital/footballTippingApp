package rob.digital.footballtippingapp.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rob.digital.footballtippingapp.model.AppUser;
import rob.digital.footballtippingapp.service.AppUserService;

@RestController
@RequestMapping("/api/v1/admin")
public class DemoController {

    AppUserService appUserService;
    //    private final UserService userService;
    @GetMapping
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppUser> sayHello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }


}
