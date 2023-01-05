package com.example.myweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ContactRequestController {

    @Autowired
    private ContactRequestService service;

    @RequestMapping(value = "/ContactForm", method = RequestMethod.POST)
    public ModelAndView sendSurveyInfo(@ModelAttribute("request") ContactRequest request){
        service.save(request);
        return new ModelAndView("ContactForm");
    }

    @RequestMapping(value = "/ContactForm", method = RequestMethod.GET)
    public ModelAndView showSurveyPage() {
        return new ModelAndView("ContactForm");
    }

    @GetMapping("/All")
    private List getAllContactFormRequests() {
        return service.getAllContactRequests();
    }
}
