package com.giorgi.testcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.giorgi.testcrud.models.UserModel;
import com.giorgi.testcrud.services.UserRepository;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {

  @Autowired
  UserRepository userRepo;

  @GetMapping("/")
  public String homePage(Model model) {

    model.addAttribute("users", userRepo.findAll());
    return "index";
  }

  @GetMapping("new")
  public String newUserPage(Model model) {

    long userCount = userRepo.count();
    String userCountString = Long.toString(userCount);
    System.out.println("XDXDXDXDXDXDXDXDXDXDXDXDXD: " + userCountString);
    model.addAttribute("user", new UserModel(userCountString, "", "", ""));
    return "new_user";
  }

  @PostMapping("new")
  public String addNewUser(@Valid @ModelAttribute UserModel user, BindingResult result, Model model) {

    model.addAttribute("user", user);

    if(result.hasErrors()){
      return "new_user";
    }

    userRepo.save(user);
    return "redirect:/";
  }

  @GetMapping("edit")
  public String editUserPage(@RequestParam String id, Model model){

    userRepo.findById(id).ifPresent(u -> model.addAttribute("user", u));
    return "edit_user";
  }

  @PostMapping("edit")
  public String editUser(@Valid @ModelAttribute UserModel user, BindingResult result, Model model) {

    model.addAttribute("user", user);

    if(result.hasErrors()){
      return "edit_user";
    }

    userRepo.save(user);
    return "redirect:/";
  }

  @GetMapping("delete")
  public String getMethodName(@RequestParam String id) {

    userRepo.deleteById(id);
    return "redirect:/";
  }
  
  
}
