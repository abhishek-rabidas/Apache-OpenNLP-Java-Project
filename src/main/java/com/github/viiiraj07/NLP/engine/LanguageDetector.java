package com.github.viiiraj07.NLP.engine;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Service
public class LanguageDetector {

    public String detectLanguage(String inputText) {
        try (InputStream modelIn = new FileInputStream("src/main/resources/models/langdetect-183.bin")) {
            LanguageDetectorModel m = new LanguageDetectorModel(modelIn);
            LanguageDetectorME myCategorize = new LanguageDetectorME(m);
            Language bestLanguage = myCategorize.predictLanguage(inputText);
            return bestLanguage.getLang();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}