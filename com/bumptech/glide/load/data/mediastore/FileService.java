package com.bumptech.glide.load.data.mediastore;

import java.io.File;

class FileService {
    public boolean exists(File file0) {
        return file0.exists();
    }

    public File get(String s) {
        return new File(s);
    }

    public long length(File file0) {
        return file0.length();
    }
}

