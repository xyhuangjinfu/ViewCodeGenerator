package cn.hjf.viewcodegenerator.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import cn.hjf.viewcodegenerator.generator.StatementCreator4Adapter;
import cn.hjf.viewcodegenerator.model.Field;

public class CodeWriter4Adapter {

    private StatementCreator4Adapter mStatementCreator;

    public CodeWriter4Adapter() {
        mStatementCreator = new StatementCreator4Adapter();
    }

    public boolean write(File javaFile, List<Field> fields) {
        boolean result = true;
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(javaFile, true), "UTF-8");
            
            osw.write("//自动生成代码");
            osw.write("\n");

            osw.write("private class ViewHolder {");
            osw.write("\n");
            for (Field field : fields) {
                osw.write(mStatementCreator.createDeclare(field));
                osw.write("\n");
            }
            osw.write("}");
            osw.write("\n");
            for (Field field : fields) {
                osw.write(mStatementCreator.createFindViewById(field));
                osw.write("\n");
            }
            osw.flush();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
