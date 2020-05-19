package com.example.th_lexicon_2.controller;

import com.example.th_lexicon_2.data.AppUserDao;
import com.example.th_lexicon_2.dto.CreateAppUserForm;
import com.example.th_lexicon_2.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class AppUserController {

    private AppUserDao dao;

    @Autowired
    public AppUserController(AppUserDao dao) {
        this.dao = dao;
    }

    @GetMapping("/list")
    public String getListView(Model model){
        List<AppUser> appUserList = dao.findAll();
        model.addAttribute("appUserList",appUserList);
        return "list-view";
    }

    @GetMapping("/create")
    public String getCreateAppUserForm(Model model){
        model.addAttribute("form",new CreateAppUserForm());
        return "create-view";
    }

    @PostMapping("/create/process")
    public String postCreateAppUserForm(@Valid @ModelAttribute("form") CreateAppUserForm form, BindingResult bindingResult){

        if (dao.findByEmail(form.getEmail()).isPresent()){
            FieldError error = new FieldError(
                    "form",
                    "email",
                    "User with email "+form.getEmail()+" already exists"
            );
            bindingResult.addError(error);
        }

        if (bindingResult.hasErrors()){
            return "create-view";
        }

        AppUser newAppUser = new AppUser(
                form.getFirstName(),
                form.getLastName(),
                form.getEmail(),
                form.getAddress(),
                form.getPhoneNumber()
        );
        dao.create(newAppUser);
        return "redirect:/list";
    }

    @GetMapping("list/{id}")
    public String getAppUserDetails(@PathVariable int id, Model model){
        model.addAttribute("appUser",dao.findById(id));
        return "details";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id){
        dao.delete(id);
        return "redirect:/list";
    }
}
