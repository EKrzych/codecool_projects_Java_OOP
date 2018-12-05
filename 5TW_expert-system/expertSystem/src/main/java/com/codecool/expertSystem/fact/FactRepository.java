package com.codecool.expertSystem.fact;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class FactRepository {

    private List<Fact> factList;


    public FactRepository() {
        this.factList = new ArrayList<>();
    }

    public void addFact(Fact fact) {
        factList.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return factList.iterator();
    }
}