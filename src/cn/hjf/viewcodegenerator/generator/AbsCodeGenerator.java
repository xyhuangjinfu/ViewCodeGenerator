package cn.hjf.viewcodegenerator.generator;

import java.io.File;

import cn.hjf.viewcodegenerator.model.WorkMode;
import cn.hjf.viewcodegenerator.writer.ICodeWriter;
import cn.hjf.viewcodegenerator.xmlparser.FieldParserFactory;
import cn.hjf.viewcodegenerator.xmlparser.IFieldParser;

public abstract class AbsCodeGenerator {
    
    private IFieldParser mFieldParser;
    private ICodeWriter mCodeWriter;
    
    public abstract boolean generate(String javaFilePath, String xmlFilePath, WorkMode workMode);
    
    public abstract boolean generate(File javaFile, File xmlFile, WorkMode workMode);

}
