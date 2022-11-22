package com.ptit.managecertificate.controller;

import com.ptit.managecertificate.entity.Profile;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.model.ProfileModel;
import com.ptit.managecertificate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UsernameController extends BaseController {

    @Autowired
    UserService userService;

	@RequestMapping(value = {"/userInfo", "/editProfile"}, method = RequestMethod.GET)
    public String profile(Model model){
        setUserLogin(model);
        model.addAttribute("profile", new ProfileModel()); 
        return "user/profile";
    }

    @RequestMapping(value = {"/userInfo", "/editProfile"}, method = RequestMethod.POST)
    public String editProfile(@ModelAttribute("profile") ProfileModel profile, Model model, Principal principal){
        setUserLogin(model);
        User user = userService.getUserByUserName(principal.getName());
        
        Profile p = new Profile();
        
       p.setFirstName(profile.getFirstName());
       p.setLastName(profile.getLastName());
       p.setMobileNumber(profile.getMobileNumber());
       user.setProfile(p);
        
        userService.updateUser(user);
        return "success";
    }

}
