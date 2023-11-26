package ba.edu.ibu.webengineeringproject.core.service;

import ba.edu.ibu.webengineeringproject.core.model.User;
import ba.edu.ibu.webengineeringproject.core.model.enums.UserType;
import ba.edu.ibu.webengineeringproject.core.repository.OrderRepository;
import ba.edu.ibu.webengineeringproject.core.repository.UserRepository;
import ba.edu.ibu.webengineeringproject.rest.dto.UserDTO;
import ba.edu.ibu.webengineeringproject.rest.dto.UserRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc
@SpringBootTest
class UserServiceTest {
    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void shouldReturnUserWhenCreated() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        User user = new User();
        user.setUserType(UserType.WORKER);

        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        UserDTO savedUser = userService.addUser(userRequestDTO);
        Assertions.assertEquals(user.getUserType(), savedUser.getUserType());
    }
    @Test
    public void shouldFindUserById() {
        String userId = "1";
        User user = new User();
        user.setId(userId);
        user.setUserType(UserType.ADMIN);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserDTO foundUser = userService.findById(userId);
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals(userId, foundUser.getId());
    }
    @Test
    public void shouldDeleteUser() {
        String userId = "1";
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setUserType(UserType.ADMIN);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        userService.deleteUser(userId);

        Mockito.verify(userRepository, Mockito.times(1)).delete(existingUser);
    }

}