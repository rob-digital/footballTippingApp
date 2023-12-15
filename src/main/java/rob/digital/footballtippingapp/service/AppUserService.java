package rob.digital.footballtippingapp.service;

import rob.digital.footballtippingapp.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    Optional<AppUser> findByUsername(AppUser username);
    List<AppUser> allUsers();
}
