package cn.hjf.viewcodegenerator.generator;

public abstract class AbsFieldTransfer {

    /**
     * 获取字段生成的名称
     * 
     * @param id
     *            从布局文件中解析出来的控件id
     * @return 不同地方使用的不同格式的字段名称
     */
    public abstract String getNameById(String id);

    /**
     * 获取字段在R文件中使用的id名称
     * 
     * @param id
     *            从布局文件中解析出来的控件id
     * @return R文件中的字段名称
     */
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
