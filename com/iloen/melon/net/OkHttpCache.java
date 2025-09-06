package com.iloen.melon.net;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import k8.t;
import kotlin.Metadata;
import okhttp3.Cache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/net/OkHttpCache;", "", "<init>", "()V", "Lie/H;", "initCache", "flush", "reset", "", "TAG", "Ljava/lang/String;", "", "CACHE_MAX_SIZE", "J", "Lokhttp3/Cache;", "cache", "Lokhttp3/Cache;", "getCache", "()Lokhttp3/Cache;", "setCache", "(Lokhttp3/Cache;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OkHttpCache {
    public static final int $stable = 0;
    private static final long CACHE_MAX_SIZE = 0x500000L;
    @NotNull
    public static final OkHttpCache INSTANCE = null;
    @NotNull
    private static final String TAG = "OkHttpCache";
    @Nullable
    private static Cache cache;

    static {
        OkHttpCache okHttpCache0 = new OkHttpCache();
        OkHttpCache.INSTANCE = okHttpCache0;
        okHttpCache0.initCache();
        OkHttpCache.$stable = 8;
    }

    public final void flush() {
        LogU.Companion.d("OkHttpCache", "flush()");
        try {
            Cache cache0 = OkHttpCache.cache;
            if(cache0 != null) {
                cache0.flush();
            }
        }
        catch(Exception exception0) {
            LogU.Companion.e("OkHttpCache", "flush() e: " + exception0);
        }
    }

    @Nullable
    public final Cache getCache() {
        return OkHttpCache.cache;
    }

    private final void initCache() {
        LogU.Companion.d("OkHttpCache", "initCache()");
        MelonAppBase.Companion.getClass();
        File file0 = FileUtils.getDiskCacheDir(t.a().getContext(), ".http");
        if(!file0.exists()) {
            file0.mkdirs();
        }
        if(OkHttpCache.cache == null) {
            OkHttpCache.cache = new Cache(file0, 0x500000L);
        }
    }

    public final void reset() {
        LogU.Companion.d("OkHttpCache", "reset()");
        try {
            Cache cache0 = OkHttpCache.cache;
            if(cache0 != null) {
                try {
                    cache0.delete();
                }
                catch(Exception exception0) {
                    LogU.Companion.e("OkHttpCache", "reset() e: " + exception0);
                }
            }
        }
        finally {
            OkHttpCache.cache = null;
            this.initCache();
        }
    }

    public final void setCache(@Nullable Cache cache0) {
        OkHttpCache.cache = cache0;
    }
}

