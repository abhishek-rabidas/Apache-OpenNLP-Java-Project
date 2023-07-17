package com.github.viiiraj07.NLP.engine;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Service
public class TokenizerEngine {

    public String[] StringTokenize(String text) {

        try (InputStream modelIn = new FileInputStream("src/main/resources/models/en-token.bin")) {
            TokenizerModel model = new TokenizerModel(modelIn);
            Tokenizer tokenizer = new TokenizerME(model);
            return tokenizer.tokenize(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
