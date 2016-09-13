package cn.hjf.viewcodegenerator.generator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldTransfer4Activity extends AbsFieldTransfer {

    @Override
    public String getNameById(String id) {
        // 存放结果
        StringBuilder sb = new StringBuilder();
        // 得到id名称
        String name = id.substring(id.indexOf('/') + 1);
        // 得到id中的每个单词
        String[] words = name.split("_");
        // 拼接单词
        sb.append(words[0]);
        // 每个单词首字母大写
        for (int i = 0; i < words.length; i++) {
        	if (i == 0) {
        		continue;
        	}
            StringBuffer stringbf = new StringBuffer();
            Matcher matcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(words[i]);
            while (matcher.find()) {
                matcher.appendReplacement(stringbf, matcher.group(1).toUpperCase() + matcher.group(2).toLowerCase());
            }
            // 拼接单词
            sb.append(matcher.appendTail(stringbf).toString());

        }
        return sb.toString();
    }
}
