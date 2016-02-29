package cn.hjf.viewcodegenerator.generator;

import cn.hjf.viewcodegenerator.model.Field;

public interface IStatementCreator {

    public abstract String createDeclare(Field field);

    public abstract String createFindViewById(Field field);

}