package com.github.viiiraj07.NLP.api;

import com.github.viiiraj07.NLP.engine.LanguageDetectorEngine;
import com.github.viiiraj07.NLP.engine.NamingEngine;
import com.github.viiiraj07.NLP.engine.TokenizerEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RestController
public class Controller {

    @Autowired
    private TokenizerEngine tokenizerEngine;

    @Autowired
    private NamingEngine namingEngine;

    @Autowired
    private LanguageDetectorEngine languageDetectorEngine;

    /**
     * <h2>Tokenizer</h2>
     * <p>The <b>OpenNLP</b> Tokenizers segment an input character sequence into tokens. Tokens are usually words, punctuation, numbers, etc.</p>
     */

    @PostMapping("/tokenize")
    public ResponseEntity<?> TokenizeString(@RequestParam("text") String text) {
        return ResponseEntity.ok(tokenizerEngine.stringTokenize(text));
    }


    /**
     * <h2>Named Entity Recognition</h2>
     * <p>The Name Finder can detect named entities and numbers in text. </p>
     */

    @PostMapping("/getNames")
    public ResponseEntity<?> getNamedEntities(@RequestParam("text") String text) {
        return ResponseEntity.ok(namingEngine.getNamedPersonEntities(text));
    }

    @PostMapping("/getLocations")
    public ResponseEntity<?> getLocations(@RequestParam("text") String text) {
        return ResponseEntity.ok(namingEngine.getNamedLocationEntities(text));
    }

    /**
     * <h2>Language Detector</h2>
     * <p>The Name Finder can detect named entities and numbers in text. </p>
     */

    @PostMapping("/detectLanguage")
    public ResponseEntity<?> detectLanguage(@RequestParam("text") String text) {
        return ResponseEntity.ok(languageDetectorEngine.detectLanguage(text));
    }

}
