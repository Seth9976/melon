package com.kakao.emoticon.cache;

import com.kakao.emoticon.cache.model.StreamEncoder;
import com.kakao.emoticon.cache.module.DiskCache.Writer;
import com.kakao.emoticon.cache.recycle.LruByteArrayPool;
import java.io.File;
import java.io.InputStream;

public class DataCacheWriter implements Writer {
    private static StreamEncoder encoder;
    private InputStream is;

    static {
        DataCacheWriter.encoder = new StreamEncoder(new LruByteArrayPool());
    }

    public DataCacheWriter(InputStream inputStream0) {
        this.is = inputStream0;
    }

    @Override  // com.kakao.emoticon.cache.module.DiskCache$Writer
    public boolean write(File file0) {
        return DataCacheWriter.encoder.encode(this.is, file0);
    }
}

