package cn.hjf.viewcodegenerator.xmlparser;

import java.io.File;
import java.util.List;

import cn.hjf.viewcodegenerator.model.Field;


public interface IFieldParser {

    public abstract List<Field> parse(File xmlFile);
}
