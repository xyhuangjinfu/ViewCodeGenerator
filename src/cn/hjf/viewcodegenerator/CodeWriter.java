package cn.hjf.viewcodegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class CodeWriter {

    private StatementCreator mStatementCreator;

    public CodeWriter() {
        mStatementCreator = new StatementCreator();
    }

    public boolean write(File javaFile, List<Field> fields) {
        boolean result = true;
        try {
            FileWriter fw = new FileWriter(javaFile, true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write("//auto generation code");
            writer.newLine();

            for (Field field : fields) {
                writer.write(mStatementCreator.createDeclare(field));
                writer.newLine();
            }
            for (Field field : fields) {
                writer.write(mStatementCreator.createFindViewById(field));
                writer.newLine();
            }
            writer.flush();
            writer.close();
            fw.close();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }

        return result;
    }

}
