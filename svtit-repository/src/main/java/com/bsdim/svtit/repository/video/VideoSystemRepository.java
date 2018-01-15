package com.bsdim.svtit.repository.video;

import java.util.List;

import com.bsdim.svtit.domain.video.VideoSystem;
import com.bsdim.svtit.repository.ICrud;
import com.bsdim.svtit.repository.file.FileRepositoryAbstract;


public class VideoSystemRepository extends FileRepositoryAbstract<VideoSystem> implements ICrud<String, VideoSystem> {

    public VideoSystemRepository() {
        super("video-system.dat");
    }

    @Override
    public void create(VideoSystem entity) {
        List<VideoSystem> list = readData();
        list.add(entity);
        writeData(list);
    }

    @Override
    public VideoSystem read(String key) {
        return null;
    }

    @Override
    public void update(VideoSystem entity) {

    }

    @Override
    public void delete(String key) {

    }
}
