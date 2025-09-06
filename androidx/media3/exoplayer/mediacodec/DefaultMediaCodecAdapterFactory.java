package androidx.media3.exoplayer.mediacodec;

import E9.u;
import android.content.Context;
import androidx.media3.common.b;
import b3.H;
import d5.v;
import e3.x;
import o3.i;
import o3.j;

public final class DefaultMediaCodecAdapterFactory implements i {
    public final Context a;

    public DefaultMediaCodecAdapterFactory(Context context0) {
        this.a = context0;
    }

    @Override  // o3.i
    public final j j(u u0) {
        int v = H.g(((b)u0.c).n);
        e3.b.u("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + x.D(v));
        o3.b b0 = new o3.b(v, 0);
        o3.b b1 = new o3.b(v, 1);
        v v1 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        v1.a = b0;
        v1.b = b1;
        return v1.h(u0);
    }
}

