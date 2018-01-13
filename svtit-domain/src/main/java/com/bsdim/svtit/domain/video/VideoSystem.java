package main.java.com.bsdim.svtit.domain.video;

public class VideoSystem {
    private String nameObject;
    private String dateOfFoundation;
    private String modelOfVideoRecorder;
    private String ipOfVideoRecorder;
    private String archiveSummer;
    private String archiveWinter;
    private String loginOfVideoRecorder;
    private String passwordOfVideoRecorder;
    private String countOfCameras;
    private String modelsOfCameras;
    private String ipOfCameras;
    private String loginOfCameras;
    private String passwordOfCameras;

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
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

    public String getArchiveSummer() {
        return archiveSummer;
    }

    public void setArchiveSummer(String archiveSummer) {
        this.archiveSummer = archiveSummer;
    }

    public String getArchiveWinter() {
        return archiveWinter;
    }

    public void setArchiveWinter(String archiveWinter) {
        this.archiveWinter = archiveWinter;
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
        return new StringBuilder("Название объекта: ")
                .append(getNameObject())
                .append("\n")
                .append("Дата ввода в эксплуатацию: ")
                .append(getDateOfFoundation())
                .append("\n")
                .append("Модель видеорегистратора: ")
                .append(getModelOfVideoRecorder())
                .append("\n")
                .append("IPv4-адрес видеорегистратора: ")
                .append(getIpOfVideoRecorder())
                .append("\n")
                .append("Архив лето: ")
                .append(getArchiveSummer())
                .append("\n")
                .append("Архив зима: ")
                .append(getArchiveWinter())
                .append("\n")
                .append("Логин видеорегистратора: ")
                .append(getLoginOfVideoRecorder())
                .append("\n")
                .append("Пароль видеорегистратора: ")
                .append(getPasswordOfVideoRecorder())
                .append("\n")
                .append("Количество камер: ")
                .append(getCountOfCameras())
                .append("\n")
                .append("Список моделей камер: ")
                .append(getModelsOfCameras())
                .append("\n")
                .append("IPv4-адреса камер: ")
                .append(getIpOfCameras())
                .append("\n")
                .append("Логин камер: ")
                .append(getLoginOfCameras())
                .append("\n")
                .append("Пароль камер: ")
                .append(getPasswordOfCameras()).toString();
    }
}