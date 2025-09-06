package androidx.media3.session;

import N1.s;
import android.app.Notification.Builder;
import android.app.Notification.MediaStyle;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import androidx.media3.session.legacy.Q;
import d5.i;

public final class g1 extends s {
    public final y0 d;
    public int[] e;

    public g1(y0 y00) {
        this.d = y00;
    }

    @Override  // N1.s
    public final void a(i i0) {
        Notification.Builder notification$Builder0 = (Notification.Builder)i0.b;
        Notification.MediaStyle notification$MediaStyle0 = new Notification.MediaStyle();
        y0 y00 = this.d;
        Notification.MediaStyle notification$MediaStyle1 = notification$MediaStyle0.setMediaSession(((MediaSession.Token)((Q)y00.a.h.k.a).c.b));
        int[] arr_v = this.e;
        if(arr_v != null) {
            notification$MediaStyle1.setShowActionsInCompactView(arr_v);
        }
        notification$Builder0.setStyle(notification$MediaStyle1);
        Bundle bundle0 = new Bundle();
        bundle0.putBundle("androidx.media3.session", y00.a.j.b());
        notification$Builder0.addExtras(bundle0);
    }
}

