package com.ptit.managecertificate.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ptit.managecertificate.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ptit.managecertificate.entity.Profile;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.model.ProfileModel;
import com.ptit.managecertificate.model.UserModel;
import com.ptit.managecertificate.service.UserService;

@Controller
public class UsernameController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUser(Model model) {
        setUserLogin(model);
        model.addAttribute("user", new UserModel());
        model.addAttribute("listUsers", userService.listUser());
        return "admin/manageUser";
    }

    //For add and update person both
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserModel u, Model model) {
        setUserLogin(model);

        User user = new User();
        user.setId(u.getId());
        user.setPassword(u.getPassword());
        user.setUsername(u.getUsername());
        if (!userService.checkUserInDatabase(user)) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            Role r = new Role();
            r.setName(u.getType());
            Set<Role> s = new HashSet<Role>();
            s.add(r);
            user.setRoles(s);
            userService.saveUser(user);
        } else {
            User a = userService.getUserByUserName(user.getUsername());
            a.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
            Role r = new Role();
            r.setName(u.getType());
            Set<Role> s = new HashSet<Role>();
            s.add(r);
            a.setRoles(s);
            userService.updateUser(a);
        }
        model.addAttribute("user", new UserModel());
        return "redirect:/users";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        setUserLogin(model);

        UserModel um = new UserModel();
        User u = userService.getUserById(id);
        List<Role> list = new ArrayList<Role>(u.getRoles());
        um.setUsername(u.getUsername());
        um.setType(list.get(0).getName());
        um.setPassword(u.getPassword());

        model.addAttribute("user", um);
        model.addAttribute("listUsers", userService.listUser());
        return "admin/manageUser";
    }

    @RequestMapping(value = "/getDataForTable", method = RequestMethod.GET)
    @ResponseBody
    public List<UserModel> getDataForTable() {
        List<User> user = userService.listUser();
        List<UserModel> userModel = new ArrayList<UserModel>();
        for (User u : user) {
            UserModel um = new UserModel();
            um.setPassword(u.getPassword());
            um.setUsername(u.getUsername());
            um.setId(u.getId());
            userModel.add(um);
        }
        return userModel;
    }

    public String removeUser(@PathVariable("id") Long id, Model model) {
        setUserLogin(model);
        this.userService.deleteUser(userService.getUserById(id));
        return "redirect:/users";
    }


    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String profile(Model model) {
        setUserLogin(model);
        model.addAttribute("profile", new ProfileModel());
        return "user/profile";
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public String editProfile(@ModelAttribute("profile") ProfileModel profile, Model model, Principal principal) {
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
