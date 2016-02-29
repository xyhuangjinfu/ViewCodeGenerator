package cn.hjf.viewcodegenerator.generator;

import java.io.File;

import cn.hjf.viewcodegenerator.model.WorkMode;
import cn.hjf.viewcodegenerator.writer.CodeWriter4Activity;
import cn.hjf.viewcodegenerator.writer.ICodeWriter;
import cn.hjf.viewcodegenerator.xmlparser.FieldParserFactory;
import cn.hjf.viewcodegenerator.xmlparser.IFieldParser;

public class CodeGenerator4Activity {
    
    private IFieldParser mFieldParser;
    private ICodeWriter mCodeWriter;
    
    public CodeGenerator4Activity() {
        mCodeWriter = new CodeWriter4Activity();
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
