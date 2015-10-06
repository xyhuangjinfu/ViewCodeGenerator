package cn.hjf.viewcodegenerator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        for (String word : words) {
            StringBuffer stringbf = new StringBuffer();
            Matcher matcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(word);
            while (matcher.find()) {
                matcher.appendReplacement(stringbf, matcher.group(1).toUpperCase() + matcher.group(2).toLowerCase());
            }
            // 拼接单词
            sb.append(matcher.appendTail(stringbf).toString());

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
