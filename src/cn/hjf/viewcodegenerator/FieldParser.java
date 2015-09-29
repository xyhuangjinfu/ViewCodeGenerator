package cn.hjf.viewcodegenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class FieldParser {
    
    private LayoutHandler mLayoutHandler;
    private SAXParser mSAXParser;
    
    public FieldParser() {
        mLayoutHandler = new LayoutHandler();
        try {
            mSAXParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    
    public List<Field> parse(File xmlFile) {
        List<Field> fields = null;
        try {
            mSAXParser.parse(xmlFile, mLayoutHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mLayoutHandler.getFields();
    }
}
