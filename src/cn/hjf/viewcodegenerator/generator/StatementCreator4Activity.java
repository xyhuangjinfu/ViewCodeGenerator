package cn.hjf.viewcodegenerator.generator;

import cn.hjf.viewcodegenerator.model.Field;

public class StatementCreator4Activity implements IStatementCreator {

    private AbsFieldTransfer mFieldTransfer;

    public StatementCreator4Activity() {
        mFieldTransfer = new FieldTransfer4Activity();
    }

    /* (non-Javadoc)
     * @see cn.hjf.viewcodegenerator.generator.IStatementCreator#createDeclare(cn.hjf.viewcodegenerator.model.Field)
     */
    @Override
    public String createDeclare(Field field) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        sb.append("private");
        sb.append(" ");
        sb.append(field.getType());
        sb.append(" ");
        sb.append(mFieldTransfer.getNameById(field.getId()));
        sb.append(";");
        if (field.getAnnotation() != null) {
            sb.append(" ");
            sb.append("//");
            sb.append(field.getAnnotation());
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    /* (non-Javadoc)
     * @see cn.hjf.viewcodegenerator.generator.IStatementCreator#createFindViewById(cn.hjf.viewcodegenerator.model.Field)
     */
    @Override
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
