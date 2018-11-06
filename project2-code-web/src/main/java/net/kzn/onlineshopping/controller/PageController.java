package net.kzn.onlineshopping.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping(value ={"/","/home","/index","/index.jsp"})
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Home");
        mv.addObject("userClickHome",true);

        return mv;
    }

    @RequestMapping(value = "/account/register")
    public ModelAndView register()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title","Register");
        mv.addObject("userClickRegister",true);

        return mv;
    }

}

