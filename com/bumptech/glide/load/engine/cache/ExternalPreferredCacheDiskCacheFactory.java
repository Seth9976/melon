package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context0) {
        this(context0, "image_manager_disk_cache", 0xFA00000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context0, long v) {
        this(context0, "image_manager_disk_cache", v);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context0, String s, long v) {
        super(new CacheDirectoryGetter() {
            @Override  // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
            public File getCacheDirectory() {
                File file0 = this.getInternalCacheDirectory();
                if(file0 != null && file0.exists()) {
                    return file0;
                }
                File file1 = s.getExternalCacheDir();
                if(file1 != null && file1.canWrite()) {
                    return this.val$diskCacheName == null ? file1 : new File(file1, this.val$diskCacheName);
                }
                return file0;
            }

            private File getInternalCacheDirectory() {
                File file0 = s.getCacheDir();
                if(file0 == null) {
                    return null;
                }
                return this.val$diskCacheName == null ? file0 : new File(file0, this.val$diskCacheName);
            }
        }, v);
    }
}

