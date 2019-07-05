package br.poa.ibm.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("")
    public ModelAndView dashboard(){
        ModelAndView mav = new ModelAndView("index");

        return mav;
    }


}
