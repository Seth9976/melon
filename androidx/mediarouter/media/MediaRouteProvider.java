package androidx.mediarouter.media;

import Bb.e;
import android.content.ComponentName;
import android.content.Context;
import d5.t;
import df.B;
import java.util.Objects;
import kb.D;
import l4.A;
import l4.Q;
import l4.v;
import l4.y;
import l4.z;

public abstract class MediaRouteProvider {
    public final Context a;
    public final D b;
    public final e c;
    public t d;
    public v e;
    public boolean f;
    public B g;
    public boolean h;

    public MediaRouteProvider(Context context0) {
        this(context0, null);
    }

    public MediaRouteProvider(Context context0, D d0) {
        this.c = new e(this, 17);
        if(context0 == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.a = context0;
        if(d0 == null) {
            this.b = new D(new ComponentName(context0, this.getClass()), 6);
            return;
        }
        this.b = d0;
    }

    public y a(String s, A a0) {
        if(s == null) {
            throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
        }
        return null;
    }

    public z b(String s) {
        if(s == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        return null;
    }

    public z c(String s, String s1) {
        if(s == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if(s1 == null) {
            throw new IllegalArgumentException("routeGroupId cannot be null");
        }
        return this.d(s, A.b);
    }

    public z d(String s, A a0) {
        return this.b(s);
    }

    public void e(v v0) {
    }

    public final void f(B b0) {
        Q.b();
        if(this.g != b0) {
            this.g = b0;
            if(!this.h) {
                this.h = true;
                this.c.sendEmptyMessage(1);
            }
        }
    }

    public final void g(v v0) {
        Q.b();
        if(!Objects.equals(this.e, v0)) {
            this.e = v0;
            if(!this.f) {
                this.f = true;
                this.c.sendEmptyMessage(2);
            }
        }
    }
}

