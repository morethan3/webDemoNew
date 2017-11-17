package com.sgm.b2c.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/16.
 */
@RestController
public class ErrorPageController {
    @GetMapping("/500")
    public ModelAndView get500Page(){
        return new ModelAndView("500");
    }
    @GetMapping("/400")
    public ModelAndView get400Page(){
        return new ModelAndView("400");
    }
    @GetMapping("/404")
    public ModelAndView get404Page(){
        return new ModelAndView("404");
    }
}
