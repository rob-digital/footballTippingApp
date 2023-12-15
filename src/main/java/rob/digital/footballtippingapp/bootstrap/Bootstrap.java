package rob.digital.footballtippingapp.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rob.digital.footballtippingapp.repository.AppUserRepository;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

//    private final AppUser appUser;
    private final AppUserRepository userRepository;

    public void run(String... args) throws Exception {

//        var user1 = AppUser.builder()
//                .firstName("Bob")
//                .lastName("Solinski")
//                .email("a@b.com")
//                .password("zxc")
//                .build();
//
//        userRepository.save(user1);
    }
}
