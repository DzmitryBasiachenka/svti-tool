package com.bsdim.svtit.repository.video;

import com.bsdim.svtit.domain.video.Video;
import com.bsdim.svtit.repository.ICrud;
import com.bsdim.svtit.repository.file.FileRepositoryAbstract;


public class VideoRepository extends FileRepositoryAbstract<Video> implements ICrud<String, Video> {

    public VideoRepository() {
        super("video.dat");
    }

    @Override
    public void create(Video entity) {

    }

    @Override
    public Video read(String key) {
        return null;
    }

    @Override
    public void update(Video entity) {

    }

    @Override
    public void delete(String key) {

    }
}
