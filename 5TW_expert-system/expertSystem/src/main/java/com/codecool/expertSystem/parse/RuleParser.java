package com.codecool.expertSystem.parse;


import com.codecool.expertSystem.question.RuleRepository;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.codecool.expertSystem.question.*;


public class RuleParser extends XMLParser{

    private RuleRepository ruleRepository;
    private String question;
    private String id;
    List<Value> values;
   

    public RuleParser() {
        loadXmlDocument("src/main/java/com/codecool/expertSystem/question/Question.xml");
        this.ruleRepository = new RuleRepository();
        this.parse();
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }

    public void parse() {
        
        try {
            getDoc().getDocumentElement().normalize();
            NodeList ruleList = getDoc().getElementsByTagName("Rule");

            for(int i=0; i<ruleList.getLength(); i++) {
                Element ruleElement = (Element) ruleList.item(i);

                NodeList questionList = ruleElement.getElementsByTagName("Question");
                NodeList selectionList = ruleElement.getElementsByTagName("Selection");
                NodeList answerList = ruleElement.getElementsByTagName("SingleValue");
                if(answerList.getLength() == 0) {
                    answerList = ruleElement.getElementsByTagName("MultipleValue");
                }

                Element questionElement = (Element) questionList.item(0);

                question = questionElement.getTextContent();
                id = ruleElement.getAttribute("id");
                Answer answer = new Answer();

                values = new ArrayList<>();
                for(int j=0; j<selectionList.getLength(); j++) {
                    Element selectionElement = (Element) selectionList.item(j);
                    Element answerElement = (Element) answerList.item(j);
                    

                    if(answerElement.getAttribute("value").contains(",")) {
                        List<String> params = Arrays.asList(answerElement.getAttribute("value").split(","));
                        boolean selectionType = Boolean.valueOf(selectionElement.getAttribute("value"));
                        values.add(new MultipleValue(params, selectionType));
                    } else {
                        boolean selectionType = Boolean.valueOf(selectionElement.getAttribute("value"));
                        values.add(new SingleValue(answerElement.getAttribute("value"), selectionType));
                    }
                
                }
                for(Value value : values)
                    answer.addValue(value);

                ruleRepository.addQuestion(new Question(id, question, answer));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    


}