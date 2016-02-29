package cn.hjf.viewcodegenerator.writer;

import java.io.File;
import java.util.List;

import cn.hjf.viewcodegenerator.model.Field;

public interface ICodeWriter {
    
    public boolean write(File javaFile, List<Field> fields);

}
