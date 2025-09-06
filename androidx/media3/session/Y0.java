package androidx.media3.session;

import I6.V;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import b3.S;
import ea.d;
import java.util.HashMap;

public abstract class y0 {
    public final n0 a;
    public static final Object b;
    public static final HashMap c;

    static {
        y0.b = new Object();
        y0.c = new HashMap();
    }

    public y0(Context context0, S s0, PendingIntent pendingIntent0, V v0, V v1, V v2, e0 e00, Bundle bundle0, Bundle bundle1, d d0) {
        synchronized(y0.b) {
            HashMap hashMap0 = y0.c;
            if(!hashMap0.containsKey("")) {
                hashMap0.put("", this);
                this.a = new n0(((f0)this), context0, s0, pendingIntent0, v0, v1, v2, e00, bundle0, bundle1, d0);
                return;
            }
        }
        throw new IllegalStateException("Session ID must be unique. ID=");
    }

    public final S a() {
        return (S)this.a.t.b;
    }

    public final boolean b(w0 w00) {
        this.a.getClass();
        return w00.b == 0 && w00.a().equals("com.google.android.projection.gearhead");
    }
}

