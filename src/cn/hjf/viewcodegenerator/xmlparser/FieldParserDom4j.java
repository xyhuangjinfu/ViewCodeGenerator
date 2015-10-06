package cn.hjf.viewcodegenerator.xmlparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.hjf.viewcodegenerator.model.Field;

/**
 * 不使用注释(Comment)过滤，生成的Field列表，有 android:id 就生成Field
 * @author huangjinfu
 *
 */
public class FieldParserDom4j implements IFieldParser {
    
    private Queue<Node> mNodeQueue = new LinkedList<Node>();
    private List<Field> mFields = new ArrayList<Field>();

    /**
     * 解析布局文件，返回需要生成代码的Field列表
     * @param xmlFile
     * @return
     */
    @Override
    public List<Field> parse(File xmlFile) {
        mFields.clear();
        FileInputStream fileinput = null;
        Document document = null;
        try {
            fileinput = new FileInputStream(xmlFile.getAbsolutePath());
            int count = fileinput.available();
            byte[] cache = new byte[count];
            fileinput.read(cache);
            String xmlDocument = new String(cache, "UTF-8");
            document = DocumentHelper.parseText(xmlDocument);
            Element rootElement = document.getRootElement();
            listNodes(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileinput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return mFields;
    }

    /**
     * 层序输出节点
     * @param node
     */
    public void listNodes(Node node) {
        //队列为空，结束遍历
        if (node == null) {
            return;
        }
        //输出节点，如果节点有子节点，加入输出队列
        if (node instanceof Comment) {
        } else if (node instanceof Element) {
            Element e = (Element)node;
            //有id，currentComment有效，生成变量
            if (e.attributeValue("id") != null) {
                    Field field = new Field();
                    field.setType(e.getName());
                    field.setId(e.attributeValue("id"));
                    mFields.add(field);
                    //currentComment使用完毕，置为无效
            } else {
                //没有id，currentComment无效
            }
            //把子节点加入到遍历队列
            for (int i = 0, size = e.nodeCount(); i < size; i++) {
                mNodeQueue.add(e.node(i));
            }
        }
        //访问下一个节点
        listNodes(mNodeQueue.poll());

    }

}
