package cn.hjf.viewcodegenerator;

public class FieldTransfer {

    public FieldTransfer() {

    }

    public String getNameById(String id) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        // 得到id名称
        String name = id.substring(id.indexOf('/') + 1);
        // 得到id中的每个单词
        String[] words = name.split("_");
        // 拼接成员变量名称头部
        sb.append("m");
        // 每个单词首字母大写
        for (String string : words) {
            char[] cs = string.toCharArray();
            cs[0] -= 32;
            // 拼接单词
            sb.append(String.valueOf(cs));
        }
        return sb.toString();
    }

    public String getIdForR(String id) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        // 得到id名称
        String name = id.substring(id.indexOf('/') + 1);
        sb.append("R.id.");
        sb.append(name);
        return sb.toString();
    }

}
