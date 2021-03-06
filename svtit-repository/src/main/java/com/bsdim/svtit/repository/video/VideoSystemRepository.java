package com.bsdim.svtit.repository.video;

import java.util.List;

import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.repository.ICrud;
import com.bsdim.svtit.repository.file.AbstractFileRepository;

/**
 * The video system repository.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class VideoSystemRepository extends AbstractFileRepository<VideoSystem> implements ICrud<String, VideoSystem> {
    private static final String VIDEO_SYSTEM_DAT = "videoSystem.dat";

    /**
     * The constructor.
     */
    public VideoSystemRepository() {
        super(VIDEO_SYSTEM_DAT);
    }

    @Override
    public void create(VideoSystem videoSystem) {
        List<VideoSystem> list = readData();
        list.add(videoSystem);
        writeData(list);
    }

    @Override
    public VideoSystem read(String name) {
        List<VideoSystem> list = readData();
        for (VideoSystem videoSystem: list) {
            if (videoSystem.getNameStation().equals(name)) {
                return videoSystem;
            }
        }
        return null;
    }

    @Override
    public void update(VideoSystem videoSystem) {
        List<VideoSystem> list = readData();
        for (int i = 0; i < list.size(); i++) {
            VideoSystem videoSystemName = list.get(i);
            if (videoSystemName.getNameStation().equals(videoSystem.getNameStation())) {
                list.set(i, videoSystem);
                break;
            }
        }
        writeData(list);
    }

    @Override
    public void delete(String name) {
        List<VideoSystem> list = readData();
        for (int i = 0; i < list.size(); i++) {
            VideoSystem videoSystem = list.get(i);
            if (videoSystem.getNameStation().equals(name)) {
                list.remove(i);
                break;
            }
        }
        writeData(list);
    }

    public List<VideoSystem> getVideoSystems() {
        return readData();
    }
}
