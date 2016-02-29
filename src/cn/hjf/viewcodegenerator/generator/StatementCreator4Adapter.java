package cn.hjf.viewcodegenerator.generator;

import cn.hjf.viewcodegenerator.model.Field;

public class StatementCreator4Adapter {

    private AbsFieldTransfer mFieldTransfer;

    public StatementCreator4Adapter() {
        mFieldTransfer = new FieldTransfer4Adapter();
    }

    public String createDeclare(Field field) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
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

    public String createFindViewById(Field field) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        sb.append("viewHolder.");
        sb.append(mFieldTransfer.getNameById(field.getId()));
        sb.append(" = ");
        sb.append("(");
        sb.append(field.getType());
        sb.append(")");
        sb.append(" ");
        sb.append("convertView.findViewById");
        sb.append("(");
        sb.append(mFieldTransfer.getIdForR(field.getId()));
        sb.append(")");
        sb.append(";");
        System.out.println(sb.toString());
        return sb.toString();
    }

}
