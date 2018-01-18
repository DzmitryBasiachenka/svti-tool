package com.bsdim.svtit.app.video;

import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.service.video.VideoSystemService;

public class VideoSystemFacade {
    private VideoSystemService service = new VideoSystemService();

    public VideoSystem findByName(String name) {
        return service.findByName(name);
    }
}
