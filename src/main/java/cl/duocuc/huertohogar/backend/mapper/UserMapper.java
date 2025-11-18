package cl.duocuc.huertohogar.backend.mapper;

import cl.duocuc.huertohogar.backend.dto.UserRegisterRequestDTO;
import cl.duocuc.huertohogar.backend.dto.UserResponseDTO;
import cl.duocuc.huertohogar.backend.entity.Role;
import cl.duocuc.huertohogar.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toResponseDTO(User user) {
        if (user == null) {
            return null;
        }

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .mail(user.getMail())
                .roleName(user.getRole()!= null ? user.getRole().getName(): null)
                .build();
    }

    /**
     * Convierte un DTO de registro en una entidad User.
     * El password debería venir ya hasheado desde el service.
     */
    public User fromRegisterDTO(UserRegisterRequestDTO dto, String passwordHash, Role role) {
        User user = new User();
        user.setName(dto.getName());
        user.setLastname(dto.getLastname());
        user.setMail(dto.getMail());
        user.setPassword(passwordHash);
        user.setRole(role);
        // createdAt lo puede setear la BD o la entidad con @PrePersist
        return user;
    }
}
