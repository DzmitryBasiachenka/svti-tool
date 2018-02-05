package com.bsdim.svtit.app.window;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.bsdim.svtit.app.component.MenuBar;
import com.bsdim.svtit.app.video.VideoSystemFacade;
import com.bsdim.svtit.domain.video.VideoSystem;

public class WorkspaceWindow extends JFrame {
    private static final String WORKSPACE_WINDOW = "Рабочая область";
    private static final String VIDEO_CONTROL = "Видеонаблюдение";
    private static final String EXIT_BUTTON = "Выход";
    private static final String CREATE_BUTTON = "Добавить";
    private static final String LIST_VIDEO_SYSTEMS = "Список видео систем";
    private static final String INFORMATION = "Информация";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private JList<VideoSystem> listNames = new JList<>();
    private VideoSystemFacade facade = new VideoSystemFacade();
    private JTextArea info;

    public WorkspaceWindow() {
        super(WORKSPACE_WINDOW);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setJMenuBar(new MenuBar().initMenuBarComponent());

        add(initComponents());
        setVisible(true);
    }

    private JPanel initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(VIDEO_CONTROL));

        panel.add(initButtonComponent(), BorderLayout.SOUTH);
        panel.add(initInfoComponent(), BorderLayout.EAST);
        panel.add(initListComponent(), BorderLayout.WEST);

        return panel;
    }

    private JPanel initButtonComponent() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 4, 1));
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JButton create = new JButton(CREATE_BUTTON);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame videoControlWindow = new VideoSystemWindow();
                videoControlWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        refreshData();
                    }
                });
            }
        });

        JButton exit = new JButton(EXIT_BUTTON);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(create);
        buttonPanel.add(exit);

        return buttonPanel;
    }

    private JPanel initInfoComponent() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(INFORMATION));
        info = new JTextArea(0, 50);
        info.setLineWrap(true);
        info.setEditable(true);
        panel.add(wrapForScroll(info), BorderLayout.CENTER);
        return panel;
    }

    public JComponent initListComponent() {
        //listNames.setPreferredSize(new Dimension(230, 0));
        refreshData();
        listNames.addListSelectionListener(e -> {
            JList<VideoSystem> list = (JList<VideoSystem>) e.getSource();
            VideoSystem videoSystem = list.getSelectedValue();
            if (videoSystem != null) {
                info.setText(videoSystem.toString());
                info.setCaretPosition(0);
            }
        });
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(new TitledBorder(LIST_VIDEO_SYSTEMS));
        listPanel.setPreferredSize(new Dimension(220, 0));
        listPanel.add(wrapForScroll(listNames), BorderLayout.CENTER);
        return listPanel;
    }

    public void refreshData() {
        DefaultListModel<VideoSystem> listModel = new DefaultListModel<>();
        List<VideoSystem> videoSystems = facade.getVideoSystems();
        for (VideoSystem videoSystem: videoSystems) {
            listModel.addElement(videoSystem);
        }
        listNames.setModel(listModel);
        listNames.setCellRenderer(new VideoSystemCellRenderer());
        info.setText("");
    }

    private final class VideoSystemCellRenderer extends JLabel implements ListCellRenderer {
        private VideoSystemCellRenderer() {
            setOpaque(true);
        }
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            VideoSystem videoSystem = (VideoSystem) value;
            setText(videoSystem.getNameObject());
            setToolTipText(videoSystem.getNameObject());
            if (isSelected) {
                setBackground(Color.lightGray);
                setForeground(Color.black);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
            return this;
        }
    }

    public static JComponent wrapForScroll(JComponent component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }
}
