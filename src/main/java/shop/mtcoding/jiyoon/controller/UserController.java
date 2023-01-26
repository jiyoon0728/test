package shop.mtcoding.jiyoon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.jiyoon.model.User;
import shop.mtcoding.jiyoon.model.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/loginForm")
    public String loginForm(HttpServletRequest request) {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpServletResponse response) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        }
        session.setAttribute("principal", user); // principal 인증주체
        return "list/list";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result == 1) {
            return "redirect:/loginForm";
        } else {
            return "redirect:/joinForm";
        }

    }

    @GetMapping("/updateForm")
    public String updateForm() {
        return "user/updateForm";

    }

    @PostMapping("/update")
    public String update(int id, String username, String password, String email) {
        User user = (User) session.getAttribute("principal");

        int result = userRepository.update(user.getId(), username, password, email);
        if (result == 1) {
            return "redirect:/loginForm";
        } else {
            return "redirect:/joinForm";
        }

    }
}
