package com.bsdim.svtit.app.window.video;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bsdim.svtit.app.video.VideoSystemFacade;
import com.bsdim.svtit.domain.video.VideoSystem;

public class EditorWindow extends JFrame {
    private static final String EDITOR = "Редактор";
    private static final String NAME_STATION = "Название станции: ";
    private static final String DATE_OF_FOUNDATION = "Дата ввода в эксплуатацию: ";
    private static final String DATE_EXAMPLE = "пример: 31.12.2017";
    private static final String MODEL_OF_VIDEO_RECORDER = "Модель видеорегистратора: ";
    private static final String IP_OF_VIDEO_RECORDER = "IPv4-адрес видеорегистратора: ";
    private static final String SUMMER_ARCHIVE = "Архив лето: ";
    private static final String WINTER_ARCHIVE = "Архив зима: ";
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
    private static final String SAVED = "Сохранено";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private VideoSystem videoSystem;
    private VideoSystemFacade facade = new VideoSystemFacade();
    private JTextField nameStationField;
    private JTextField dateOfFoundationField;
    private JTextField modelVideoRecorderField;
    private JTextField ipOfVideoRecorderField;
    private JTextField summerArchiveField;
    private JTextField winterArchiveField;
    private JTextField loginOfVideoRecorderField;
    private JTextField passwordOfVideoRecorderField;
    private JTextField countOfCamerasField;
    private JTextField modelsOfCamerasField;
    private JTextField ipOfCamerasField;
    private JTextField loginOfCamerasField;
    private JTextField passwordOfCamerasField;

    public EditorWindow(VideoSystem videoSystem) {
        super(EDITOR);
        this.videoSystem = videoSystem;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        add(initComponents());
        setVisible(true);
    }

    private JPanel initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        mainPanel.add(initTextFieldComponent(), BorderLayout.CENTER);
        mainPanel.add(initCheckBoxComponent(), BorderLayout.WEST);
        mainPanel.add(initButtonComponent(), BorderLayout.SOUTH);

        return mainPanel;
    }

    private JPanel initTextFieldComponent() {
        JPanel textFieldPanel = new JPanel(new GridLayout(13, 1, 0, 1));

        nameStationField = initTextField();
        nameStationField.setText(videoSystem.getNameStation());

        dateOfFoundationField = initTextField();
        dateOfFoundationField.setText(videoSystem.getDateOfFoundation());
        dateOfFoundationField.setToolTipText(DATE_EXAMPLE);

        modelVideoRecorderField = initTextField();
        modelVideoRecorderField.setText(videoSystem.getModelOfVideoRecorder());

        ipOfVideoRecorderField = initTextField();
        ipOfVideoRecorderField.setText(videoSystem.getIpOfVideoRecorder());

        summerArchiveField = initTextField();
        summerArchiveField.setText(videoSystem.getSummerArchive());
        summerArchiveField.setToolTipText(ARCHIVE_EXAMPLE);

        winterArchiveField = initTextField();
        winterArchiveField.setText(videoSystem.getWinterArchive());
        winterArchiveField.setToolTipText(ARCHIVE_EXAMPLE);

        loginOfVideoRecorderField = initTextField();
        loginOfVideoRecorderField.setText(videoSystem.getLoginOfVideoRecorder());

        passwordOfVideoRecorderField = initTextField();
        passwordOfVideoRecorderField.setText(videoSystem.getPasswordOfVideoRecorder());

        countOfCamerasField = initTextField();
        countOfCamerasField.setText(videoSystem.getCountOfCameras());

        modelsOfCamerasField = initTextField();
        modelsOfCamerasField.setText(videoSystem.getModelsOfCameras());

        ipOfCamerasField = initTextField();
        ipOfCamerasField.setText(videoSystem.getIpOfCameras());

        loginOfCamerasField = initTextField();
        loginOfCamerasField.setText(videoSystem.getLoginOfCameras());

        passwordOfCamerasField = initTextField();
        passwordOfCamerasField.setText(videoSystem.getPasswordOfCameras());

        textFieldPanel.add(nameStationField);
        textFieldPanel.add(dateOfFoundationField);
        textFieldPanel.add(modelVideoRecorderField);
        textFieldPanel.add(ipOfVideoRecorderField);
        textFieldPanel.add(summerArchiveField);
        textFieldPanel.add(winterArchiveField);
        textFieldPanel.add(loginOfVideoRecorderField);
        textFieldPanel.add(passwordOfVideoRecorderField);
        textFieldPanel.add(countOfCamerasField);
        textFieldPanel.add(modelsOfCamerasField);
        textFieldPanel.add(ipOfCamerasField);
        textFieldPanel.add(loginOfCamerasField);
        textFieldPanel.add(passwordOfCamerasField);

        return textFieldPanel;
    }

    private JPanel initCheckBoxComponent() {
        JPanel panelCheckBox = new JPanel(new GridLayout(13, 1, 1, 1));

        Label nameLabel = new Label(NAME_STATION);
        nameLabel.setFont(new Font(null, Font.BOLD, 12));
        nameLabel.setAlignment(Label.CENTER);

        panelCheckBox.add(nameLabel);
        panelCheckBox.add(initCheckBox(DATE_OF_FOUNDATION, dateOfFoundationField));
        panelCheckBox.add(initCheckBox(MODEL_OF_VIDEO_RECORDER, modelVideoRecorderField));
        panelCheckBox.add(initCheckBox(IP_OF_VIDEO_RECORDER, ipOfVideoRecorderField));
        panelCheckBox.add(initCheckBox(SUMMER_ARCHIVE, summerArchiveField));
        panelCheckBox.add(initCheckBox(WINTER_ARCHIVE, winterArchiveField));
        panelCheckBox.add(initCheckBox(LOGIN_OF_VIDEO_RECORDER, loginOfVideoRecorderField));
        panelCheckBox.add(initCheckBox(PASSWORD_OF_VIDEO_RECORDER, passwordOfVideoRecorderField));
        panelCheckBox.add(initCheckBox(COUNT_OF_CAMERAS, countOfCamerasField));
        panelCheckBox.add(initCheckBox(LIST_OF_MODELS_OF_CAMERAS, modelsOfCamerasField));
        panelCheckBox.add(initCheckBox(IP_OF_CAMERAS, ipOfCamerasField));
        panelCheckBox.add(initCheckBox(LOGIN_OF_CAMERAS, loginOfCamerasField));
        panelCheckBox.add(initCheckBox(PASSWORD_OF_CAMERAS, passwordOfCamerasField));

        return panelCheckBox;
    }

    private JPanel initButtonComponent() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        buttonPanel.setBorder(new EmptyBorder(10, 5, 10, 5));

        JButton save = new JButton(SAVE_BUTTON);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVideoSystem();
                JOptionPane.showMessageDialog(null, String.format(SAVED));
                dispose();
            }
        });

        JButton exit = new JButton(CANCEL_BUTTON);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(save);
        buttonPanel.add(exit);

        return buttonPanel;
    }

    private JCheckBox initCheckBox(String name, JTextField textField) {
        JCheckBox checkBox = new JCheckBox(name);
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    textField.setEditable(true);
                } else {
                    textField.setEditable(false);
                }
            }
        });
        return checkBox;
    }

    private JTextField initTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }

    private void updateVideoSystem() {
        videoSystem.setDateOfFoundation(dateOfFoundationField.getText());
        videoSystem.setModelOfVideoRecorder(modelVideoRecorderField.getText());
        videoSystem.setIpOfVideoRecorder(ipOfVideoRecorderField.getText());
        videoSystem.setSummerArchive(summerArchiveField.getText());
        videoSystem.setWinterArchive(winterArchiveField.getText());
        videoSystem.setLoginOfVideoRecorder(loginOfVideoRecorderField.getText());
        videoSystem.setPasswordOfVideoRecorder(passwordOfVideoRecorderField.getText());
        videoSystem.setCountOfCameras(countOfCamerasField.getText());
        videoSystem.setModelsOfCameras(modelsOfCamerasField.getText());
        videoSystem.setIpOfCameras(ipOfCamerasField.getText());
        videoSystem.setLoginOfCameras(loginOfCamerasField.getText());
        videoSystem.setPasswordOfCameras(passwordOfCamerasField.getText());

        facade.updateVideoSystem(videoSystem);
    }
}
