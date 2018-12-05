package com.codecool.expertSystem;

import com.codecool.expertSystem.controller.ESProvider;
import com.codecool.expertSystem.exception.WrongAnswerException;
import com.codecool.expertSystem.parse.FactParser;
import com.codecool.expertSystem.parse.RuleParser;
import com.codecool.expertSystem.view.UI;

class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();
        ESProvider esProvider = new ESProvider(factParser, ruleParser);

        ui.clearScreen();
        try {
            esProvider.collectAnswers();
            ui.display(esProvider.evaluate());
        } catch(WrongAnswerException e) {
            System.err.println(e);
        }
    }
}