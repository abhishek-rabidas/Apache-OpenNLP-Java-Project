package com.github.viiiraj07.NLP.engine;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Service
public class NamingEngine {

    private final TokenizerEngine tokenizerEngine = new TokenizerEngine();

    public ArrayList<String> getNamedPersonEntities(String text) {
        try (InputStream modelIn = new FileInputStream("src/main/resources/models/en-ner-person.bin")) {
            TokenNameFinderModel tokenNameFinderModel = new TokenNameFinderModel(modelIn);
            NameFinderME nameFinderME = new NameFinderME(tokenNameFinderModel);
            Span[] spans = nameFinderME.find(tokenizerEngine.stringTokenize(text));
            ArrayList<String> names = new ArrayList<>();
            for (Span span : spans) {
                names.add(span.toString());
            }
            return names;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
