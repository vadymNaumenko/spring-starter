package com.dmdev.spring.http.controller;

import com.dmdev.spring.database.entity.Role;
import com.dmdev.spring.database.repository.CompanyRepository;
import com.dmdev.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

//============ lessen 82
@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles() {
        return Arrays.asList(Role.values());
    }

    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request,
                        @ModelAttribute("userRead") UserReadDto userReadDto) {

        model.addAttribute("user", new UserReadDto(1, "Vadim"));

        return "greeting/hello";
    }

        @GetMapping("/hello/bye")
    public String bye(@SessionAttribute("user") UserReadDto user,Model model) {

        return "greeting/bye";
    }

//    @GetMapping("/hello")
//    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request){
////        request.getSession().setAttribute(); sessionScope
////        request.setAttribute(); requestScope
////        request.getSession().getAttribute("user");
//
//        modelAndView.setViewName("greeting/hello");
//        modelAndView.addObject("user",new UserReadDto(1,"Vadym"));
//
//        return modelAndView;
//    }

//    @GetMapping("/hello/{id}")
//    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request,
//                              @RequestParam Integer age,
//                              @RequestHeader String accept,
//                              @CookieValue("JSESSIONID") String jsessionId,
//                              @PathVariable("id") Integer id) {
//
//        String ageParamValue = request.getParameter("age");
//        String acceptHeader = request.getHeader("accept");
//        Cookie[] cookies = request.getCookies();
//
//        modelAndView.setViewName("greeting/hello");
//
//        return modelAndView;
//    }

//    @GetMapping("/hello/bye")
//    public ModelAndView bye(@SessionAttribute("user") UserReadDto user) {
////        request.getSession().getAttribute("user");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("greeting/bye");
//
//        return modelAndView;
//    }
}
