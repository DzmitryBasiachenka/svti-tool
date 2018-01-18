package com.bsdim.svtit.admin.util;

import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

import com.bsdim.svtit.domain.video.VideoSystem;
import org.codehaus.plexus.util.StringUtils;

public final class InputUtil {
    private static Scanner sScanner = new Scanner(System.in);
    private static Logger sLogger = Logger.getLogger(InputUtil.class.getName());

    private InputUtil() {}
    public static Scanner getScanner() {
        return sScanner;
    }

    public static String inputData(String message) {
        String data;
        do {
            sLogger.info(message);
            data = sScanner.nextLine();
        } while (StringUtils.isBlank(data));
        return data;
    }

    public static VideoSystem createDataVideoSystem() {
        VideoSystem videoSystem = new VideoSystem();

        String name = inputData("Enter name of the video system: ");
        String dateOfFoundation = inputData("Enter date of foundation of the video system: ");
        String modelOfVideoRecorder = inputData("Enter model of the video recorder: ");
        String ipOfVideoRecorder = inputData("Enter date of foundation of the video system: ");
        String summerArchive = inputData("Enter count days of summer archive: ");
        String winterArchive = inputData("Enter count days of winter archive: ");
        String loginOfVideoRecorder = inputData("Enter login of the video recorder: ");
        String passwordOfVideoRecorder = inputData("Enter password of the video recorder: ");
        String countOfCameras = inputData("Enter count of the cameras: ");
        String modelsOfCameras = inputData("Enter models of the cameras: ");
        String ipOfCameras = inputData("Enter ip-address of the cameras: ");
        String loginOfCameras = inputData("Enter login of the the cameras: ");
        String passwordOfCameras = inputData("Enter password of the cameras: ");

        videoSystem.setId(UUID.randomUUID().toString());
        videoSystem.setNameObject(name);
        videoSystem.setDateOfFoundation(dateOfFoundation);
        videoSystem.setModelOfVideoRecorder(modelOfVideoRecorder);
        videoSystem.setIpOfVideoRecorder(ipOfVideoRecorder);
        videoSystem.setSummerArchive(summerArchive);
        videoSystem.setWinterArchive(winterArchive);
        videoSystem.setLoginOfVideoRecorder(loginOfVideoRecorder);
        videoSystem.setPasswordOfVideoRecorder(passwordOfVideoRecorder);
        videoSystem.setCountOfCameras(countOfCameras);
        videoSystem.setModelsOfCameras(modelsOfCameras);
        videoSystem.setIpOfCameras(ipOfCameras);
        videoSystem.setLoginOfCameras(loginOfCameras);
        videoSystem.setPasswordOfCameras(passwordOfCameras);

        return videoSystem;
    }

    public static VideoSystem updateDataVideoSystem(VideoSystem video) {
        String dateOfFoundation = inputData("Enter date of foundation of the video system: ");
        String modelOfVideoRecorder = inputData("Enter model of the video recorder: ");
        String ipOfVideoRecorder = inputData("Enter date of foundation of the video system: ");
        String summerArchive = inputData("Enter count days of summer archive: ");
        String winterArchive = inputData("Enter count days of winter archive: ");
        String loginOfVideoRecorder = inputData("Enter login of the video recorder: ");
        String passwordOfVideoRecorder = inputData("Enter password of the video recorder: ");
        String countOfCameras = inputData("Enter count of the cameras: ");
        String modelsOfCameras = inputData("Enter models of the cameras: ");
        String ipOfCameras = inputData("Enter ip-address of the cameras: ");
        String loginOfCameras = inputData("Enter login of the the cameras: ");
        String passwordOfCameras = inputData("Enter password of the cameras: ");

        video.setDateOfFoundation(dateOfFoundation);
        video.setModelOfVideoRecorder(modelOfVideoRecorder);
        video.setIpOfVideoRecorder(ipOfVideoRecorder);
        video.setSummerArchive(summerArchive);
        video.setWinterArchive(winterArchive);
        video.setLoginOfVideoRecorder(loginOfVideoRecorder);
        video.setPasswordOfVideoRecorder(passwordOfVideoRecorder);
        video.setCountOfCameras(countOfCameras);
        video.setModelsOfCameras(modelsOfCameras);
        video.setIpOfCameras(ipOfCameras);
        video.setLoginOfCameras(loginOfCameras);
        video.setPasswordOfCameras(passwordOfCameras);

        return video;
    }
}
