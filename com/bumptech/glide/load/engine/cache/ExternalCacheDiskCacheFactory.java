package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context0) {
        this(context0, "image_manager_disk_cache", 0xFA00000);
    }

    public ExternalCacheDiskCacheFactory(Context context0, int v) {
        this(context0, "image_manager_disk_cache", v);
    }

    public ExternalCacheDiskCacheFactory(Context context0, String s, int v) {
        super(new CacheDirectoryGetter() {
            @Override  // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
            public File getCacheDirectory() {
                File file0 = s.getExternalCacheDir();
                if(file0 == null) {
                    return null;
                }
                return this.val$diskCacheName == null ? file0 : new File(file0, this.val$diskCacheName);
            }
        }, ((long)v));
    }
}

