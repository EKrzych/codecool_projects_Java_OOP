package com.codecool.expertSystem.parse;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public abstract class XMLParser {

    private File fXmlFile;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;

    public abstract void parse();

    public void loadXmlDocument(String xmlPath) {
    	try {
            fXmlFile = new File(xmlPath);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document getDoc() {
        return doc;
    }
}
