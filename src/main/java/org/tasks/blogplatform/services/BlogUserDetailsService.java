package org.tasks.blogplatform.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.tasks.blogplatform.domain.User;
import org.tasks.blogplatform.repositories.UserRepository;
import org.tasks.blogplatform.security.BlogUserDetails;


@RequiredArgsConstructor
public class BlogUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not found with email: "+email));
        return new BlogUserDetails(user);
    }
}
