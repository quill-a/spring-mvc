package dev.quilla.springmvc;

import dev.quilla.springmvc.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("alien1") Alien alien) {

        return "result";
    }
}
