package cn.hjf.viewcodegenerator;

public final class Field {

    private String type; // 类型，如 TextView
    private String id; // 完整id，如 @+id/tv_name, @id/tv_name
    private String name; // 成员变量名称, 如 mTvName
    private String annotation; // 字段的注释

    public Field() {
    }

    public Field(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public Field(String type, String id, String name) {
        this.type = type;
        this.id = id;
        this.name = name;
    }

    public Field(String type, String id, String name, String annotation) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.annotation = annotation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

}
