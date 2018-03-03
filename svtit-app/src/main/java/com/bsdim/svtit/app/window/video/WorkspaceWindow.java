package com.bsdim.svtit.app.window.video;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.bsdim.svtit.app.component.MenuBar;
import com.bsdim.svtit.app.video.VideoSystemFacade;
import com.bsdim.svtit.domain.video.VideoSystem;

/**
 * The workspace window.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
@SuppressWarnings("checkstyle:ClassDataAbstractionCoupling")
public class WorkspaceWindow extends JFrame {
    private static final String WORKSPACE_WINDOW = "Рабочая область";
    private static final String VIDEO_CONTROL = "Видеонаблюдение";
    private static final String EXIT_BUTTON = "Выход";
    private static final String CREATE_BUTTON = "Добавить";
    private static final String EDIT_BUTTON = "Редактировать";
    private static final String DELETE_BUTTON = "Удалить";
    private static final String STATION = "Станция";
    private static final String INFORMATION = "Информация";
    private static final String TO_EDIT_STATION = "Выберите станцию для редактирования";
    private static final String TO_DELETE_STATION = "Выберите станцию для удаления";
    private static final String DELETED = "Удалено";
    private static final String EMPTY = "";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int COLS_BUTTON_PANEL = 5;
    private static final int HGAP_BUTTON_PANEL = 5;
    private static final int BORDER_BUTTON_PANEL = 5;
    private static final int COLUMNS_INFO = 50;
    private static final int WIDTH_LIST_PANEL = 220;

    private JList<VideoSystem> listNames = new JList<>();
    private VideoSystemFacade facade = new VideoSystemFacade();
    private JTextArea info;
    private VideoSystem videoSystem;
    private ActionListener createActionListener;
    private ActionListener editActionListener;
    private ActionListener deleteActionListener;
    private ActionListener exitActionListener;

    /**
     * The constructor.
     */
    public WorkspaceWindow() {
        super(WORKSPACE_WINDOW);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        add(initComponents());
        setVisible(true);
    }

    private JPanel initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(VIDEO_CONTROL));

        panel.add(initButtonComponent(), BorderLayout.SOUTH);
        panel.add(initInfoComponent(), BorderLayout.EAST);
        panel.add(initListComponent(), BorderLayout.WEST);

        setJMenuBar(new MenuBar().initMenuBarComponent(createActionListener, editActionListener,
                deleteActionListener, exitActionListener));

        return panel;
    }

    private JPanel initButtonComponent() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, COLS_BUTTON_PANEL, HGAP_BUTTON_PANEL, 1));
        buttonPanel.setBorder(new EmptyBorder(BORDER_BUTTON_PANEL, BORDER_BUTTON_PANEL,
                BORDER_BUTTON_PANEL, BORDER_BUTTON_PANEL));

        JButton create = new JButton(CREATE_BUTTON);
        createActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VideoSystemWindow videoSystemWindow = new VideoSystemWindow();
                videoSystemWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        refreshData();
                    }
                });
            }
        };
        create.addActionListener(createActionListener);

        JButton edit = new JButton(EDIT_BUTTON);
        editActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (videoSystem != null) {
                    EditorWindow editorWindow = new EditorWindow(videoSystem);
                    editorWindow.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            refreshData();
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null,
                            String.format(TO_EDIT_STATION));
                }
            }
        };
        edit.addActionListener(editActionListener);

        JButton delete = new JButton(DELETE_BUTTON);
        deleteActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (videoSystem != null) {
                    facade.deleteVideoSystem(videoSystem.getNameStation());
                    JOptionPane.showMessageDialog(null,
                            String.format(DELETED));
                    refreshData();
                } else {
                    JOptionPane.showMessageDialog(null,
                            String.format(TO_DELETE_STATION));
                }
            }
        };
        delete.addActionListener(deleteActionListener);

        JButton exit = new JButton(EXIT_BUTTON);
        exitActionListener = event -> {
            System.exit(0);
        };
        exit.addActionListener(exitActionListener);

        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(create);
        buttonPanel.add(edit);
        buttonPanel.add(delete);
        buttonPanel.add(exit);

        return buttonPanel;
    }

    private JPanel initInfoComponent() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(INFORMATION));
        info = new JTextArea(0, COLUMNS_INFO);
        info.setLineWrap(true);
        info.setEditable(true);
        panel.add(wrapForScroll(info), BorderLayout.CENTER);
        return panel;
    }

    /**
     * Inits list conponent.
     *
     * @return the component.
     */
    public JComponent initListComponent() {
        //listNames.setPreferredSize(new Dimension(230, 0));
        refreshData();
        listNames.addListSelectionListener(e -> {
            JList<VideoSystem> list = (JList<VideoSystem>) e.getSource();
            videoSystem = list.getSelectedValue();
            if (videoSystem != null) {
                info.setText(videoSystem.toString());
                info.setCaretPosition(0);
            }
        });
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(new TitledBorder(STATION));
        listPanel.setPreferredSize(new Dimension(WIDTH_LIST_PANEL, 0));
        listPanel.add(wrapForScroll(listNames), BorderLayout.CENTER);
        return listPanel;
    }

    /**
     * Refreshes data.
     */
    public void refreshData() {
        DefaultListModel<VideoSystem> listModel = new DefaultListModel<>();
        List<VideoSystem> videoSystems = facade.getVideoSystems();
        for (VideoSystem video: videoSystems) {
            listModel.addElement(video);
        }
        listNames.setModel(listModel);
        listNames.setCellRenderer(new VideoSystemCellRenderer());
        info.setText(EMPTY);
    }

    /**
     * Wraps for scroll.
     *
     * @param component the component.
     * @return the component.
     */
    public static JComponent wrapForScroll(JComponent component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private final class VideoSystemCellRenderer extends JLabel implements ListCellRenderer {
        private VideoSystemCellRenderer() {
            setOpaque(true);
        }
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            VideoSystem video = (VideoSystem) value;
            setText(video.getNameStation());
            setToolTipText(video.getNameStation());
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
}
