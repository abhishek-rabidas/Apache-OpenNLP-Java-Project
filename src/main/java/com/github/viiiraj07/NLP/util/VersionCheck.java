package com.github.viiiraj07.NLP.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VersionCheck {

    @Value("${nlp-app-version}")
    private String ver;

    @PostConstruct
    public String getVersion() {
        System.out.println("Version: " + ver);
        return ver;
    }

}
