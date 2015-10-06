package cn.hjf.viewcodegenerator.model;

public final class WorkMode {

    private String name; //UI展示名称
    private Mode mode; //工作模式

    public enum Mode {
        BY_COMMENT, // 根据 id 和 comment 生成代码
        BY_ID // 根据 id 生成代码
    }

    public WorkMode(String name, Mode mode) {
        this.name = name;
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return name;
    }

}
