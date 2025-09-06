package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import java.io.File;

class DataCacheWriter implements Writer {
    private final Object data;
    private final Encoder encoder;
    private final Options options;

    public DataCacheWriter(Encoder encoder0, Object object0, Options options0) {
        this.encoder = encoder0;
        this.data = object0;
        this.options = options0;
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache$Writer
    public boolean write(File file0) {
        return this.encoder.encode(this.data, file0, this.options);
    }
}

