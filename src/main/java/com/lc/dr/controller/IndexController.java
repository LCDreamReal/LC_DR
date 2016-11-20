package com.lc.dr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Time:   2016/11/3.
 * Author: lc_dream_real
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    @RequestMapping(value = "index")
    public String index(ModelMap model){

        model.addAttribute("name", "Hello LC_DR");
        return "index";
    }
}
