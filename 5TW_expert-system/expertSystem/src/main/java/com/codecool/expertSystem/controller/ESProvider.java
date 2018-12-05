package com.codecool.expertSystem.controller;

import com.codecool.expertSystem.exception.WrongAnswerException;
import com.codecool.expertSystem.fact.Fact;
import com.codecool.expertSystem.question.Question;
import com.codecool.expertSystem.view.UI;
import com.codecool.expertSystem.parse.*;
import java.util.*;

public class ESProvider {
    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> questionAnswer;
    private UI ui = new UI();

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void collectAnswers() throws WrongAnswerException {
        Iterator<Question> questionIterator = ruleParser.getRuleRepository().getIterator();
        questionAnswer = new HashMap<>();
        Question question;
        String input;

        while(questionIterator.hasNext()) {
            question = questionIterator.next();
            input = ui.userInput(question.getQuestion());
            questionAnswer.put(question.getId(), question.getEvaluatedAnswer(input));
        }
    }

    private boolean getAnswerByQuestion(String questionId) {
        return questionAnswer.get(questionId);
    }

    private boolean isFactChoosen(Fact fact) {
        for(String evalId : fact.getEvalIdSet()) {
            if (fact.getValueByEvalId(evalId) != this.getAnswerByQuestion(evalId)) {
                return false;
            }
        }
        return true;
    }

    public String evaluate() {
        Iterator<Fact> factIterator = factParser.getFactRepository().getIterator();
        Fact fact;

        while(factIterator.hasNext()) {
            fact = factIterator.next();
            if(isFactChoosen(fact)) {
                return fact.getDescription();
            }
        } 
        return null;    
    }
}

