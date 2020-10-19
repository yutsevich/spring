package org.example;

import org.example.config.AppConfig;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user1 = new User("bob@gmail.com","BoB");
        User user2 = new User("alise123@gmail.com","aliso4ka");
        userService.add(user1);
        userService.add(user2);
        userService.getAll().forEach(System.out::println);
    }
}
