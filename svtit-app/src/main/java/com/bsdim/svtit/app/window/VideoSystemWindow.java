package com.bsdim.svtit.app.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.bsdim.svtit.app.video.VideoSystemFacade;
import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.service.video.VideoSystemService;
import org.codehaus.plexus.util.StringUtils;

public class VideoSystemWindow extends JFrame {
    private static final String VIDEO_SYSTEM = "Система видеонаблюдения";
    private static final String DATA_BORDER = "Данные";
    private static final String NAME_OBJECT = "Название объекта: ";
    private static final String DATE = "Дата ввода в эксплуатацию: ";
    private static final String DATE_EXAMPLE = "пример: 31.12.2017";
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
    private JTextField summerArchiveField;
    private JTextField winterArchiveField;
    private JTextField ipOfVideoRecorderField;
    private JTextField loginOfVideoRecorderField;
    private JTextField passwordOfVideoRecorderField;
    private JTextField countOfCamerasField;
    private JTextField modelsOfCamerasField;
    private JTextField ipOfCamerasField;
    private JTextField loginOfCamerasField;
    private JTextField passwordOfCamerasField;
    private VideoSystemService service = new VideoSystemService();

    public VideoSystemWindow() {
        super(VIDEO_SYSTEM);
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

        addMainBox(initNameComponent(), 20);
        addMainBox(initDateComponent(), 20);
        addMainBox(initVideoRecorderComponent(),20);
        addMainBox(initIpOfVideoRecorderComponent(), 20);
        addMainBox(initArhiveComponent(), 20);
        addMainBox(initLoginOfVideoRecorderComponent(), 20);
        addMainBox(initPasswordOfVideoRecorderComponent(), 20);
        addMainBox(initCountOfCamerasComponent(), 20);
        addMainBox(initModelsOfCamerasComponent(), 20);
        addMainBox(initIpOfCamerasComponent(), 20);
        addMainBox(initLoginOfCamerasComponent(), 20);
        addMainBox(initPasswordOfCamerasComponent(), 10);
        addMainBox(initButtonComponent(), 1);

        mainPanel.add(mainBox);
        return mainPanel;
    }

    /*private Box initComponent(String nameLabel, JTextField textField, int width) {
        Box box = Box.createHorizontalBox();
        JLabel label = new JLabel(nameLabel);
        textField = initTextField();

        box.add(label);
        box.add(Box.createHorizontalStrut(width));
        box.add(textField);
        return box;
    }*/

    private void addMainBox(Box box, int height) {
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

        summerArchiveField = initTextField();
        winterArchiveField = initTextField();

        summerArchiveField.setToolTipText(ARCHIVE_EXAMPLE);
        winterArchiveField.setToolTipText(ARCHIVE_EXAMPLE);

        archiveMainBox.add(archiveLabel);
        archiveMainBox.add(Box.createVerticalStrut(10));
        archiveBox.add(summerLabel);
        archiveBox.add(summerArchiveField);
        archiveBox.add(Box.createHorizontalStrut(80));
        archiveBox.add(winterLabel);
        archiveBox.add(winterArchiveField);
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
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VideoSystemFacade facade = new VideoSystemFacade();
                if (StringUtils.isBlank(nameField.getText())) {
                    JOptionPane.showMessageDialog(null,
                            String.format("Поле \"Название объекта\" заполнено некорректно"));
                } else {
                    VideoSystem videoSystem = facade.findByName(nameField.getText());
                    if (videoSystem == null) {
                        saveVideoSystem();
                        JOptionPane.showMessageDialog(null, String.format("Сохранено"));
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                String.format("Объект %1$s уже существует", nameField.getText()));
                    }
                }
            }
        });
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

    private void saveVideoSystem() {
        VideoSystem videoSystem = new VideoSystem();

        videoSystem.setId(UUID.randomUUID().toString());
        videoSystem.setNameObject(nameField.getText());
        videoSystem.setDateOfFoundation(dateField.getText());
        videoSystem.setModelOfVideoRecorder(videoRecorderField.getText());
        videoSystem.setSummerArchive(summerArchiveField.getText());
        videoSystem.setWinterArchive(winterArchiveField.getText());
        videoSystem.setIpOfVideoRecorder(ipOfVideoRecorderField.getText());
        videoSystem.setLoginOfVideoRecorder(loginOfVideoRecorderField.getText());
        videoSystem.setPasswordOfVideoRecorder(passwordOfVideoRecorderField.getText());
        videoSystem.setCountOfCameras(countOfCamerasField.getText());
        videoSystem.setModelsOfCameras(modelsOfCamerasField.getText());
        videoSystem.setIpOfCameras(ipOfCamerasField.getText());
        videoSystem.setLoginOfCameras(loginOfCamerasField.getText());
        videoSystem.setPasswordOfCameras(passwordOfCamerasField.getText());

        service.addVideoSystem(videoSystem);
    }
}
