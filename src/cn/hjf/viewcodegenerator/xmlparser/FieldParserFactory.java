package cn.hjf.viewcodegenerator.xmlparser;

import cn.hjf.viewcodegenerator.model.WorkMode;


public final class FieldParserFactory {

    private static FieldParserFactory sFieldParserFactory = new FieldParserFactory();
    private FieldParserDom4jByComment mFieldParserDom4jByComment;
    private FieldParserDom4j mFieldParserDom4j;
    
    public static FieldParserFactory getInstance() {
        return sFieldParserFactory;
    }
    
    public IFieldParser getFieldParser(WorkMode workMode) {
        IFieldParser fieldParser = null;
        switch (workMode.getMode()) {
        case BY_COMMENT:
            if (mFieldParserDom4jByComment == null) {
                mFieldParserDom4jByComment = new FieldParserDom4jByComment();
            }
            fieldParser = mFieldParserDom4jByComment;
            break;
        case BY_ID:
            if (mFieldParserDom4j == null) {
                mFieldParserDom4j = new FieldParserDom4j();
            }
            fieldParser = mFieldParserDom4j;
            break;
        default:
            break;
        }
        return fieldParser;
    }
}
