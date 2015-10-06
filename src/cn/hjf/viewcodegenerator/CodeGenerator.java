package cn.hjf.viewcodegenerator;

import java.io.File;

import cn.hjf.viewcodegenerator.model.WorkMode;
import cn.hjf.viewcodegenerator.xmlparser.FieldParserFactory;
import cn.hjf.viewcodegenerator.xmlparser.IFieldParser;

public class CodeGenerator {
    
    private IFieldParser mFieldParser;
    private CodeWriter mCodeWriter;
    
    public CodeGenerator() {
        mCodeWriter = new CodeWriter();
    }
    
    public boolean generate(String javaFilePath, String xmlFilePath, WorkMode workMode) {
        return generate(new File(javaFilePath), new File(xmlFilePath), workMode);
    }
    
    public boolean generate(File javaFile, File xmlFile, WorkMode workMode) {
        mFieldParser = FieldParserFactory.getInstance().getFieldParser(workMode);
        mCodeWriter.write(javaFile, mFieldParser.parse(xmlFile));
        return true;
    }

}
