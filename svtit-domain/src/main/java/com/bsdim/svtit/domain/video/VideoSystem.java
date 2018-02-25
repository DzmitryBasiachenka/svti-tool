package com.bsdim.svtit.domain.video;

import java.io.Serializable;

public class VideoSystem implements Serializable {
    private String id;
    private String nameStation;
    private String dateOfFoundation;
    private String modelOfVideoRecorder;
    private String ipOfVideoRecorder;
    private String summerArchive;
    private String winterArchive;
    private String loginOfVideoRecorder;
    private String passwordOfVideoRecorder;
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

    public String getModelOfVideoRecorder() {
        return modelOfVideoRecorder;
    }

    public void setModelOfVideoRecorder(String modelOfVideoRecorder) {
        this.modelOfVideoRecorder = modelOfVideoRecorder;
    }

    public String getIpOfVideoRecorder() {
        return ipOfVideoRecorder;
    }

    public void setIpOfVideoRecorder(String ipOfVideoRecorder) {
        this.ipOfVideoRecorder = ipOfVideoRecorder;
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

    public String getLoginOfVideoRecorder() {
        return loginOfVideoRecorder;
    }

    public void setLoginOfVideoRecorder(String loginOfVideoRecorder) {
        this.loginOfVideoRecorder = loginOfVideoRecorder;
    }

    public String getPasswordOfVideoRecorder() {
        return passwordOfVideoRecorder;
    }

    public void setPasswordOfVideoRecorder(String passwordOfVideoRecorder) {
        this.passwordOfVideoRecorder = passwordOfVideoRecorder;
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
                .append("\n\n")
                .append("Дата ввода в эксплуатацию: ")
                .append(getDateOfFoundation())
                .append("\n\n")
                .append("Модель видеорегистратора: ")
                .append(getModelOfVideoRecorder())
                .append("\n\n")
                .append("IPv4-адрес видеорегистратора: ")
                .append(getIpOfVideoRecorder())
                .append("\n\n")
                .append("Архив лето: ")
                .append(getSummerArchive())
                .append("\n\n")
                .append("Архив зима: ")
                .append(getWinterArchive())
                .append("\n\n")
                .append("Логин видеорегистратора: ")
                .append(getLoginOfVideoRecorder())
                .append("\n\n")
                .append("Пароль видеорегистратора: ")
                .append(getPasswordOfVideoRecorder())
                .append("\n\n")
                .append("Количество камер: ")
                .append(getCountOfCameras())
                .append("\n\n")
                .append("Список моделей камер: ")
                .append(getModelsOfCameras())
                .append("\n\n")
                .append("IPv4-адреса камер: ")
                .append(getIpOfCameras())
                .append("\n\n")
                .append("Логин камер: ")
                .append(getLoginOfCameras())
                .append("\n\n")
                .append("Пароль камер: ")
                .append(getPasswordOfCameras()).toString();
    }
}
