package com.bsdim.svtit.service.video;

import java.util.List;

import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.repository.video.VideoSystemRepository;

/**
 * The video system service.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class VideoSystemService {
    private VideoSystemRepository repository = new VideoSystemRepository();

    /**
     * Addes video system.
     *
     * @param videoSystem the video system.
     */
    public void addVideoSystem(VideoSystem videoSystem) {
        repository.create(videoSystem);
    }

    /**
     * Finds video system by name.
     *
     * @param name the name.
     * @return the video system.
     */
    public VideoSystem findByName(String name) {
        return repository.read(name);
    }

    /**
     * Updates video system.
     *
     * @param videoSystem the video system.
     */
    public void updateVideoSystem(VideoSystem videoSystem) {
        repository.update(videoSystem);
    }

    /**
     * Deletes video system.
     *
     * @param name the name.
     */
    public void deleteVideoSystem(String name) {
        repository.delete(name);
    }

    public List<VideoSystem> getVideoSystems() {
        return repository.getVideoSystems();
    }
}
