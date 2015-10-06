package cn.hjf.viewcodegenerator.model;

public class Target {

    private String name;
    private T target;

    public Target(String name, T target) {
        this.name = name;
        this.target = target;
    }

    public enum T {
        ACTIVITY, ADAPTER
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return name;
    }

}
