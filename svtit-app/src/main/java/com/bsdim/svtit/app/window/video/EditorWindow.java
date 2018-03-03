package com.bsdim.svtit.app.window.video;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
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

/**
 * Thr editor window.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class EditorWindow extends JFrame {
    private static final String EDITOR = "Редактор";
    private static final String NAME_STATION = "Название станции: ";
    private static final String DATE_OF_FOUNDATION = "Дата ввода в эксплуатацию: ";
    private static final String DATE_EXAMPLE = "пример: 31.12.2017";
    private static final String MODEL_OF_DVR = "Модель видеорегистратора: ";
    private static final String IP_OF_DVR = "IPv4-адрес видеорегистратора: ";
    private static final String SUMMER_ARCHIVE = "Архив лето: ";
    private static final String WINTER_ARCHIVE = "Архив зима: ";
    private static final String ARCHIVE_EXAMPLE = "пример: 30 суток";
    private static final String LOGIN_OF_DVR = "Логин видеорегистратора: ";
    private static final String PASSWORD_OF_DVR = "Пароль видеорегистратора: ";
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
    private static final int BORDER_MAIN_PANEL = 5;
    private static final int ROWS_TEXT_FIELD_PANEL = 13;
    private static final int ROWS_CHECK_BOX_PANEL = 13;
    private static final int SIZE_NAME_LABEL = 12;
    private static final int BORDER_BOTTON_PANEL = 10;
    private static final int PARAMETERS_BOTTON_PANEL = 5;

    private VideoSystem videoSystem;
    private VideoSystemFacade facade = new VideoSystemFacade();
    private JTextField nameStationField;
    private JTextField dateOfFoundationField;
    private JTextField modelOfDVRField;
    private JTextField ipOfDVRField;
    private JTextField summerArchiveField;
    private JTextField winterArchiveField;
    private JTextField loginOfDVRField;
    private JTextField passwordOfDVRField;
    private JTextField countOfCamerasField;
    private JTextField modelsOfCamerasField;
    private JTextField ipOfCamerasField;
    private JTextField loginOfCamerasField;
    private JTextField passwordOfCamerasField;

    /**
     * Parametrized constructor.
     *
     * @param videoSystem the video system.
     */
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
        mainPanel.setBorder(new EmptyBorder(BORDER_MAIN_PANEL, BORDER_MAIN_PANEL,
                BORDER_MAIN_PANEL, BORDER_MAIN_PANEL));

        mainPanel.add(initTextFieldComponent(), BorderLayout.CENTER);
        mainPanel.add(initCheckBoxComponent(), BorderLayout.WEST);
        mainPanel.add(initButtonComponent(), BorderLayout.SOUTH);

        return mainPanel;
    }

    private JPanel initTextFieldComponent() {
        JPanel textFieldPanel = new JPanel(new GridLayout(ROWS_TEXT_FIELD_PANEL, 1, 0, 1));

        nameStationField = initTextField();
        nameStationField.setText(videoSystem.getNameStation());

        dateOfFoundationField = initTextField();
        dateOfFoundationField.setText(videoSystem.getDateOfFoundation());
        dateOfFoundationField.setToolTipText(DATE_EXAMPLE);

        modelOfDVRField = initTextField();
        modelOfDVRField.setText(videoSystem.getModelOfDVR());

        ipOfDVRField = initTextField();
        ipOfDVRField.setText(videoSystem.getIpOfDVR());

        summerArchiveField = initTextField();
        summerArchiveField.setText(videoSystem.getSummerArchive());
        summerArchiveField.setToolTipText(ARCHIVE_EXAMPLE);

        winterArchiveField = initTextField();
        winterArchiveField.setText(videoSystem.getWinterArchive());
        winterArchiveField.setToolTipText(ARCHIVE_EXAMPLE);

        loginOfDVRField = initTextField();
        loginOfDVRField.setText(videoSystem.getLoginOfDVR());

        passwordOfDVRField = initTextField();
        passwordOfDVRField.setText(videoSystem.getPasswordOfDVR());

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
        textFieldPanel.add(modelOfDVRField);
        textFieldPanel.add(ipOfDVRField);
        textFieldPanel.add(summerArchiveField);
        textFieldPanel.add(winterArchiveField);
        textFieldPanel.add(loginOfDVRField);
        textFieldPanel.add(passwordOfDVRField);
        textFieldPanel.add(countOfCamerasField);
        textFieldPanel.add(modelsOfCamerasField);
        textFieldPanel.add(ipOfCamerasField);
        textFieldPanel.add(loginOfCamerasField);
        textFieldPanel.add(passwordOfCamerasField);

        return textFieldPanel;
    }

    private JPanel initCheckBoxComponent() {
        JPanel checkBoxPanel = new JPanel(new GridLayout(ROWS_CHECK_BOX_PANEL, 1, 1, 1));

        Label nameLabel = new Label(NAME_STATION);
        nameLabel.setFont(new Font(null, Font.BOLD, SIZE_NAME_LABEL));
        nameLabel.setAlignment(Label.CENTER);

        checkBoxPanel.add(nameLabel);
        checkBoxPanel.add(initCheckBox(DATE_OF_FOUNDATION, dateOfFoundationField));
        checkBoxPanel.add(initCheckBox(MODEL_OF_DVR, modelOfDVRField));
        checkBoxPanel.add(initCheckBox(IP_OF_DVR, ipOfDVRField));
        checkBoxPanel.add(initCheckBox(SUMMER_ARCHIVE, summerArchiveField));
        checkBoxPanel.add(initCheckBox(WINTER_ARCHIVE, winterArchiveField));
        checkBoxPanel.add(initCheckBox(LOGIN_OF_DVR, loginOfDVRField));
        checkBoxPanel.add(initCheckBox(PASSWORD_OF_DVR, passwordOfDVRField));
        checkBoxPanel.add(initCheckBox(COUNT_OF_CAMERAS, countOfCamerasField));
        checkBoxPanel.add(initCheckBox(LIST_OF_MODELS_OF_CAMERAS, modelsOfCamerasField));
        checkBoxPanel.add(initCheckBox(IP_OF_CAMERAS, ipOfCamerasField));
        checkBoxPanel.add(initCheckBox(LOGIN_OF_CAMERAS, loginOfCamerasField));
        checkBoxPanel.add(initCheckBox(PASSWORD_OF_CAMERAS, passwordOfCamerasField));

        return checkBoxPanel;
    }

    private JPanel initButtonComponent() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, PARAMETERS_BOTTON_PANEL,
                PARAMETERS_BOTTON_PANEL, PARAMETERS_BOTTON_PANEL));
        buttonPanel.setBorder(new EmptyBorder(BORDER_BOTTON_PANEL, 0, BORDER_BOTTON_PANEL, 0));

        JButton save = new JButton(SAVE_BUTTON);
        save.addActionListener(event -> {
            updateVideoSystem();
            JOptionPane.showMessageDialog(null, String.format(SAVED));
            dispose();
        });

        JButton exit = new JButton(CANCEL_BUTTON);
        exit.addActionListener(event -> {
            dispose();
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
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
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
        videoSystem.setModelOfDVR(modelOfDVRField.getText());
        videoSystem.setIpOfDVR(ipOfDVRField.getText());
        videoSystem.setSummerArchive(summerArchiveField.getText());
        videoSystem.setWinterArchive(winterArchiveField.getText());
        videoSystem.setLoginOfDVR(loginOfDVRField.getText());
        videoSystem.setPasswordOfDVR(passwordOfDVRField.getText());
        videoSystem.setCountOfCameras(countOfCamerasField.getText());
        videoSystem.setModelsOfCameras(modelsOfCamerasField.getText());
        videoSystem.setIpOfCameras(ipOfCamerasField.getText());
        videoSystem.setLoginOfCameras(loginOfCamerasField.getText());
        videoSystem.setPasswordOfCameras(passwordOfCamerasField.getText());

        facade.updateVideoSystem(videoSystem);
    }
}
