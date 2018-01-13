package com.bsdim.svtit.app.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VideoControlWindow extends JFrame {
    private static final String VIDEO_CONTROL = "Система видеонаблюдения";
    private static final String DATA_BORDER = "Данные";
    private static final String NAME_OBJECT = "Название объекта: ";
    private static final String DATE = "Дата ввода в эксплуатацию: ";
    private static final String DATE_EXAMPLE = "пример: 01.12.2017";
    private static final String EMPTY = "";
    private static final String MODEL_OF_VIDEO_RECORDER = "Модель видеорегистратора: ";
    private static final String IP_OF_VIDEO_RECORDER = "IPv4-адрес видеорегистратора: ";
    private static final String ARCHIVE = "Архив(количество дней, хранимой информации)";
    private static final String ARCHIVE_SUMMER = "Лето: ";
    private static final String ARCHIVE_WINTER = "Зима: ";
    private static final String ARCHIVE_EXAMPLE = "пример: 30 суток";
    private static final String LOGIN_OF_VIDEO_RECORDER = "Логин видеорегистратора: ";
    private static final String PASSWORD_OF_VIDEO_RECORDER = "Пароль видеорегистратора: ";
    private static final String COUNT_OF_CAMERAS = "Количество камер: ";
    private static final String LIST_OF_MODELS_OF_CAMERAS = "Список моделей камер: ";
    private static final String IP_OF_CAMERAS = "IPv4-адреса камер: ";
    private static final String LOGIN_OF_CAMERAS = "Логин камер: ";
    private static final String PASSWORD_OF_CAMERAS = "Пароль камер: ";
    private static final String SAVE_BUTTON = "Сохранить";
    private static final String CANCEL_BUTTON = "Отмена";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private Box mainBox;
    private JTextField nameField;
    private JTextField dateField;
    private JTextField videoRecorderField;
    private JTextField archiveSummerField;
    private JTextField archiveWinterField;
    private JTextField ipOfVideoRecorderField;
    private JTextField loginOfVideoRecorderField;
    private JTextField passwordOfVideoRecorderField;
    private JTextField countOfCamerasField;
    private JTextField modelsOfCamerasField;
    private JTextField ipOfCamerasField;
    private JTextField loginOfCamerasField;
    private JTextField passwordOfCamerasField;

    public VideoControlWindow() {
        super(VIDEO_CONTROL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        add(initComponents(), BorderLayout.NORTH);
        //pack();
        setVisible(true);
    }

    private JPanel initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new TitledBorder(DATA_BORDER));

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(10, 10, 5, 10));

        fillMainBox(initNameComponent(), 20);
        fillMainBox(initDateComponent(), 20);
        fillMainBox(initVideoRecorderComponent(),20);
        fillMainBox(initIpOfVideoRecorderComponent(), 20);
        fillMainBox(initArhiveComponent(), 20);
        fillMainBox(initLoginOfVideoRecorderComponent(), 20);
        fillMainBox(initPasswordOfVideoRecorderComponent(), 20);
        fillMainBox(initCountOfCamerasComponent(), 20);
        fillMainBox(initModelsOfCamerasComponent(), 20);
        fillMainBox(initIpOfCamerasComponent(), 20);
        fillMainBox(initLoginOfCamerasComponent(), 20);
        fillMainBox(initPasswordOfCamerasComponent(), 10);
        fillMainBox(initButtonComponent(), 1);

        mainPanel.add(mainBox);
        return mainPanel;
    }

    private void fillMainBox(Box box, int height) {
        mainBox.add(box);
        mainBox.add(Box.createVerticalStrut(height));
    }

    private Box initNameComponent() {
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(NAME_OBJECT);
        nameField = initTextField();

        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(75));
        nameBox.add(nameField);
        return nameBox;
    }

    private Box initDateComponent() {
        Box dateBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(DATE);
        dateField = initTextField();

        dateField.setToolTipText(DATE_EXAMPLE);
        dateField.setText(DATE_EXAMPLE);
        dateField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                dateField.setText(EMPTY);
            }

            @Override
            public void focusLost(FocusEvent e) {
                dateField.setText(DATE_EXAMPLE);
            }
        });

        dateBox.add(nameLabel);
        dateBox.add(Box.createHorizontalStrut(18));
        dateBox.add(dateField);
        return dateBox;
    }

    private Box initVideoRecorderComponent() {
        Box videoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(MODEL_OF_VIDEO_RECORDER);
        videoRecorderField = initTextField();

        videoBox.add(nameLabel);
        videoBox.add(Box.createHorizontalStrut(18));
        videoBox.add(videoRecorderField);
        return videoBox;
    }

    private Box initIpOfVideoRecorderComponent() {
        Box ipOfVideoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(IP_OF_VIDEO_RECORDER);
        ipOfVideoRecorderField = initTextField();

        ipOfVideoBox.add(nameLabel);
        ipOfVideoBox.add(Box.createHorizontalStrut(1));
        ipOfVideoBox.add(ipOfVideoRecorderField);
        return ipOfVideoBox;
    }

    private Box initArhiveComponent() {
        Box archiveMainBox = Box.createVerticalBox();
        Box archiveBox = Box.createHorizontalBox();

        JLabel archiveLabel = new JLabel(ARCHIVE);
        JLabel summerLabel = new JLabel(ARCHIVE_SUMMER);
        JLabel winterLabel = new JLabel(ARCHIVE_WINTER);

        archiveSummerField = initTextField();
        archiveWinterField = initTextField();

        archiveSummerField.setToolTipText(ARCHIVE_EXAMPLE);
        archiveWinterField.setToolTipText(ARCHIVE_EXAMPLE);

        archiveMainBox.add(archiveLabel);
        archiveMainBox.add(Box.createVerticalStrut(10));
        archiveBox.add(summerLabel);
        archiveBox.add(archiveSummerField);
        archiveBox.add(Box.createHorizontalStrut(80));
        archiveBox.add(winterLabel);
        archiveBox.add(archiveWinterField);
        archiveMainBox.add(archiveBox);
        return archiveMainBox;
    }

    private Box initLoginOfVideoRecorderComponent() {
        Box loginOfVideoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(LOGIN_OF_VIDEO_RECORDER);
        loginOfVideoRecorderField = initTextField();

        loginOfVideoBox.add(nameLabel);
        loginOfVideoBox.add(Box.createHorizontalStrut(21));
        loginOfVideoBox.add(loginOfVideoRecorderField);
        return loginOfVideoBox;
    }

    private Box initPasswordOfVideoRecorderComponent() {
        Box passwordOfVideoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(PASSWORD_OF_VIDEO_RECORDER);
        passwordOfVideoRecorderField = initTextField();

        passwordOfVideoBox.add(nameLabel);
        passwordOfVideoBox.add(Box.createHorizontalStrut(10));
        passwordOfVideoBox.add(passwordOfVideoRecorderField);
        return passwordOfVideoBox;
    }

    private Box initCountOfCamerasComponent() {
        Box countOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(COUNT_OF_CAMERAS);
        countOfCamerasField = initTextField();

        countOfCamerasBox.add(nameLabel);
        countOfCamerasBox.add(Box.createHorizontalStrut(65));
        countOfCamerasBox.add(countOfCamerasField);
        return countOfCamerasBox;
    }

    private Box initModelsOfCamerasComponent() {
        Box modelsOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(LIST_OF_MODELS_OF_CAMERAS);
        modelsOfCamerasField = initTextField();

        modelsOfCamerasBox.add(nameLabel);
        modelsOfCamerasBox.add(Box.createHorizontalStrut(37));
        modelsOfCamerasBox.add(modelsOfCamerasField);
        return modelsOfCamerasBox;
    }

    private Box initIpOfCamerasComponent() {
        Box ipOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(IP_OF_CAMERAS);
        ipOfCamerasField = initTextField();

        ipOfCamerasBox.add(nameLabel);
        ipOfCamerasBox.add(Box.createHorizontalStrut(63));
        ipOfCamerasBox.add(ipOfCamerasField);
        return ipOfCamerasBox;
    }

    private Box initLoginOfCamerasComponent() {
        Box loginOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(LOGIN_OF_CAMERAS);
        loginOfCamerasField = initTextField();

        loginOfCamerasBox.add(nameLabel);
        loginOfCamerasBox.add(Box.createHorizontalStrut(100));
        loginOfCamerasBox.add(loginOfCamerasField);
        return loginOfCamerasBox;
    }

    private Box initPasswordOfCamerasComponent() {
        Box passwordOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(PASSWORD_OF_CAMERAS);
        passwordOfCamerasField = initTextField();

        passwordOfCamerasBox.add(nameLabel);
        passwordOfCamerasBox.add(Box.createHorizontalStrut(89));
        passwordOfCamerasBox.add(passwordOfCamerasField);
        return passwordOfCamerasBox;
    }

    private Box initButtonComponent() {
        Box buttonBox = Box.createHorizontalBox();
        JButton save = new JButton(SAVE_BUTTON);
        JButton cancel = new JButton(CANCEL_BUTTON);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonBox.add(Box.createGlue());
        buttonBox.add(save);
        buttonBox.add(Box.createHorizontalStrut(10));
        buttonBox.add(cancel);
        return buttonBox;
    }

    private JTextField initTextField() {
        JTextField text = new JTextField();
        text.setEditable(true);
        return text;
    }
}
