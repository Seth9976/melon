package androidx.compose.foundation;

import androidx.media3.session.o1;
import b3.P;
import e3.e;
import e3.j;
import r1.c;

public final class s implements w0, e, j {
    public final int a;
    public final float b;

    public s(float f, int v) {
        this.a = v;
        this.b = f;
        super();
    }

    @Override  // androidx.compose.foundation.w0
    public int a(c c0, int v) {
        return c0.z(this.b);
    }

    @Override  // e3.e
    public void accept(Object object0) {
        if(this.a != 3) {
            ((o1)object0).setVolume(this.b);
            return;
        }
        ((o1)object0).setPlaybackSpeed(this.b);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 1) {
            ((P)object0).onVolumeChanged(this.b);
            return;
        }
        ((P)object0).onVolumeChanged(this.b);
    }
}

