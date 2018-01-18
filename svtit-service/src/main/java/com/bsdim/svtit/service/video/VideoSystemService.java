package com.bsdim.svtit.service.video;

import java.util.List;

import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.repository.video.VideoSystemRepository;

public class VideoSystemService {
    private VideoSystemRepository repository = new VideoSystemRepository();

    public void addVideoSystem(VideoSystem videoSystem) {
        repository.create(videoSystem);
    }

    public VideoSystem findByName(String name) {
        return repository.read(name);
    }

    public void updateVideoSystem(VideoSystem videoSystem) {
        repository.update(videoSystem);
    }

    public void delete(String name) {
        repository.delete(name);
    }

    public List<VideoSystem> getVideoSystems() {
        return repository.getVideoSystems();
    }
}
