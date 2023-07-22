package com.github.viiiraj07.NLP.engine;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Service
public class LanguageDetector {

    public String detectLanguage() {
        try (InputStream modelIn = new FileInputStream("src/main/resources/models/en-ner-person.bin")) {

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
