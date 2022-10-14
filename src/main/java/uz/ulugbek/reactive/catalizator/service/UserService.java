package uz.ulugbek.reactive.catalizator.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import uz.ulugbek.reactive.catalizator.repository.UserRepository;

@Service
public class UserService implements ReactiveUserDetailsService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Mono<UserDetails> userDetails = userRepository.findByUsername(username)
                .cast(UserDetails.class);

        return userDetails;
    }
}
