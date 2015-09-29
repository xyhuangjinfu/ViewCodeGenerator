package cn.hjf.viewcodegenerator;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class LayoutHandler extends DefaultHandler {
    private List<Field> mFields;

    @Override
    public void startDocument() throws SAXException {
        mFields = new ArrayList<Field>();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (attributes.getValue("android:id") != null) {
            mFields.add(new Field(qName, attributes.getValue("android:id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }
    
    public List<Field> getFields() {
        return mFields;
    }

}
