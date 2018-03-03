package com.bsdim.svtit.app.window.video;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.bsdim.svtit.app.LengthRestrictedDocument;
import com.bsdim.svtit.app.video.VideoSystemFacade;
import com.bsdim.svtit.domain.video.VideoSystem;
import org.codehaus.plexus.util.StringUtils;

/**
 * The video system window.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class VideoSystemWindow extends JFrame {
    private static final String VIDEO_SYSTEM = "Система видеонаблюдения";
    private static final String DATA_BORDER = "Данные";
    private static final String NAME_STATION = "Название станции: ";
    private static final String DATE_OF_FOUNDATION = "Дата ввода в эксплуатацию: ";
    private static final String DATE_EXAMPLE = "пример: 31.12.2017";
    private static final String MODEL_OF_DVR = "Модель видеорегистратора: ";
    private static final String IP_OF_DVR = "IPv4-адрес видеорегистратора: ";
    private static final String ARCHIVE = "Архив(количество дней):";
    private static final String ARCHIVE_SUMMER = "Лето: ";
    private static final String ARCHIVE_WINTER = "Зима: ";
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
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int BORDER_MAIN_BOX = 5;
    private static final int HEIGHT_VERTICAL_STRUT = 20;
    private static final int HEIGHT_PASSWORD_CAM_VERTICAL_STRUT = 10;
    private static final int LENGTH_NAME_STATION_FIELD = 64;
    private static final int WIDTH_NAME_BOX = 75;
    private static final int WIDTH_DATE_BOX = 18;
    private static final int WIDTH_VIDEO_BOX = 18;
    private static final int HEIGHT_ARCHIVE_MAIN_BOX = 10;
    private static final int WIDTH_ARCHIVE_MAIN_BOX = 80;
    private static final int WIDTH_LOGIN_VIDEO_BOX = 21;
    private static final int WIDTH_PASSWORD_VIDEO_BOX = 10;
    private static final int WIDTH_COUNT_CAMERAS_BOX = 65;
    private static final int WIDTH_MODELS_CAMERAS_BOX = 37;
    private static final int WIDTH_IP_CAMERAS_BOX = 63;
    private static final int WIDTH_LOGIN_CAMERAS_BOX = 100;
    private static final int WIDTH_PASSWORD_CAMERAS_BOX = 89;
    private static final int WIDTH_BUTTON_BOX = 10;

    private Box mainBox;
    private JTextField nameStationField;
    private JTextField dateOfFoundationField;
    private JTextField modelOfDVRField;
    private JTextField summerArchiveField;
    private JTextField winterArchiveField;
    private JTextField ipOfDVRField;
    private JTextField loginOfDVRField;
    private JTextField passwordOfDVRField;
    private JTextField countOfCamerasField;
    private JTextField modelsOfCamerasField;
    private JTextField ipOfCamerasField;
    private JTextField loginOfCamerasField;
    private JTextField passwordOfCamerasField;
    private VideoSystemFacade facade = new VideoSystemFacade();

    /**
     * The constructor.
     */
    public VideoSystemWindow() {
        super(VIDEO_SYSTEM);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        add(initComponents(), BorderLayout.NORTH);
        setVisible(true);
    }

    private JPanel initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new TitledBorder(DATA_BORDER));

        mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(BORDER_MAIN_BOX, BORDER_MAIN_BOX, BORDER_MAIN_BOX, BORDER_MAIN_BOX));

        addMainBox(initNameComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initDateComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initModelOfDVRComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initIpOfDVRComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initArhiveComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initLoginOfDVRComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initPasswordOfDVRComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initCountOfCamerasComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initModelsOfCamerasComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initIpOfCamerasComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initLoginOfCamerasComponent(), HEIGHT_VERTICAL_STRUT);
        addMainBox(initPasswordOfCamerasComponent(), HEIGHT_PASSWORD_CAM_VERTICAL_STRUT);
        addMainBox(initButtonComponent(), 1);

        mainPanel.add(mainBox);
        return mainPanel;
    }

    private void addMainBox(Box box, int height) {
        mainBox.add(box);
        mainBox.add(Box.createVerticalStrut(height));
    }

    private Box initNameComponent() {
        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(NAME_STATION);
        nameStationField = initTextField();
        nameStationField.setDocument(new LengthRestrictedDocument(LENGTH_NAME_STATION_FIELD));

        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(WIDTH_NAME_BOX));
        nameBox.add(nameStationField);
        return nameBox;
    }

    private Box initDateComponent() {
        Box dateBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(DATE_OF_FOUNDATION);
        dateOfFoundationField = initTextField();
        dateOfFoundationField.setToolTipText(DATE_EXAMPLE);

        dateBox.add(nameLabel);
        dateBox.add(Box.createHorizontalStrut(WIDTH_DATE_BOX));
        dateBox.add(dateOfFoundationField);
        return dateBox;
    }

    private Box initModelOfDVRComponent() {
        Box videoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(MODEL_OF_DVR);
        modelOfDVRField = initTextField();

        videoBox.add(nameLabel);
        videoBox.add(Box.createHorizontalStrut(WIDTH_VIDEO_BOX));
        videoBox.add(modelOfDVRField);
        return videoBox;
    }

    private Box initIpOfDVRComponent() {
        Box ipOfVideoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(IP_OF_DVR);
        ipOfDVRField = initTextField();

        ipOfVideoBox.add(nameLabel);
        ipOfVideoBox.add(Box.createHorizontalStrut(1));
        ipOfVideoBox.add(ipOfDVRField);
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
        archiveMainBox.add(Box.createVerticalStrut(HEIGHT_ARCHIVE_MAIN_BOX));
        archiveBox.add(summerLabel);
        archiveBox.add(summerArchiveField);
        archiveBox.add(Box.createHorizontalStrut(WIDTH_ARCHIVE_MAIN_BOX));
        archiveBox.add(winterLabel);
        archiveBox.add(winterArchiveField);
        archiveMainBox.add(archiveBox);
        return archiveMainBox;
    }

    private Box initLoginOfDVRComponent() {
        Box loginOfVideoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(LOGIN_OF_DVR);
        loginOfDVRField = initTextField();

        loginOfVideoBox.add(nameLabel);
        loginOfVideoBox.add(Box.createHorizontalStrut(WIDTH_LOGIN_VIDEO_BOX));
        loginOfVideoBox.add(loginOfDVRField);
        return loginOfVideoBox;
    }

    private Box initPasswordOfDVRComponent() {
        Box passwordOfVideoBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(PASSWORD_OF_DVR);
        passwordOfDVRField = initTextField();

        passwordOfVideoBox.add(nameLabel);
        passwordOfVideoBox.add(Box.createHorizontalStrut(WIDTH_PASSWORD_VIDEO_BOX));
        passwordOfVideoBox.add(passwordOfDVRField);
        return passwordOfVideoBox;
    }

    private Box initCountOfCamerasComponent() {
        Box countOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(COUNT_OF_CAMERAS);
        countOfCamerasField = initTextField();

        countOfCamerasBox.add(nameLabel);
        countOfCamerasBox.add(Box.createHorizontalStrut(WIDTH_COUNT_CAMERAS_BOX));
        countOfCamerasBox.add(countOfCamerasField);
        return countOfCamerasBox;
    }

    private Box initModelsOfCamerasComponent() {
        Box modelsOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(LIST_OF_MODELS_OF_CAMERAS);
        modelsOfCamerasField = initTextField();

        modelsOfCamerasBox.add(nameLabel);
        modelsOfCamerasBox.add(Box.createHorizontalStrut(WIDTH_MODELS_CAMERAS_BOX));
        modelsOfCamerasBox.add(modelsOfCamerasField);
        return modelsOfCamerasBox;
    }

    private Box initIpOfCamerasComponent() {
        Box ipOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(IP_OF_CAMERAS);
        ipOfCamerasField = initTextField();

        ipOfCamerasBox.add(nameLabel);
        ipOfCamerasBox.add(Box.createHorizontalStrut(WIDTH_IP_CAMERAS_BOX));
        ipOfCamerasBox.add(ipOfCamerasField);
        return ipOfCamerasBox;
    }

    private Box initLoginOfCamerasComponent() {
        Box loginOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(LOGIN_OF_CAMERAS);
        loginOfCamerasField = initTextField();

        loginOfCamerasBox.add(nameLabel);
        loginOfCamerasBox.add(Box.createHorizontalStrut(WIDTH_LOGIN_CAMERAS_BOX));
        loginOfCamerasBox.add(loginOfCamerasField);
        return loginOfCamerasBox;
    }

    private Box initPasswordOfCamerasComponent() {
        Box passwordOfCamerasBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel(PASSWORD_OF_CAMERAS);
        passwordOfCamerasField = initTextField();

        passwordOfCamerasBox.add(nameLabel);
        passwordOfCamerasBox.add(Box.createHorizontalStrut(WIDTH_PASSWORD_CAMERAS_BOX));
        passwordOfCamerasBox.add(passwordOfCamerasField);
        return passwordOfCamerasBox;
    }

    private Box initButtonComponent() {
        Box buttonBox = Box.createHorizontalBox();
        JButton save = new JButton(SAVE_BUTTON);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StringUtils.isBlank(nameStationField.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Поле \"Название станции\" заполнено некорректно");
                } else {
                    VideoSystem videoSystem = facade.findByName(nameStationField.getText());
                    if (videoSystem == null) {
                        saveVideoSystem();
                        JOptionPane.showMessageDialog(null, String.format("Сохранено"));
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                String.format("Станция %1$s существует", nameStationField.getText()));
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
        buttonBox.add(Box.createHorizontalStrut(WIDTH_BUTTON_BOX));
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
        videoSystem.setNameStation(nameStationField.getText());
        videoSystem.setDateOfFoundation(dateOfFoundationField.getText());
        videoSystem.setModelOfDVR(modelOfDVRField.getText());
        videoSystem.setSummerArchive(summerArchiveField.getText());
        videoSystem.setWinterArchive(winterArchiveField.getText());
        videoSystem.setIpOfDVR(ipOfDVRField.getText());
        videoSystem.setLoginOfDVR(loginOfDVRField.getText());
        videoSystem.setPasswordOfDVR(passwordOfDVRField.getText());
        videoSystem.setCountOfCameras(countOfCamerasField.getText());
        videoSystem.setModelsOfCameras(modelsOfCamerasField.getText());
        videoSystem.setIpOfCameras(ipOfCamerasField.getText());
        videoSystem.setLoginOfCameras(loginOfCamerasField.getText());
        videoSystem.setPasswordOfCameras(passwordOfCamerasField.getText());

        facade.addVideoSystem(videoSystem);
    }
}
