package com.codecool.expertSystem.question;

import java.util.List;

public abstract class Value {
    private boolean selectionType;

    public abstract List<String> getInputPattern();

    public boolean getSelectionType(){
        return this.selectionType;
    }

    public void setSelectionType(boolean selectionType) {
         this.selectionType = selectionType;
    }
}