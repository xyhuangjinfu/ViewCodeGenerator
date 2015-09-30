package cn.hjf.viewcodegenerator;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class WorkUISwing {
    
    private JFrame mMainFrame;
    private JButton mGenerateButton;
    private JButton mChooseJavaButton;
    private JButton mChooseXmlButton;
    private JLabel mJavaPathLabel;
    private JLabel mXmlPathLabel;
    private JFileChooser mJavaFileChooser;
    private JFileChooser mXmlFileChooser;
    private JPanel mJavaPanel;
    private JPanel mXmlPanel;
    private JPanel mGeneratorPanel;
    
    private CodeGenerator mCodeGenerator;
    private OS mOS;
    
    public WorkUISwing() {
        mCodeGenerator = new CodeGenerator();
        mOS = new OS();
    }
    
    public void show() {
        mMainFrame = new JFrame("代码生成器");
        mMainFrame.setLocation(400, 400);
        mMainFrame.setLayout(new GridLayout(3, 1));
        mMainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            @Override
            public void windowClosed(WindowEvent e) {
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
        });
        
        mJavaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mXmlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        mGenerateButton = new JButton("生成代码");
        mGenerateButton.setSize(100, 100);
        mChooseJavaButton = new JButton("选择Java文件(Activity等)");
        mChooseJavaButton.setSize(100, 100);
        mChooseXmlButton = new JButton("选择Xml文件(布局文件)");
        mChooseXmlButton.setSize(100, 100);
        
        mJavaPathLabel = new JLabel("Java文件路径");
        mXmlPathLabel = new JLabel("Xml文件路径");
        
        mJavaPanel.add(mChooseJavaButton);
        mJavaPanel.add(mJavaPathLabel);
        
        mMainFrame.add(mJavaPanel);
        
        mXmlPanel.add(mChooseXmlButton);
        mXmlPanel.add(mXmlPathLabel);
        
        mMainFrame.add(mXmlPanel);
        
        mMainFrame.add(mGenerateButton);
        
        
        mJavaFileChooser = new JFileChooser(mOS.getMainDir());
        mJavaFileChooser.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return null;
            }
            @Override
            public boolean accept(File f) {
                if (f.isDirectory())return true;
                return f.getName().endsWith(".java");
            }
        });
        mXmlFileChooser = new JFileChooser(mOS.getMainDir());
        mXmlFileChooser.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return null;
            }
            @Override
            public boolean accept(File f) {
                if (f.isDirectory())return true;
                return f.getName().endsWith(".xml");
            }
        });
        
        mChooseJavaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mJavaFileChooser.showOpenDialog(null);
                mJavaPathLabel.setText(mJavaFileChooser.getSelectedFile().getAbsolutePath());
                mMainFrame.pack();
            }
        });
        mChooseXmlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mXmlFileChooser.showOpenDialog(null);
                mXmlPathLabel.setText(mXmlFileChooser.getSelectedFile().getAbsolutePath());
                mMainFrame.pack();
            }
        });
        mGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mJavaPathLabel.getText().endsWith(".java") && mXmlPathLabel.getText().endsWith(".xml")) {
                    mCodeGenerator.generate(mJavaPathLabel.getText(), mXmlPathLabel.getText());
                }
            }
        });
        
        mMainFrame.pack();
        mMainFrame.setVisible(true);
        
    }

}
