package com.bsdim.svtit.app.video;

import java.util.List;

import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.service.video.VideoSystemService;

/**
 * The video system facade.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class VideoSystemFacade {
    private VideoSystemService service = new VideoSystemService();

    /**
     * Adds video system.
     *
     * @param videoSystem the video system.
     */
    public void addVideoSystem(VideoSystem videoSystem) {
        service.addVideoSystem(videoSystem);
    }
    /**
     * Finds video system by name.
     *
     * @param name the name.
     * @return the video sistem.
     */
    public VideoSystem findByName(String name) {
        return service.findByName(name);
    }

    public List<VideoSystem> getVideoSystems() {
        return service.getVideoSystems();
    }

    /**
     * Updates video system.
     *
     * @param videoSystem the video system.
     */
    public void updateVideoSystem(VideoSystem videoSystem) {
        service.updateVideoSystem(videoSystem);
    }

    /**
     * Deleted video system.
     *
     * @param name the name.
     */
    public void deleteVideoSystem(String name) {
        service.deleteVideoSystem(name);
    }
}
