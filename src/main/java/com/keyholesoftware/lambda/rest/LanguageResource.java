package com.keyholesoftware.lambda.rest;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.keyholesoftware.lambda.logging.LogUtil;
import com.keyholesoftware.lambda.logging.LoggingExample;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.keyholesoftware.lambda.model.Language;

@RestController
public class LanguageResource {

    Logger logger = LogUtil.getInstance();

    @RequestMapping(path = "/languages", method = RequestMethod.GET)
    public List<Language> listLambdaLanguages() {

        logger.severe("SEVRE-LOG");
        return Arrays.asList(new Language("node"), new Language("java"), new Language("python"));
    }

}