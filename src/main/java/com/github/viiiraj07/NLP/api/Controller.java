package com.github.viiiraj07.NLP.api;

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

    @PostMapping("/tokenize")
    public ResponseEntity<?> TokenizeString(@RequestParam("text") String text) {

        return ResponseEntity.ok(tokenizerEngine.StringTokenize(text));
    }


}
