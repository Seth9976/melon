package Nb;

import Ma.m;
import android.content.Context;
import com.melon.playback.FloatingLyricService;
import k8.o;
import kc.s2;
import kotlin.jvm.internal.q;
import we.a;

public final class b implements a {
    public final int a;
    public final FloatingLyricService b;

    public b(FloatingLyricService floatingLyricService0, int v) {
        this.a = v;
        this.b = floatingLyricService0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        FloatingLyricService floatingLyricService0 = this.b;
        if(this.a != 0) {
            Context context0 = floatingLyricService0.getApplicationContext();
            q.d(context0);
            return ((o)(((Ma.o)com.google.firebase.b.B(context0, Ma.o.class)))).k();
        }
        Context context1 = floatingLyricService0.getApplicationContext();
        q.d(context1);
        return (s2)((o)(((m)com.google.firebase.b.B(context1, m.class)))).w.get();
    }
}

