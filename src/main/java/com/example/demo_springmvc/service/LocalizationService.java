package com.example.demo_springmvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;


import java.util.Locale;

@Service
public class LocalizationService {

    @Autowired
    private MessageSource messageSource;


    public String getMessage(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }
}
