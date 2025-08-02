package dev.quilla.springmvcboot;

import dev.quilla.springmvcboot.model.Alien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute
    public void modelData(Model model) {

        model.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {

        return "index";
    }

//    @RequestMapping("add")
//    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
//
//        var modelAndView = new ModelAndView("result");
//
//        int result = num1 + num2;
//
//        modelAndView.addObject("result", result);
//
//        return modelAndView;
//    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute("alien1") Alien alien) {

        return "result";
    }
}
