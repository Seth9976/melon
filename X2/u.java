package X2;

import android.media.VolumeProvider;
import android.os.Handler;
import androidx.media3.session.l1;
import androidx.media3.session.m1;
import e3.x;
import l4.c;
import l4.d;

public final class u extends VolumeProvider {
    public final int a;
    public final Object b;

    public u(Object object0, int v, int v1, int v2, int v3) {
        this.a = v3;
        this.b = object0;
        super(v, v1, v2);
    }

    @Override  // android.media.VolumeProvider
    public final void onAdjustVolume(int v) {
        if(this.a != 0) {
            l1 l10 = new l1(((m1)this.b), v, 1);
            x.P(((Handler)((m1)this.b).f), l10);
            return;
        }
        c c0 = new c(((d)(((X2.x)this.b))), v, 1);
        ((d)(((X2.x)this.b))).g.c.a.post(c0);
    }

    @Override  // android.media.VolumeProvider
    public final void onSetVolumeTo(int v) {
        if(this.a != 0) {
            l1 l10 = new l1(((m1)this.b), v, 0);
            x.P(((Handler)((m1)this.b).f), l10);
            return;
        }
        c c0 = new c(((d)(((X2.x)this.b))), v, 0);
        ((d)(((X2.x)this.b))).g.c.a.post(c0);
    }
}

