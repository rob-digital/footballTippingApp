package rob.digital.footballtippingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rob.digital.footballtippingapp.model.AppUser;
import rob.digital.footballtippingapp.repository.AppUserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository userRepository;

    @Override
    public Optional<AppUser> findByUsername(AppUser username) {
        return Optional.of(username);
    }

    @Override
    public List<AppUser> allUsers() {
        return userRepository.findAll();
    }

//    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.findByUsername(username);
//        List<SimpleGrantedAuthority> grantedAuthorities = user.getAuthorities().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList()); // (1)
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities); // (2)
//    }
}
