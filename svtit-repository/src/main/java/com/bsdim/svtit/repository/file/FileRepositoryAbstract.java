package com.bsdim.svtit.repository.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class FileRepositoryAbstract<T> {
    private static final String FILE_SAVED = "File save";
    private static Logger sLogger = Logger.getLogger(FileRepositoryAbstract.class.getName());
    private String file;

    public FileRepositoryAbstract(String newFile) {
        this.file = newFile;
    }

    public void writeData(List<T> list) {
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file))) {
            write.writeObject(list);
            sLogger.info(FILE_SAVED);
        } catch (Exception ex) {
            sLogger.info(ex.getMessage());
        }
    }

    public List<T> readData() {
        if (new File(file).exists()) {
            try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))) {
                return (List<T>) read.readObject();
            } catch (Exception ex) {
                sLogger.info(ex.getMessage());
            }
        }
        return new ArrayList<>();
    }
}