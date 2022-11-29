package com.ptit.managecertificate.controller;

import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.model.UserModel;
import com.ptit.managecertificate.service.UserService;
import com.ptit.managecertificate.utils.JsonDataGrid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController{
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String listUser(Model model) {
        model.addAttribute("user", new UserModel());
        model.addAttribute("listUsers", userService.listUser());
        return "authorize/manageUser";
    }

    //For add and update person both
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserModel u, Model model) {

        User user = new User();
        user.setId(u.getId());
        user.setPassword(u.getPassword());
        user.setUsername(u.getUsername());
        if (!userService.checkUserInDatabase(user)) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setRole(u.getRole());
            userService.saveUser(user);
        } else {
            User a = userService.getUserByUserName(user.getUsername());
            a.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
            a.setRole(u.getRole());
            userService.updateUser(a);
        }
        model.addAttribute("user", new UserModel());
        return "redirect:/user/list";
    }

    @RequestMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {

        UserModel um = new UserModel();
        User u = userService.getUserById(id);
        um.setUsername(u.getUsername());
        um.setRole(u.getRole());
        um.setPassword(u.getPassword());

        model.addAttribute("user", um);
        model.addAttribute("listUsers", userService.listUser());
        return "authorize/manageUser";
    }

    @RequestMapping(value = "/getDataForTable", method = RequestMethod.POST)
    @ResponseBody
    public JsonDataGrid getDataForTable(HttpServletRequest request) {
        Integer pagenum = 0;
        if (null != request.getParameter("pagenum"))
        {
            try
            {
                pagenum = Integer.parseInt(request.getParameter("pagenum"));
            }
            catch (NumberFormatException nfe) {}
            {
            }
        }

        Integer pagesize = 1000;
        if (null != request.getParameter("pagesize"))
        {
            try
            {
                pagesize = Integer.parseInt(request.getParameter("pagesize"));
            }
            catch (NumberFormatException nfe) {}
            {
            }
        }
        // Integer start = pagesize * pagenum;
        JsonDataGrid data = new JsonDataGrid();
        data.setTotalRecords(userService.getTotalUser());
        data.setCurPage((long)pagenum);
        List<User> user = userService.listUser(PageRequest.of(pagenum,pagesize));
        List<UserModel> userModel = new ArrayList<UserModel>();
        for (User u : user) {
            UserModel um = new UserModel();
            um.setPassword(u.getPassword());
            um.setUsername(u.getUsername());
            um.setId(u.getId());
            userModel.add(um);
        }
        logger.info(userModel);
        data.setData(userModel);
        return data;
    }

    @RequestMapping(value = "/updateDataForTable", method = RequestMethod.POST)
    public @ResponseBody String updateDataForTable(@RequestBody UserModel userModel) {
        User u = userService.getUserById(userModel.getId());
        u.setUsername(userModel.getUsername());
        u.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        userService.updateUser(u);
        return "Update Successfully";
    }
    @RequestMapping("/user/remove/{id}")
    public String removeUser(@PathVariable("id") Long id, Model model) {
        this.userService.deleteUser(userService.getUserById(id));
        return "redirect:/user/list";
    }

}
