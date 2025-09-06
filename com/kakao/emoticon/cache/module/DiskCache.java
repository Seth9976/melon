package com.kakao.emoticon.cache.module;

import com.kakao.emoticon.cache.Key;
import java.io.File;

public interface DiskCache {
    public interface Factory {
        public static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
        public static final int DEFAULT_DISK_CACHE_SIZE = 0xFA00000;

        DiskCache build(String arg1);
    }

    public interface Writer {
        boolean write(File arg1);
    }

    void clear();

    void delete(Key arg1);

    File get(Key arg1);

    void put(Key arg1, Writer arg2);
}

