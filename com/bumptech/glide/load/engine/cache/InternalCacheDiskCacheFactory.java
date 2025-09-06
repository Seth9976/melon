package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context0) {
        this(context0, "image_manager_disk_cache", 0xFA00000L);
    }

    public InternalCacheDiskCacheFactory(Context context0, long v) {
        this(context0, "image_manager_disk_cache", v);
    }

    public InternalCacheDiskCacheFactory(Context context0, String s, long v) {
        super(new CacheDirectoryGetter() {
            @Override  // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
            public File getCacheDirectory() {
                File file0 = s.getCacheDir();
                if(file0 == null) {
                    return null;
                }
                return this.val$diskCacheName == null ? file0 : new File(file0, this.val$diskCacheName);
            }
        }, v);
    }
}

