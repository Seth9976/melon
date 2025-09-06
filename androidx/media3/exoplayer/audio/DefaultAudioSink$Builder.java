package androidx.media3.exoplayer.audio;

import android.content.Context;
import androidx.media3.session.legacy.V;
import c3.d;
import j3.b;
import j3.s;
import j3.t;

public final class DefaultAudioSink.Builder {
    public final Context a;
    public final b b;
    public V c;
    public boolean d;
    public final t e;
    public final t f;
    public DefaultAudioOffloadSupportProvider g;

    public DefaultAudioSink.Builder(Context context0) {
        this.a = context0;
        this.b = b.c;
        this.e = t.a;
        this.f = t.b;
    }

    public final s a() {
        e3.b.j(!this.d);
        this.d = true;
        if(this.c == null) {
            this.c = new V(new d[0]);
        }
        if(this.g == null) {
            this.g = new DefaultAudioOffloadSupportProvider(this.a);
        }
        return new s(this);
    }
}

