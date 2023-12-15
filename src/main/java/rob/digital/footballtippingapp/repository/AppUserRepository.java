package rob.digital.footballtippingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rob.digital.footballtippingapp.model.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

//    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByUsername(String username);

}
