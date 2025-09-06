package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache.Editor;
import com.bumptech.glide.disklrucache.DiskLruCache.Value;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;
import jeb.synthetic.FIN;

public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final long maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private static DiskLruCacheWrapper wrapper;
    private final DiskCacheWriteLocker writeLocker;

    @Deprecated
    public DiskLruCacheWrapper(File file0, long v) {
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = file0;
        this.maxSize = v;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public void clear() {
        int v;
        __monitor_enter(this);
        try {
            try {
                v = FIN.finallyOpen$NT();
                this.getDiskCache().delete();
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", iOException0);
                }
            }
        }
        catch(Throwable throwable0) {
            this.resetDiskCache();
            FIN.finallyExec$NT(v);
            throw throwable0;
        }
        this.resetDiskCache();
        FIN.finallyCodeBegin$NT(v);
        __monitor_exit(this);
        FIN.finallyCodeEnd$NT(v);
    }

    public static DiskCache create(File file0, long v) {
        return new DiskLruCacheWrapper(file0, v);
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key0) {
        String s = this.safeKeyGenerator.getSafeKey(key0);
        try {
            this.getDiskCache().remove(s);
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", iOException0);
            }
        }
    }

    @Deprecated
    public static DiskCache get(File file0, long v) {
        synchronized(DiskLruCacheWrapper.class) {
            if(DiskLruCacheWrapper.wrapper == null) {
                DiskLruCacheWrapper.wrapper = new DiskLruCacheWrapper(file0, v);
            }
            return DiskLruCacheWrapper.wrapper;
        }
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key0) {
        String s = this.safeKeyGenerator.getSafeKey(key0);
        if(Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + s + " for for Key: " + key0);
        }
        try {
            Value diskLruCache$Value0 = this.getDiskCache().get(s);
            if(diskLruCache$Value0 != null) {
                return diskLruCache$Value0.getFile(0);
            }
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", iOException0);
            }
        }
        return null;
    }

    private DiskLruCache getDiskCache() {
        synchronized(this) {
            if(this.diskLruCache == null) {
                this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
            }
            return this.diskLruCache;
        }
    }

    @Override  // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key0, Writer diskCache$Writer0) {
        Editor diskLruCache$Editor0;
        String s = this.safeKeyGenerator.getSafeKey(key0);
        this.writeLocker.acquire(s);
        try {
            if(Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + s + " for for Key: " + key0);
            }
            try {
                DiskLruCache diskLruCache0 = this.getDiskCache();
                if(diskLruCache0.get(s) == null) {
                    diskLruCache$Editor0 = diskLruCache0.edit(s);
                    if(diskLruCache$Editor0 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + s);
                    }
                    goto label_11;
                }
                return;
            }
            catch(IOException iOException0) {
                goto label_21;
            }
            try {
            label_11:
                if(diskCache$Writer0.write(diskLruCache$Editor0.getFile(0))) {
                    diskLruCache$Editor0.commit();
                }
                goto label_18;
            }
            catch(Throwable throwable0) {
                try {
                    diskLruCache$Editor0.abortUnlessCommitted();
                    throw throwable0;
                label_18:
                    diskLruCache$Editor0.abortUnlessCommitted();
                    return;
                }
                catch(IOException iOException0) {
                }
            }
        label_21:
            if(Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", iOException0);
            }
        }
        finally {
            this.writeLocker.release(s);
        }
    }

    private void resetDiskCache() {
        synchronized(this) {
            this.diskLruCache = null;
        }
    }
}

