package ml.viktorov.usermvc.controller;

import ml.viktorov.usermvc.model.User;
import ml.viktorov.usermvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = {"/", "/index", "/users"})
    public String index(Model model) {

        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/create")
    public String createUser() {
        return "users/create";
    }

    @PostMapping("/create")
    public String saveUser(@RequestParam("firstName") String name,
                           @RequestParam("lastName") String lastName,
                           Model model) {
        if (name == "" && lastName == "") {
            model.addAttribute("msg", "All fields must be filled!");
            return "users/err/warning";
        } else {
            userService.saveUser(name, lastName);
            return "redirect:/users";
        }
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("msg", "User not found");
            return "users/err/warning";
        } else {
            userService.deleteById(id);
            return "redirect:/users";
        }
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("msg", "User not found");
            return "users/err/warning";
        } else {
            model.addAttribute("user", user);
            return "users/update";
        }
    }

    @PatchMapping("/update")
    public String update(@RequestParam("id") String id,
                         @RequestParam("firstName") String name,
                         @RequestParam("lastName") String lastName,
                         Model model) {
        userService.updateUser(Long.valueOf(id), name, lastName);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        if (id >= 0) {
            User user = userService.findById(id);
            if (user != null) {
                model.addAttribute("users", user);
                return "users/index";
            } else {
                model.addAttribute("msg", "User not found");
                return "users/err/warning";
            }
        } else {
            model.addAttribute("msg", "Invalid request");
            return "users/err/warning";
        }
    }
}
