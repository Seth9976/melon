package com.melon.playback.cache;

import U4.F;
import android.content.Context;
import android.net.Uri;
import f9.c;
import g3.b;
import g3.e;
import g3.f;
import g3.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/melon/playback/cache/CacheDataSource;", "Lg3/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Factory", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CacheDataSource extends b {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/playback/cache/CacheDataSource$Factory;", "Lg3/e;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Factory implements e {
        public final Context a;

        public Factory(@NotNull Context context0) {
            q.g(context0, "context");
            super();
            this.a = context0;
        }

        @Override  // g3.e
        public final f createDataSource() {
            return new CacheDataSource(this.a);
        }
    }

    public final Context e;
    public final c f;

    public CacheDataSource(@NotNull Context context0) {
        q.g(context0, "context");
        super(false);
        this.e = context0;
        this.f = new c();
    }

    @Override  // g3.f
    public final void close() {
        this.f.a();
    }

    @Override  // g3.f
    public final Uri getUri() {
        Uri uri0 = this.f.i;
        if(uri0 != null) {
            return uri0;
        }
        q.m("uri");
        throw null;
    }

    @Override  // g3.f
    public final long p(j j0) {
        q.g(j0, "dataSpec");
        String s = F.y(this.e);
        return this.f.d(j0.a, j0.e, s);
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        q.g(arr_b, "buffer");
        return this.f.e(arr_b, v, v1);
    }
}

