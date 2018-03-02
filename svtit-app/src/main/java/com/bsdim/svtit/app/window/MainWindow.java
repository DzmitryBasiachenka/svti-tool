package com.bsdim.svtit.app.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.bsdim.svtit.app.window.video.WorkspaceWindow;

public class MainWindow extends JFrame {
    private static final String MAIN_WINDOW = "Главное окно";
    private static final String IN_PROGRESS = "In progress...";
    private static final String VIDEO_ICON_PNG = "icons/videoIcon.png";
    private static final String VIDEO_CONTROL = "<html><font size=4>Видеонаблюдение</font></html>";
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    public MainWindow() {
        super(MAIN_WINDOW);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        getContentPane().add(initComponents());
        setVisible(true);
    }

    private JComponent initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 40, 20));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        mainPanel.add(initButtonComponent(), BorderLayout.CENTER);
        mainPanel.add(new JButton(IN_PROGRESS));
        mainPanel.add(new JButton(IN_PROGRESS));
        mainPanel.add(new JButton(IN_PROGRESS));

        return mainPanel;
    }

    private JComponent initButtonComponent() {
        JButton video = new JButton(VIDEO_CONTROL);
        video.setIcon(new ImageIcon(VIDEO_ICON_PNG));
        video.setVerticalTextPosition(SwingConstants.BOTTOM);
        video.setHorizontalTextPosition(SwingConstants.CENTER);
        video.setIconTextGap(-20);
        video.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkspaceWindow();
                dispose();
            }
        });
        return video;
    }
}
