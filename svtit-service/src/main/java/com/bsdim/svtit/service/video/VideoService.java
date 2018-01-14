package com.bsdim.svtit.service.video;

import com.bsdim.svtit.domain.video.Video;
import com.bsdim.svtit.repository.video.VideoRepository;

public class VideoService {
    private VideoRepository repository = new VideoRepository();

    public void addVideo(Video video) {
        repository.create(video);
    }

    public Video findByName(String name) {
        return repository.read(name);
    }

    public void updateVideo(Video video) {
        repository.update(video);
    }

    public void delete(String name) {
        repository.delete(name);
    }
}
