package com.bsdim.svtit.admin.util;

import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

import com.bsdim.svtit.domain.video.VideoSystem;
import org.codehaus.plexus.util.StringUtils;

/**
 * The input of data.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public final class InputUtil {
    private static final String ENTER_NAME_SYSTEM = "Enter name of the video system: ";
    private static final String ENTER_DATE_OF_FOUNDATION = "Enter date of foundation of the video system: ";
    private static final String ENTER_MODEL_DVR = "Enter model of the DVR: ";
    private static final String ENTER_IP_DVR = "Enter IPv4 of the DVR: ";
    private static final String ENTER_SUMMER_ARCHIVE = "Enter count days of summer archive: ";
    private static final String ENTER_WINTER_ARCHIVE = "Enter count days of winter archive: ";
    private static final String ENTER_LOGIN_DVR = "Enter login of the DVR: ";
    private static final String ENTER_PASSWORD_DVR = "Enter password of the DVR: ";
    private static final String ENTER_COUNT_CAMERAS = "Enter count of the cameras: ";
    private static final String ENTER_MODELS_CAMERAS = "Enter models of the cameras: ";
    private static final String ENTER_IP_CAMERAS = "Enter IPv4 of the cameras: ";
    private static final String ENTER_LOGIN_CAMERAS = "Enter login of the the cameras: ";
    private static final String ENTER_PASSWORD_CAMERAS = "Enter password of the cameras: ";
    private static Scanner sScanner = new Scanner(System.in);
    private static Logger sLogger = Logger.getLogger(InputUtil.class.getName());

    private InputUtil() {}
    public static Scanner getScanner() {
        return sScanner;
    }

    /**
     * Inputs data.
     *
     * @param message the message.
     * @return inputed data.
     */
    public static String inputData(String message) {
        String data;
        do {
            sLogger.info(message);
            data = sScanner.nextLine();
        } while (StringUtils.isBlank(data));
        return data;
    }

    /**
     * Creates data video system.
     *
     * @return the video system.
     */
    public static VideoSystem createDataVideoSystem() {
        VideoSystem videoSystem = new VideoSystem();

        String name = inputData(ENTER_NAME_SYSTEM);

        videoSystem.setId(UUID.randomUUID().toString());
        videoSystem.setNameStation(name);

        return formVideoSystem(videoSystem);
    }

    /**
     * Updates the video system data.
     *
     * @param videoSystem the video system.
     * @return the video system which was updated.
     */
    public static VideoSystem updateDataVideoSystem(VideoSystem videoSystem) {
        return formVideoSystem(videoSystem);
    }

    private static VideoSystem formVideoSystem(VideoSystem videoSystem) {
        String dateOfFoundation = inputData(ENTER_DATE_OF_FOUNDATION);
        String modelOfDVR = inputData(ENTER_MODEL_DVR);
        String ipOfDVR = inputData(ENTER_IP_DVR);
        String summerArchive = inputData(ENTER_SUMMER_ARCHIVE);
        String winterArchive = inputData(ENTER_WINTER_ARCHIVE);
        String loginOfDVR = inputData(ENTER_LOGIN_DVR);
        String passwordOfDVR = inputData(ENTER_PASSWORD_DVR);
        String countOfCameras = inputData(ENTER_COUNT_CAMERAS);
        String modelsOfCameras = inputData(ENTER_MODELS_CAMERAS);
        String ipOfCameras = inputData(ENTER_IP_CAMERAS);
        String loginOfCameras = inputData(ENTER_LOGIN_CAMERAS);
        String passwordOfCameras = inputData(ENTER_PASSWORD_CAMERAS);

        videoSystem.setDateOfFoundation(dateOfFoundation);
        videoSystem.setModelOfDVR(modelOfDVR);
        videoSystem.setIpOfDVR(ipOfDVR);
        videoSystem.setSummerArchive(summerArchive);
        videoSystem.setWinterArchive(winterArchive);
        videoSystem.setLoginOfDVR(loginOfDVR);
        videoSystem.setPasswordOfDVR(passwordOfDVR);
        videoSystem.setCountOfCameras(countOfCameras);
        videoSystem.setModelsOfCameras(modelsOfCameras);
        videoSystem.setIpOfCameras(ipOfCameras);
        videoSystem.setLoginOfCameras(loginOfCameras);
        videoSystem.setPasswordOfCameras(passwordOfCameras);
        return videoSystem;
    }
}
