package cn.hjf.viewcodegenerator;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WorkUI {

    private Frame mMainFrame;
    private Button mGenerateButton;
    private Button mChooseJavaButton;
    private Button mXmlJavaButton;
    private Label mJavaPathLabel;
    private Label mXmlPathLabel;
    private FileDialog mJavaFileDialog;
    private FileDialog mXmlFileDialog;
    private MyWin mMyWin;
    
    private CodeGenerator mCodeGenerator;
    private OS mOS;
    
    public WorkUI() {
        mCodeGenerator = new CodeGenerator();
        mOS = new OS();
    }

    public void show() {
        mMyWin = new MyWin();
        mMainFrame = new Frame("code generator");
        mMainFrame.setSize(500, 400);
        mMainFrame.setLocation(300, 200);
        mMainFrame.setLayout(new FlowLayout());

        mGenerateButton = new Button("Generator Code");
        mChooseJavaButton = new Button("Choose Java File");
        mXmlJavaButton = new Button("Choose Xml File");
        mJavaPathLabel = new Label("Java File Path");
        mXmlPathLabel = new Label("Xml File Path");

        mJavaFileDialog = new FileDialog(new Frame(), "Choose Java File", FileDialog.LOAD);
        mXmlFileDialog = new FileDialog(new Frame(), "Choose Xml File", FileDialog.LOAD);
        mJavaFileDialog.setDirectory(mOS.getMainDir());
        mXmlFileDialog.setDirectory(mOS.getMainDir());

        mMainFrame.add(mJavaPathLabel);
        mMainFrame.add(mChooseJavaButton);
        mMainFrame.add(mXmlPathLabel);

        mMainFrame.add(mXmlJavaButton);
        mMainFrame.add(mGenerateButton);

        mChooseJavaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mJavaFileDialog.setVisible(true);
                mJavaPathLabel.setText(mJavaFileDialog.getDirectory() + mJavaFileDialog.getFile());
            }
        });

        mXmlJavaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mXmlFileDialog.setVisible(true);
                mXmlPathLabel.setText(mXmlFileDialog.getDirectory() + mXmlFileDialog.getFile());
            }
        });

        mGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCodeGenerator.generate(mJavaPathLabel.getText(), mXmlPathLabel.getText());
            }
        });

        mMainFrame.addWindowListener(mMyWin);

        mMainFrame.setVisible(true);
    }

    // 因为接口WindowLinstener中的所有方法都被子类 WindowAdapter实现了,.
    // 并且覆盖了其中的所有方法,那么我们只能继承 WindowAdapter 覆盖我们的方法即可
    private class MyWin extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        @Override
        public void windowActivated(WindowEvent e) {
            // 每次获得焦点 就会触发
        }

        @Override
        public void windowOpened(WindowEvent e) {
        }

    }
}
