package D2;

import B2.c;
import B2.m;
import C2.b;
import J2.o;
import J2.q;
import J2.u;
import O2.a;
import O2.g;
import O2.h;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.widget.j;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import we.n;
import y0.M;

public final class v extends r implements n {
    public final H f;
    public final H g;
    public final H h;
    public final RemoteViews i;
    public final o0 j;
    public final H k;
    public final H l;
    public final H m;
    public final H n;

    public v(H h0, H h1, H h2, Context context0, RemoteViews remoteViews0, o0 o00, H h3, H h4, H h5, U0 u00, H h6, H h7, H h8) {
        this.f = h0;
        this.g = h1;
        this.h = h2;
        this.i = remoteViews0;
        this.j = o00;
        this.k = h3;
        this.l = h5;
        this.m = h7;
        this.n = h8;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ie.H h0 = (ie.H)object0;
        if(((m)object1) instanceof b) {
            H h1 = this.f;
            if(h1.a != null) {
                Log.w("GlanceAppWidget", "More than one clickable defined on the same GlanceModifier, only the last one will be used.");
            }
            h1.a = (m)object1;
            return ie.H.a;
        }
        if(((m)object1) instanceof u) {
            this.g.a = (m)object1;
            return ie.H.a;
        }
        if(((m)object1) instanceof o) {
            this.h.a = (m)object1;
            return ie.H.a;
        }
        if(((m)object1) instanceof c) {
            int v = this.j.a;
            if(((c)(((m)object1))) instanceof c) {
                a a0 = ((c)(((m)object1))).a;
                RemoteViews remoteViews0 = this.i;
                if(a0 instanceof g) {
                    remoteViews0.setInt(v, "setBackgroundColor", M.z(((g)a0).a));
                    return ie.H.a;
                }
                if(a0 instanceof h) {
                    int v1 = ((h)a0).a;
                    if(Build.VERSION.SDK_INT >= 0x1F) {
                        j.d(remoteViews0, v, "setBackgroundColor", v1);
                        return ie.H.a;
                    }
                    remoteViews0.setInt(v, "setBackgroundResource", v1);
                    return ie.H.a;
                }
                Log.w("GlanceAppWidget", "Unexpected background color modifier: " + a0);
                return ie.H.a;
            }
        }
        else {
            if(((m)object1) instanceof q) {
                q q0 = (q)this.k.a;
                this.k.a = q0 == null ? ((q)(((m)object1))) : new q(q0.a.a(((q)(((m)object1))).a), q0.b.a(((q)(((m)object1))).b), q0.c.a(((q)(((m)object1))).c), q0.d.a(((q)(((m)object1))).d), q0.e.a(((q)(((m)object1))).e), q0.f.a(((q)(((m)object1))).f));
                return ie.H.a;
            }
            if(((m)object1) instanceof E) {
                this.l.a = ((E)(((m)object1))).a;
                return ie.H.a;
            }
            if(!(((m)object1) instanceof D2.a)) {
                if(((m)object1) instanceof K) {
                    this.m.a = (m)object1;
                    return ie.H.a;
                }
                if(((m)object1) instanceof K2.b) {
                    this.n.a = (m)object1;
                    return ie.H.a;
                }
                Log.w("GlanceAppWidget", "Unknown modifier \'" + ((m)object1) + "\', nothing done.");
            }
        }
        return ie.H.a;
    }
}

