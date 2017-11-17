package com.sgm.b2c.controller;

import com.sgm.b2c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Li
 * @date 2017/8/8
 */
@RestController
public class ApplicationController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('admin')")
    @GetMapping(value = "/h")
    public ModelAndView showIndex(Model model) {
        return new ModelAndView("index","user",userService.selectAllUser());
    }

}
