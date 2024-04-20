package ru.ber.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ber.springbootapp.model.User;
import ru.ber.springbootapp.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;
    @GetMapping
    public String showAll (Model model) {
        model.addAttribute("list", userService.listOfUsers());
        return "users";
    }
    @GetMapping("/new")
    public String addUser (Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String createUser (@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/get")
    public String getUser (Model model, @RequestParam ("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("userForUpdate", user);
        return "get";
    }

    @PostMapping("/get")
    public String updateUser (Model model, @ModelAttribute("userForUpdate") User user, @RequestParam Long id) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String getUserForRemoval (Model model, @RequestParam ("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("userForRemoval", user);
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteUser (Model model, @ModelAttribute ("userForRemoval") User user, @RequestParam Long id) {
        user.setId(id);
        userService.userRemoval(user);
        return "redirect:/users";
    }





}
