package com.bsdim.svtit.domain.video;

import java.io.Serializable;

/**
 * The video system.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class VideoSystem implements Serializable {
    private static final String DOUBLE_LINE_FEED = "\n\n";

    private String id;
    private String nameStation;
    private String dateOfFoundation;
    private String modelOfDVR;
    private String ipOfDVR;
    private String summerArchive;
    private String winterArchive;
    private String loginOfDVR;
    private String passwordOfDVR;
    private String countOfCameras;
    private String modelsOfCameras;
    private String ipOfCameras;
    private String loginOfCameras;
    private String passwordOfCameras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public String getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(String dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public String getModelOfDVR() {
        return modelOfDVR;
    }

    public void setModelOfDVR(String modelOfDVR) {
        this.modelOfDVR = modelOfDVR;
    }

    public String getIpOfDVR() {
        return ipOfDVR;
    }

    public void setIpOfDVR(String ipOfDVR) {
        this.ipOfDVR = ipOfDVR;
    }

    public String getSummerArchive() {
        return summerArchive;
    }

    public void setSummerArchive(String summerArchive) {
        this.summerArchive = summerArchive;
    }

    public String getWinterArchive() {
        return winterArchive;
    }

    public void setWinterArchive(String winterArchive) {
        this.winterArchive = winterArchive;
    }

    public String getLoginOfDVR() {
        return loginOfDVR;
    }

    public void setLoginOfDVR(String loginOfDVR) {
        this.loginOfDVR = loginOfDVR;
    }

    public String getPasswordOfDVR() {
        return passwordOfDVR;
    }

    public void setPasswordOfDVR(String passwordOfDVR) {
        this.passwordOfDVR = passwordOfDVR;
    }

    public String getCountOfCameras() {
        return countOfCameras;
    }

    public void setCountOfCameras(String countOfCameras) {
        this.countOfCameras = countOfCameras;
    }

    public String getModelsOfCameras() {
        return modelsOfCameras;
    }

    public void setModelsOfCameras(String modelsOfCameras) {
        this.modelsOfCameras = modelsOfCameras;
    }

    public String getIpOfCameras() {
        return ipOfCameras;
    }

    public void setIpOfCameras(String ipOfCameras) {
        this.ipOfCameras = ipOfCameras;
    }

    public String getLoginOfCameras() {
        return loginOfCameras;
    }

    public void setLoginOfCameras(String loginOfCameras) {
        this.loginOfCameras = loginOfCameras;
    }

    public String getPasswordOfCameras() {
        return passwordOfCameras;
    }

    public void setPasswordOfCameras(String passwordOfCameras) {
        this.passwordOfCameras = passwordOfCameras;
    }

    @Override
    public String toString() {
        return new StringBuilder("Название станции: ")
                .append(getNameStation())
                .append(DOUBLE_LINE_FEED)
                .append("Дата ввода в эксплуатацию: ")
                .append(getDateOfFoundation())
                .append(DOUBLE_LINE_FEED)
                .append("Модель видеорегистратора: ")
                .append(getModelOfDVR())
                .append(DOUBLE_LINE_FEED)
                .append("IPv4-адрес видеорегистратора: ")
                .append(getIpOfDVR())
                .append(DOUBLE_LINE_FEED)
                .append("Архив лето: ")
                .append(getSummerArchive())
                .append(DOUBLE_LINE_FEED)
                .append("Архив зима: ")
                .append(getWinterArchive())
                .append(DOUBLE_LINE_FEED)
                .append("Логин видеорегистратора: ")
                .append(getLoginOfDVR())
                .append(DOUBLE_LINE_FEED)
                .append("Пароль видеорегистратора: ")
                .append(getPasswordOfDVR())
                .append(DOUBLE_LINE_FEED)
                .append("Количество камер: ")
                .append(getCountOfCameras())
                .append(DOUBLE_LINE_FEED)
                .append("Список моделей камер: ")
                .append(getModelsOfCameras())
                .append(DOUBLE_LINE_FEED)
                .append("IPv4-адреса камер: ")
                .append(getIpOfCameras())
                .append(DOUBLE_LINE_FEED)
                .append("Логин камер: ")
                .append(getLoginOfCameras())
                .append(DOUBLE_LINE_FEED)
                .append("Пароль камер: ")
                .append(getPasswordOfCameras()).toString();
    }
}
