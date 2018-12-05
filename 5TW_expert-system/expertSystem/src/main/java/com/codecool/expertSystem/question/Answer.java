package com.codecool.expertSystem.question;
import com.codecool.expertSystem.exception.WrongAnswerException;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

public class Answer {
    
    private List<Value> valueList;

    public Answer() {
        this.valueList = new ArrayList<>();
    }

    
    public void addValue(Value value) {
        this.valueList.add(value);
    }
    
    boolean evaluateAnswerByInput(String userInput) throws WrongAnswerException {
        for(Value element : this.valueList) {
            for(String value : element.getInputPattern()) {
                if(userInput.equals(value)) {
                    return element.getSelectionType();
                }
            }
        }
        throw new WrongAnswerException("Wrong input !!");
    }
}