package com.codecool.expertSystem.parse;

import com.codecool.expertSystem.fact.Fact;
import com.codecool.expertSystem.fact.FactRepository;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FactParser extends XMLParser {

    private FactRepository factRepository;

    public FactParser() {
        super.loadXmlDocument("src/main/java/com/codecool/expertSystem/fact/Fact.xml");
        this.factRepository = new FactRepository();    
        this.parse();
    }

    public FactRepository getFactRepository() {
        return this.factRepository;
    }

    public void parse() {
        NodeList factList = getDoc().getElementsByTagName("Fact");
        NodeList descriptionList = getDoc().getElementsByTagName("Description");
        Node factNode;
        Node descriptionNode;
        Element factElement;
        Element descriptionElemet;
        NodeList evalList;
        String factID;
        String descriptionID;
        Fact fact;
        
        for (int i = 0; i < factList.getLength(); i++) {

            factNode = factList.item(i);
            descriptionNode = descriptionList.item(i);
            factElement = (Element) factNode;
            descriptionElemet = (Element) descriptionNode;
            evalList = factElement.getElementsByTagName("Eval");
            factID = factElement.getAttribute("id");
            descriptionID = descriptionElemet.getAttribute("value");
            fact = new Fact(factID, descriptionID);
            Node evalNode;
            Element evalElement;

            for (int x = 0; x < evalList.getLength(); x++) {
                evalNode = evalList.item(x);
                evalElement = (Element) evalNode;
                fact.setFactValueByEvalId(evalElement.getAttribute("id"),
                            Boolean.valueOf(evalElement.getTextContent()));
            }
            factRepository.addFact(fact);
        }
    }
}
