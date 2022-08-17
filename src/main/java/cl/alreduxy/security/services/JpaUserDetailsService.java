package cl.alreduxy.security.services;

import cl.alreduxy.security.entities.User;
import cl.alreduxy.security.models.CustomUserDetails;
import cl.alreduxy.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException("Problemas para autenticar");

        User u = userRepository.findUserByUsername(username).orElseThrow(s);

        return new CustomUserDetails(u);
    }
}
