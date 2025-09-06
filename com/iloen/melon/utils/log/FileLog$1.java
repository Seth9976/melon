package com.iloen.melon.utils.log;

import java.io.File;
import java.io.FileFilter;

class FileLog.1 implements FileFilter {
    public final FileLog a;

    public FileLog.1(FileLog fileLog0) {
        this.a = fileLog0;
    }

    @Override
    public boolean accept(File file0) {
        return file0.getName().contains(this.a.a);
    }
}

