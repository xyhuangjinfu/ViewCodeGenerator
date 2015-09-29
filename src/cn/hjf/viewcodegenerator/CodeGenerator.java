package cn.hjf.viewcodegenerator;

import java.io.File;

public class CodeGenerator {
    
    private FieldParser mFieldParser;
    private CodeWriter mCodeWriter;
    
    public CodeGenerator() {
        mFieldParser = new FieldParser();
        mCodeWriter = new CodeWriter();
    }
    
    public boolean generate(String javaFilePath, String xmlFilePath) {
        return generate(new File(javaFilePath), new File(xmlFilePath));
    }
    
    public boolean generate(File javaFile, File xmlFile) {
        mCodeWriter.write(javaFile, mFieldParser.parse(xmlFile));
        return true;
    }

}
