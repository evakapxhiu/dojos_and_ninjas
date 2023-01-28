package com.betaplan.eva.dojosandninjas.controllers;

import com.betaplan.eva.dojosandninjas.models.Dojo;
import com.betaplan.eva.dojosandninjas.models.Ninja;
import com.betaplan.eva.dojosandninjas.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
    @Autowired
    private DojoService dojoServe;

    @GetMapping("/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        List<Dojo> dojos=dojoServe.findDojos();
        model.addAttribute("dojos",dojos);
        return "newNinja";
    }
    @PostMapping("/createNinja")
    public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, @NotNull BindingResult result, Model model){
        if (result.hasErrors()){
            List<Dojo> dojos=dojoServe.findDojos();
            model.addAttribute("dojos",dojos);
            return "newNinja";
        }
        dojoServe.createNinja(ninja);
        return "redirect:/dojo/" + ninja.getDojo().getId();
    }
}
