package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import androidx.media3.exoplayer.audio.DefaultAudioSink.Builder;
import androidx.media3.exoplayer.mediacodec.DefaultMediaCodecAdapterFactory;
import j3.s;
import j3.u;
import java.util.ArrayList;
import n3.c;
import n3.g;
import o3.h;
import u3.d;
import z3.b;

public class DefaultRenderersFactory {
    public final Context a;
    public final DefaultMediaCodecAdapterFactory b;
    public final long c;
    public final h d;

    public DefaultRenderersFactory(Context context0) {
        this.a = context0;
        this.b = new DefaultMediaCodecAdapterFactory(context0);
        this.c = 5000L;
        this.d = h.b;
    }

    public s a(Context context0) {
        return new DefaultAudioSink.Builder(context0).a();
    }

    public final e[] b(Handler handler0, y y0, y y1, y y2, y y3) {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(new b(this.a, this.b, this.d, this.c, handler0, y0));
        s s0 = this.a(this.a);
        arrayList0.add(new u(this.a, this.b, this.d, handler0, y1, s0));
        arrayList0.add(new d(y2, handler0.getLooper()));
        arrayList0.add(new p3.b(y3, handler0.getLooper()));
        arrayList0.add(new A3.b());
        arrayList0.add(new g(c.P));
        return (e[])arrayList0.toArray(new e[0]);
    }
}

