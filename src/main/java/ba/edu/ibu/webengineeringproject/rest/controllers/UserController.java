package ba.edu.ibu.webengineeringproject.rest.controllers;

import ba.edu.ibu.webengineeringproject.core.model.Product;
import ba.edu.ibu.webengineeringproject.core.model.User;
import ba.edu.ibu.webengineeringproject.core.service.UserService;
import ba.edu.ibu.webengineeringproject.rest.dto.UserDTO;
import ba.edu.ibu.webengineeringproject.rest.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "JWT Security")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<UserDTO> register(@RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAnyAuthority( 'ADMIN','WORKER')")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
