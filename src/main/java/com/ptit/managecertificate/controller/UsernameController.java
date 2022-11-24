package com.ptit.managecertificate.controller;

import com.ptit.managecertificate.entity.Profile;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.model.ProfileModel;
import com.ptit.managecertificate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UsernameController extends BaseController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUser());
		return "admin/manageUser";
	}
	
	//For add and update person both
	@RequestMapping(value= "/users/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u, Model model){
		if(u.getId() == null){
			//new person, add it
			this.userService.saveUser(u);
		}else{
			//existing person, call update
			model.addAttribute("messenge","User exist!");
		}
		return "redirect:/admin/manageUser";
	}

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") Long id){
		this.userService.deleteUser(userService.getUserById(id));
		return "redirect:/admin/manageUser";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") Long id, Model model){
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("listUsers", this.userService.listUser());
		return "admin/manageUser";
	}


	@RequestMapping(value = {"/editProfile"}, method = RequestMethod.GET)
    public String profile(Model model){
        setUserLogin(model);
        model.addAttribute("profile", new ProfileModel()); 
        return "user/profile";
    }

    @RequestMapping(value = {"/editProfile"}, method = RequestMethod.POST)
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
