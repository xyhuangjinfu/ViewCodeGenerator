package cn.hjf.viewcodegenerator.generator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldTransfer4Adapter {

    public FieldTransfer4Adapter() {

    }

    public String getNameById(String id) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        // 得到id名称
        String name = id.substring(id.indexOf('/') + 1);
        // 得到id中的每个单词
        String[] words = name.split("_");
        // 格式化变量名
        int length = words.length;
        if (length == 1) {
            
        } else {
            for (int i = 1; i < length; i++) {
                StringBuffer stringbf = new StringBuffer();
                Matcher matcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(words[i]);
                while (matcher.find()) {
                    matcher.appendReplacement(stringbf, matcher.group(1).toUpperCase() + matcher.group(2).toLowerCase());
                }
                // 拼接单词
                sb.append(matcher.appendTail(stringbf).toString());
            }
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
