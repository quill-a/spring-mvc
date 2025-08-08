package dev.quilla.springmvc;

import dev.quilla.springmvc.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private AlienDao dao;

    @ModelAttribute
    public void modelData(Model model) {

        model.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model model) {

        model.addAttribute("result", dao.getAliens());

        return "showAliens";
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

        dao.addAlien(alien);

        return "result";
    }

    @PostMapping("getAlien")
    public String getAlien(@RequestParam int id,  Model model) {

        model.addAttribute("result", dao.getAlien(id));

        return "showAlien";
    }
}
