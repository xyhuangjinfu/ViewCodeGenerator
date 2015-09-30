package cn.hjf.viewcodegenerator;

import java.util.Properties;

public class OS {

    public String getMainDir() {
        String dir = null;
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        // windows操作系统
        if (os.startsWith("win") || os.startsWith("Win")) {
            dir = "C:";
        } 
        // Linux
        else if (os.startsWith("Lin") || os.startsWith("lin")) {
            dir = "/home";
        }
        return dir;
    }

}
