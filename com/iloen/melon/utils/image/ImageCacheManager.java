package com.iloen.melon.utils.image;

import Cb.i;
import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.FileUtils;
import java.io.File;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import l5.a;
import l5.b;
import l5.f;
import l5.h;
import okhttp3.Cache;
import okio.FileSystem;
import okio.Path.Companion;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R$\u0010\r\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR$\u0010\u0015\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/utils/image/ImageCacheManager;", "", "Lie/H;", "flush", "()V", "reset", "Lokhttp3/Cache;", "a", "Lokhttp3/Cache;", "getGlideDiskCache", "()Lokhttp3/Cache;", "setGlideDiskCache", "(Lokhttp3/Cache;)V", "glideDiskCache", "Ll5/a;", "b", "Ll5/a;", "getCoilDiskCache", "()Ll5/a;", "setCoilDiskCache", "(Ll5/a;)V", "coilDiskCache", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ImageCacheManager {
    public static final int $stable;
    @NotNull
    public static final ImageCacheManager INSTANCE;
    public static Cache a;
    public static a b;

    static {
        ImageCacheManager.INSTANCE = new ImageCacheManager();  // 初始化器: Ljava/lang/Object;-><init>()V
        MelonAppBase.Companion.getClass();
        Context context0 = t.a().getContext();
        i.d(FileUtils.INSTANCE.getLegacyImageCacheDir(context0));
        Context context1 = t.a().getContext();
        File file0 = FileUtils.INSTANCE.getImageCacheDir(context1);
        File file1 = FileUtils.INSTANCE.getCoilImageCacheDir(context1);
        q.g(file0, "<this>");
        if(!file0.exists()) {
            file0.mkdirs();
        }
        q.g(file1, "<this>");
        if(!file1.exists()) {
            file1.mkdirs();
        }
        ImageCacheManager.a = new Cache(file0, 0x6400000L);
        FileSystem fileSystem0 = FileSystem.SYSTEM;
        CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getIO();
        Path path0 = Companion.get$default(Path.Companion, file1, false, 1, null);
        if(path0 == null) {
            throw new IllegalStateException("directory == null");
        }
        ImageCacheManager.b = new h(0x6400000L, coroutineDispatcher0, fileSystem0, path0);
        ImageCacheManager.$stable = 8;
    }

    public final void flush() {
        Cache cache0 = ImageCacheManager.a;
        if(cache0 != null) {
            try {
                cache0.flush();
            }
            catch(Exception unused_ex) {
            }
        }
    }

    @Nullable
    public final a getCoilDiskCache() {
        return ImageCacheManager.b;
    }

    @Nullable
    public final Cache getGlideDiskCache() {
        return ImageCacheManager.a;
    }

    public final void reset() {
        Cache cache0 = ImageCacheManager.a;
        if(cache0 != null) {
            cache0.evictAll();
        }
        a a0 = ImageCacheManager.b;
        if(a0 != null) {
            f f0 = ((h)a0).b;
            synchronized(f0) {
                f0.m();
                b[] arr_b = (b[])f0.f.values().toArray(new b[0]);
                for(int v1 = 0; v1 < arr_b.length; ++v1) {
                    f0.s(arr_b[v1]);
                }
                f0.n = false;
            }
        }
    }

    public final void setCoilDiskCache(@Nullable a a0) {
        ImageCacheManager.b = a0;
    }

    public final void setGlideDiskCache(@Nullable Cache cache0) {
        ImageCacheManager.a = cache0;
    }
}

