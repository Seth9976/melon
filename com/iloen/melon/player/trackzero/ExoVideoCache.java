package com.iloen.melon.player.trackzero;

import H0.b;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.exoplayer2.database.ExoDatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/trackzero/ExoVideoCache;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ExoVideoCache {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000E\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\fR\u0014\u0010\u000F\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000F\u0010\fR\u0014\u0010\u0010\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0018\u0010\u0011\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/player/trackzero/ExoVideoCache$Companion;", "", "Landroid/content/Context;", "context", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "getInstance", "(Landroid/content/Context;)Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "", "TAG", "Ljava/lang/String;", "", "ONE_MB", "J", "ONB_GB", "ONE_HUNDRED_MB", "TWO_HUNDRED_MB", "BASE_TOTAL_INTERNAL_MEMORY", "sDownloadCache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final SimpleCache getInstance(@NotNull Context context0) {
            long v2;
            q.g(context0, "context");
            if(ExoVideoCache.a == null) {
                File file0 = FileUtils.getExoPlayerCacheDir(context0);
                try {
                    File file1 = Environment.getDataDirectory();
                    StatFs statFs0 = new StatFs(file1.getPath());
                    long v = statFs0.getBlockSizeLong();
                    long v1 = statFs0.getBlockCountLong();
                    LogU.v("DownloadUtils", "getTotalInternalStorageSize() path: " + file1);
                    LogU.v("DownloadUtils", "getTotalInternalStorageSize() blockSize: " + v);
                    LogU.v("DownloadUtils", "getTotalInternalStorageSize() totalBlocks: " + v1);
                    v2 = v1 * v;
                    LogU.v("DownloadUtils", "getTotalInternalStorageSize() totalBlockSize: " + v2);
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    LogU.e("DownloadUtils", "getTotalInternalStorageSize() error: " + illegalArgumentException0.toString());
                    v2 = 0L;
                }
                long v3 = v2 <= 0x800000000L ? 0x6400000L : 0xC800000L;
                LogU.Companion.d("ExoVideoCache", b.g(v3 / 0x100000L, "getInstance() cacheSize: ", " MB"));
                ExoVideoCache.a = new SimpleCache(file0, new LeastRecentlyUsedCacheEvictor(v3), new ExoDatabaseProvider(context0));
            }
            return ExoVideoCache.a;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public static SimpleCache a;

    static {
        ExoVideoCache.Companion = new Companion(null);
    }
}

