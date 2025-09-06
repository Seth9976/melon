package com.iloen.melon.utils.log;

import java.io.File;
import java.util.Comparator;

class FileLog.2 implements Comparator {
    public int compare(File file0, File file1) {
        return (int)(file0.lastModified() - file1.lastModified());
    }

    @Override
    public int compare(Object object0, Object object1) {
        return this.compare(((File)object0), ((File)object1));
    }
}

