package com.github.viiiraj07.NLP.api;

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

    /**
    <h2>Tokenizer</h2>
     <p>The <b>OpenNLP</b> Tokenizers segment an input character sequence into tokens. Tokens are usually words, punctuation, numbers, etc.</p>
     */

    @PostMapping("/tokenize")
    public ResponseEntity<?> TokenizeString(@RequestParam("text") String text) {
        return ResponseEntity.ok(tokenizerEngine.stringTokenize(text));
    }

    @PostMapping("/getNames")
    public ResponseEntity<?> getNamedEntities(@RequestParam("text") String text) {
        return ResponseEntity.ok(namingEngine.getNamedPersonEntities(text));
    }

    @PostMapping("/getLocations")
    public ResponseEntity<?> getLocations(@RequestParam("text") String text) {
        return ResponseEntity.ok(namingEngine.getNamedLocationEntities(text));
    }


}
