package org.example.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.example.dto.UserResponseDto;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/{userId"})
    public UserResponseDto get(Long userId) {
        User user = userService.getById(userId);
        return mapUserToDto(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll().stream()
                .map(this::mapUserToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = {"/inject"})
    public RedirectView insertUsers() {
        userService.add(new User("bob@gmail.com", "BoB"));
        userService.add(new User("alise123@gmail.com", "aliso4ka"));
        userService.add(new User("bchupika@gmail.com", "IamTheBestCoach"));
        userService.add(new User("user@gmail.com", "user"));
        return new RedirectView("/user/all");
    }

    private UserResponseDto mapUserToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
