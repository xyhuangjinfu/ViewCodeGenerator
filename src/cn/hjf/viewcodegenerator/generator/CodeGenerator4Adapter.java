package cn.hjf.viewcodegenerator.generator;

import java.io.File;

import cn.hjf.viewcodegenerator.model.WorkMode;
import cn.hjf.viewcodegenerator.writer.CodeWriter4Adapter;
import cn.hjf.viewcodegenerator.writer.ICodeWriter;
import cn.hjf.viewcodegenerator.xmlparser.FieldParserFactory;
import cn.hjf.viewcodegenerator.xmlparser.IFieldParser;

public class CodeGenerator4Adapter extends AbsCodeGenerator {
    
    private IFieldParser mFieldParser;
    private ICodeWriter mCodeWriter;
    
    public CodeGenerator4Adapter() {
        mCodeWriter = new CodeWriter4Adapter();
    }
    
    @Override
    public boolean generate(String javaFilePath, String xmlFilePath, WorkMode workMode) {
        return generate(new File(javaFilePath), new File(xmlFilePath), workMode);
    }
    
    @Override
    public boolean generate(File javaFile, File xmlFile, WorkMode workMode) {
        mFieldParser = FieldParserFactory.getInstance().getFieldParser(workMode);
        mCodeWriter.write(javaFile, mFieldParser.parse(xmlFile));
        return true;
    }

}
