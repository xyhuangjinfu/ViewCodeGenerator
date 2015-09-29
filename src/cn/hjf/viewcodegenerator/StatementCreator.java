package cn.hjf.viewcodegenerator;

public class StatementCreator {

    private FieldTransfer mFieldTransfer;

    public StatementCreator() {
        mFieldTransfer = new FieldTransfer();
    }

    public String createDeclare(Field field) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        sb.append("private");
        sb.append(" ");
        sb.append(field.getType());
        sb.append(" ");
        sb.append(mFieldTransfer.getNameById(field.getId()));
        sb.append(";");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String createFindViewById(Field field) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        sb.append(mFieldTransfer.getNameById(field.getId()));
        sb.append(" = ");
        sb.append("(");
        sb.append(field.getType());
        sb.append(")");
        sb.append(" ");
        sb.append("findViewById");
        sb.append("(");
        sb.append(mFieldTransfer.getIdForR(field.getId()));
        sb.append(")");
        sb.append(";");
        System.out.println(sb.toString());
        return sb.toString();
    }

}
