package rob.digital.footballtippingapp.controller;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rob.digital.footballtippingapp.model.AppUser;
import rob.digital.footballtippingapp.service.AppUserService;

import java.util.List;

@Builder
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class AppUserController {

    private final AppUserService userService;

    @GetMapping("")
//    @PreAuthorize("hasAnyRole('USER')")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<AppUser> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();
        System.out.println("WWWWWWWWWWWWWWWWW " + user);
        return ResponseEntity.ok(user);     // check if this is safe to return a user here
    }
}
