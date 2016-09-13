package cn.hjf.viewcodegenerator.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import cn.hjf.viewcodegenerator.generator.AbsCodeGenerator;
import cn.hjf.viewcodegenerator.generator.CodeGenerator4Activity;
import cn.hjf.viewcodegenerator.generator.CodeGenerator4Adapter;
import cn.hjf.viewcodegenerator.model.Target;
import cn.hjf.viewcodegenerator.model.WorkMode;
import cn.hjf.viewcodegenerator.os.OS;

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
    private JDialog mResultDialog;
    private JLabel mResultLabel;
    private JComboBox<WorkMode> mWorkModeComboBox;
    private JPanel mWorkModePanel;
    private JLabel mWorkModeLabel;
    private JComboBox<Target> mTargetComboBox;
    private JPanel mTargetPanel;
    private JLabel mTargetLabel;
    
    private AbsCodeGenerator mCodeGenerator4Activity;
    private AbsCodeGenerator mCodeGenerator4Adapter;
    private OS mOS;
    
    private String mLastPath;
    private WorkMode mWorkMode;
    private Target mTarget;
    
    public WorkUISwing() {
        mCodeGenerator4Activity = new CodeGenerator4Activity();
        mCodeGenerator4Adapter = new CodeGenerator4Adapter();
        mOS = new OS();
    }
    
    public void show() {
        mMainFrame = new JFrame("代码生成器 V0.2");
        mMainFrame.setLocation(500, 300);
        mMainFrame.setLayout(new GridLayout(5, 1));
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
        mWorkModePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mTargetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        mWorkModeComboBox = new JComboBox<WorkMode>();
        
        mWorkModeComboBox.addItem(new WorkMode("使用注释（根据注释和id生成代码）", WorkMode.Mode.BY_COMMENT));
        mWorkModeComboBox.addItem(new WorkMode("不使用注释 （根据id生成代码）", WorkMode.Mode.BY_ID));
        mWorkModeLabel = new JLabel("工作模式");
        mWorkMode = new WorkMode("使用注释（根据注释和id生成代码）", WorkMode.Mode.BY_COMMENT);
        
        mTargetComboBox = new JComboBox<Target>();
        mTargetComboBox.addItem(new Target("Activity", Target.T.ACTIVITY));
        mTargetComboBox.addItem(new Target("Adapter", Target.T.ADAPTER));
        mTargetLabel = new JLabel("生成目标");
        mTarget = new Target("Activity", Target.T.ACTIVITY);
        
        mWorkModePanel.add(mWorkModeLabel);
        mWorkModePanel.add(mWorkModeComboBox);
        
        mResultDialog = new JDialog(mMainFrame, "生成结果", true);
        mResultDialog.setSize(200, 100);
        mResultDialog.setLocation(600, 400);
        mResultLabel = new JLabel();
        mResultDialog.add(mResultLabel);
        
        mTargetPanel.add(mTargetLabel);
        mTargetPanel.add(mTargetComboBox);
        
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
        
        mMainFrame.add(mWorkModePanel);
        
        mMainFrame.add(mTargetPanel);
        
        mMainFrame.add(mGenerateButton);
        
        mLastPath = mOS.getMainDir();
        mJavaFileChooser = new JFileChooser(mLastPath);
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
        mXmlFileChooser = new JFileChooser(mLastPath);
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
                mLastPath = mJavaFileChooser.getSelectedFile().getParent();
                mXmlFileChooser.setCurrentDirectory(new File(mLastPath));
                mJavaFileChooser.setCurrentDirectory(new File(mLastPath));
                mMainFrame.pack();
            }
        });
        mChooseXmlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mXmlFileChooser.showOpenDialog(null);
                mXmlPathLabel.setText(mXmlFileChooser.getSelectedFile().getAbsolutePath());
                mLastPath = mXmlFileChooser.getSelectedFile().getParent();
                mXmlFileChooser.setCurrentDirectory(new File(mLastPath));
                mJavaFileChooser.setCurrentDirectory(new File(mLastPath));
                mMainFrame.pack();
            }
        });
        mGenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mJavaPathLabel.getText().endsWith(".java") && mXmlPathLabel.getText().endsWith(".xml")) {
                    if (mTarget.getTarget().equals(Target.T.ACTIVITY)) {
                        if (mCodeGenerator4Activity.generate(mJavaPathLabel.getText(), mXmlPathLabel.getText(), mWorkMode)) {
                            mResultLabel.setText("成功");
                            mResultDialog.setVisible(true);
                        } else {
                            mResultLabel.setText("失败");
                            mResultDialog.setVisible(true);
                        }
                        return;
                    }
                    if (mTarget.getTarget().equals(Target.T.ADAPTER)) {
                        if (mCodeGenerator4Adapter.generate(mJavaPathLabel.getText(), mXmlPathLabel.getText(), mWorkMode)) {
                            mResultLabel.setText("成功");
                            mResultDialog.setVisible(true);
                        } else {
                            mResultLabel.setText("失败");
                            mResultDialog.setVisible(true);
                        }
                        return;
                    }
                } else {
                    mResultLabel.setText("请选择文件");
                    mResultDialog.setVisible(true);
                }
            }
        });
        mWorkModeComboBox.addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mWorkMode = (WorkMode) e.getItem();
                }
            }
        });
        mTargetComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mTarget = (Target) e.getItem();
                }
            }
        });
        
        mMainFrame.pack();
        mMainFrame.setVisible(true);
        
    }

}
