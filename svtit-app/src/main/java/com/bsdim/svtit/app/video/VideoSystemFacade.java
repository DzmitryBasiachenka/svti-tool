package com.bsdim.svtit.app.video;

import java.util.List;

import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.service.video.VideoSystemService;

public class VideoSystemFacade {
    private VideoSystemService service = new VideoSystemService();

    public VideoSystem findByName(String name) {
        return service.findByName(name);
    }

    public List<VideoSystem> getVideoSystems() {
        return service.getVideoSystems();
    }

    public void updateVideoSystem(VideoSystem videoSystem) {
        service.updateVideoSystem(videoSystem);
    }

    public void deleteVideoSystem(String name) {
        service.deleteVideoSystem(name);
    }
}
