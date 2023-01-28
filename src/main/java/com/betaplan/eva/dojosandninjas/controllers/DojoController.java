package com.betaplan.eva.dojosandninjas.controllers;

import com.betaplan.eva.dojosandninjas.models.Dojo;
import com.betaplan.eva.dojosandninjas.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/dojo")
public class DojoController {
    @Autowired
    private DojoService dojoServe;
    @GetMapping("/new")
    public String createDojo(@ModelAttribute("dojo") Dojo dojo){
        return "newDojo";
    }
    @PostMapping("/createDojo")
        public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,@NotNull BindingResult result ){
        if(result.hasErrors()){
            return "newDojo";
        }
        dojoServe.create(dojo);
        return "redirect:/ninjas/new";
    }

    @GetMapping("/{id}")
        public String details(Model model, @PathVariable("id") Long id){
        model.addAttribute("dojo",dojoServe.getDojoID(id));
        return "details";
    }

}
