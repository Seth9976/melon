package i5;

import P1.c;
import T3.e;
import W.p;
import android.app.ActivityManager;
import android.content.Context;
import android.os.StatFs;
import coil.ImageLoader.Builder;
import coil.memory.MemoryCache.Builder;
import java.io.File;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import l5.h;
import okio.FileSystem;
import okio.Path.Companion;
import okio.Path;
import pc.t;
import r5.b;
import te.j;
import we.a;
import x5.k;

public final class d implements a {
    public final int a;
    public final ImageLoader.Builder b;

    public d(ImageLoader.Builder imageLoader$Builder0, int v) {
        this.a = v;
        this.b = imageLoader$Builder0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        int v3;
        long v2;
        int v = 0;
        if(this.a != 0) {
            k k0 = k.a;
            Context context0 = this.b.a;
            synchronized(k0) {
                h h0 = k.b;
                if(h0 == null) {
                    FileSystem fileSystem0 = FileSystem.SYSTEM;
                    CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getIO();
                    File file0 = context0.getCacheDir();
                    if(file0 == null) {
                        throw new IllegalStateException("cacheDir == null");
                    }
                    file0.mkdirs();
                    File file1 = j.C(file0);
                    Path path0 = Companion.get$default(Path.Companion, file1, false, 1, null);
                    if(path0 == null) {
                        throw new IllegalStateException("directory == null");
                    }
                    try {
                        v2 = 0xA00000L;
                        File file2 = path0.toFile();
                        file2.mkdir();
                        StatFs statFs0 = new StatFs(file2.getAbsolutePath());
                        v2 = P4.a.k(((long)(0.02 * ((double)statFs0.getBlockCountLong()) * ((double)statFs0.getBlockSizeLong()))), 0xA00000L, 0xFA00000L);
                    }
                    catch(Exception unused_ex) {
                    }
                    h h1 = new h(v2, coroutineDispatcher0, fileSystem0, path0);
                    k.b = h1;
                    return h1;
                }
                return h0;
            }
        }
        MemoryCache.Builder memoryCache$Builder0 = new MemoryCache.Builder(this.b.a);
        e e0 = memoryCache$Builder0.d ? new e(10) : new e3.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(memoryCache$Builder0.c) {
            double f = memoryCache$Builder0.b;
            if(f > 0.0) {
                try {
                    Object object0 = c.getSystemService(memoryCache$Builder0.a, ActivityManager.class);
                    q.d(object0);
                    v3 = (memoryCache$Builder0.a.getApplicationInfo().flags & 0x100000) == 0 ? ((ActivityManager)object0).getMemoryClass() : ((ActivityManager)object0).getLargeMemoryClass();
                }
                catch(Exception unused_ex) {
                    v3 = 0x100;
                }
                v = (int)(f * ((double)v3) * 1048576.0);
            }
            if(v > 0) {
                t t0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                t0.a = e0;
                t0.b = new r5.d(v, ((p)t0));
                return new b(t0, e0);
            }
            return new b(new t(e0, 4), e0);
        }
        return new b(new t(e0, 4), e0);
    }
}

