package cl.duocuc.huertohogar.backend.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.duocuc.huertohogar.backend.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    // Asume que tienes un UserRepository de Spring Data JPA
    private final UserRepository userRepository; 

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca el usuario en la base de datos por su email (que es el username en este caso)
        return userRepository.findByEmail(email)
                .orElseThrow(() -> 
                new UsernameNotFoundException("Usuario no encontrado con email: " + email));
    }
}
