package com.lc.dr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Time:   2016/11/3.
 * Author: lc_dream_real
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @ApiIgnore
    @RequestMapping(value = "index")
    public String index(ModelMap model){

        LOGGER.debug("debug level test");
        LOGGER.info("info level test");
        LOGGER.error("error level test");
        model.addAttribute("name", "Hello LC_DR");
        return "index";
    }
}
