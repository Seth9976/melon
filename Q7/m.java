package Q7;

import android.util.Log;
import d5.n;
import df.v;
import ie.H;
import java.io.IOException;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import l2.i;
import ne.a;
import oe.c;
import q2.f;
import q2.h;

public final class m {
    public final i a;
    public g b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;

    static {
        m.c = v.n("firebase_sessions_enabled");
        m.d = new f("firebase_sessions_sampling_rate");
        m.e = v.z("firebase_sessions_restart_timeout");
        m.f = v.z("firebase_sessions_cache_duration");
        m.g = v.B("firebase_sessions_cache_updated_time");
    }

    public m(i i0) {
        q.g(i0, "dataStore");
        super();
        this.a = i0;
        BuildersKt__BuildersKt.runBlocking$default(null, new j(this, null), 1, null);
    }

    public static final void a(m m0, h h0) {
        m0.getClass();
        m0.b = new g(((Boolean)h0.b(m.c)), ((Double)h0.b(m.d)), ((Integer)h0.b(m.e)), ((Integer)h0.b(m.f)), ((Long)h0.b(m.g)));
    }

    public final boolean b() {
        g g0 = this.b;
        if(g0 != null) {
            Long long0 = g0.e;
            if(g0 != null) {
                return long0 == null || g0.d == null || (System.currentTimeMillis() - ((long)long0)) / 1000L >= ((long)(((int)g0.d)));
            }
            q.m("sessionConfigs");
            throw null;
        }
        q.m("sessionConfigs");
        throw null;
    }

    public final Object c(f f0, Object object0, c c0) {
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.B;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.B = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object1 = k0.r;
        a a0 = a.a;
        switch(k0.B) {
            case 0: {
                n.D(object1);
                try {
                    l l0 = new l(object0, f0, this, null);
                    k0.B = 1;
                    if(e.k.n(this.a, l0, k0) == a0) {
                        return a0;
                    }
                }
                catch(IOException iOException0) {
                    Log.w("SettingsCache", "Failed to update cache config value: " + iOException0);
                }
                return H.a;
            }
            case 1: {
                try {
                    n.D(object1);
                }
                catch(IOException iOException0) {
                    Log.w("SettingsCache", "Failed to update cache config value: " + iOException0);
                }
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

