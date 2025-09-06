package w7;

import A8.I;
import A8.a;
import A8.h;
import B3.F;
import B3.L;
import B3.t;
import G8.i;
import H4.b;
import H4.c;
import I4.g;
import I8.j;
import I8.m;
import Jc.X;
import Jc.e0;
import Nc.v1;
import R6.e;
import android.content.Context;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogU;
import java.security.KeyFactory;
import java.security.Provider;
import javax.crypto.Cipher;
import kotlin.jvm.internal.q;
import z6.f;

public final class d implements t, H4.d, e, Ud.d, Ud.e {
    public final int a;
    public static d b;

    public d(int v) {
        this.a = v;
        super();
    }

    public d(f f0) {
        this.a = 24;
        super();
    }

    @Override  // H4.d
    public H4.e a(c c0) {
        return new g(((Context)c0.c), ((String)c0.d), ((b)c0.e), c0.a, c0.b);
    }

    public static a b(String s) {
        a[] arr_a = a.values();
        for(int v = 0; v < arr_a.length; ++v) {
            a a0 = arr_a[v];
            if(a0.a.equals(s)) {
                return a0 == null ? a.c : a0;
            }
        }
        return a.c;
    }

    public static h c(String s) {
        h[] arr_h = h.values();
        for(int v = 0; v < arr_h.length; ++v) {
            h h0 = arr_h[v];
            if(h0.a.equals(s)) {
                return h0 == null ? h.c : h0;
            }
        }
        return h.c;
    }

    public static A8.t d(Integer integer0) {
        A8.t[] arr_t = A8.t.values();
        for(int v = 0; v < arr_t.length; ++v) {
            A8.t t0 = arr_t[v];
            if(t0.a == ((int)integer0)) {
                return t0 == null ? A8.t.c : t0;
            }
        }
        return A8.t.c;
    }

    public static I e(String s) {
        q.g(s, "name");
        I[] arr_i = I.values();
        for(int v = 0; v < arr_i.length; ++v) {
            I i0 = arr_i[v];
            if(q.b(i0.name(), s)) {
                return i0 == null ? I.d : i0;
            }
        }
        return I.d;
    }

    @Override  // B3.t
    public void endTracks() {
        throw new UnsupportedOperationException();
    }

    public i f() {
        i i0 = i.b;
        if(i0 == null) {
            synchronized(this) {
                i i1 = i.b;
                if(i1 == null) {
                    i1 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
                    i.b = i1;
                }
                return i1;
            }
        }
        return i0;
    }

    public j g() {
        j j0 = j.f;
        if(j0 == null) {
            synchronized(this) {
                j j1 = j.f;
                if(j1 == null) {
                    if(StorageUtils.isScopedStorage()) {
                        j1 = new m(1);
                        LogU.info$default(j1.b, "MediaStoreSyncForScopedStorage.int()", null, false, 6, null);
                    }
                    else {
                        j1 = new m(0);
                        LogU.info$default(j1.b, "MediaStoreSyncForLegacy.int()", null, false, 6, null);
                    }
                    j.f = j1;
                }
                return j1;
            }
        }
        return j0;
    }

    @Override  // R6.e
    public Object k(Provider provider0) {
        if(this.a != 28) {
            return provider0 == null ? KeyFactory.getInstance("AES/GCM/NoPadding") : KeyFactory.getInstance("AES/GCM/NoPadding", provider0);
        }
        return provider0 == null ? Cipher.getInstance("AES/GCM/NoPadding") : Cipher.getInstance("AES/GCM/NoPadding", provider0);
    }

    @Override  // B3.t
    public void n(F f0) {
        throw new UnsupportedOperationException();
    }

    @Override  // Ud.e, Ud.d
    public Object onChange(Object object0, boolean z) {
        switch(this.a) {
            case 19: {
                q.g(((e0)object0), "state");
                return ((e0)object0) instanceof X && ((X)(((e0)object0))).b ? X.a(((X)(((e0)object0))), z, false, 0xBFFFFF) : ((e0)object0);
            }
            case 21: {
                q.g(((e0)object0), "state");
                return ((e0)object0) instanceof X && ((X)(((e0)object0))).b ? X.a(((X)(((e0)object0))), z, false, 0xBFFFFF) : ((e0)object0);
            }
            case 26: {
                q.g(((v1)object0), "state");
                return v1.a(((v1)object0), false, z, 0x5FF);
            }
            default: {
                q.g(((v1)object0), "state");
                return v1.a(((v1)object0), false, z, 0x5FF);
            }
        }
    }

    @Override  // B3.t
    public L track(int v, int v1) {
        throw new UnsupportedOperationException();
    }
}

