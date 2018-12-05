package com.codecool.expertSystem.question;

import java.util.*;

public class MultipleValue extends Value {
    private List<String> pattern;
    
    public MultipleValue(List<String> params, boolean selectionType) {
        this.pattern = new ArrayList<>();
        this.pattern.addAll(params);
        this.setSelectionType(selectionType);
    }

    public List<String> getInputPattern() {
        return pattern;
    }
}