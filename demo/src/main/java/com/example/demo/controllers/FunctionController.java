package com.example.demo.controllers;

import javax.validation.Valid;

import com.example.demo.entities.Function;
import com.example.demo.repositories.FunctionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FunctionController {
  
  private final FunctionRepository functionRepository;

  @Autowired
  public FunctionController(FunctionRepository functionRepository){
    this.functionRepository = functionRepository;
  }

  @GetMapping("/index")
  public String showFunctionList(Model model){
    model.addAttribute("functions", functionRepository.findAll());
    return "index";
  }

  @GetMapping("/newfunction")
  public String showSignUp(Function function){
    return "newfunction";
  }

  @PostMapping("/addFunction")
  public String addFunc(@Valid Function function, BindingResult result, Model model){
    if (result.hasErrors()){
      return "newfunction";
    }

    functionRepository.save(function);

    return "redirect:/index";
  }

  @GetMapping("/edit/{id}")
  public String showUpdate(@PathVariable("id") long id, Model model){
    Function function = functionRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("No such user with id " + id));
    model.addAttribute("function", function);

    return "update";
  }

  @PostMapping("/update/{id}")
  public String updateFunc(@PathVariable("id") long id, @Valid Function function, BindingResult result, Model model){
    if (result.hasErrors()){
      return "update";
    }

    functionRepository.save(function);

    return "redirect:/index";
  }

  @GetMapping("/delete/{id}")
  public String deleteFunc(@PathVariable("id") long id, Model model){
    Function function = functionRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("No such user with id " + id));

    functionRepository.delete(function);

    return "redirect:/index";
  }

  @GetMapping("/analyze/{id}")
  public String analyzeFunc(@PathVariable("id") long id, Model model){
    Function function = functionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No such user with id " + id));

    model.addAttribute("function", function);

    // TODO analyze
    // functionRepository.delete(function);

    return "analyze";

  }
}
