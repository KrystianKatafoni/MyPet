package net.azurewebsites.mypet.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author Krystian Katafoni
 * @since 16.11.2017
 *
 */
@Slf4j
@Controller

public class IndexController {

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        log.debug("Request for IndexPage");
        return "index";
    }
}
