package qd;

import Q1.c;
import V4.u;
import android.widget.RemoteViews;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import sd.o;
import we.a;
import we.n;

public final class b implements n {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final Object e;

    public b(int v, String s, int v1, boolean z, boolean z1) {
        this.a = 0;
        super();
        this.e = s;
        this.b = z;
        this.c = z1;
        this.d = v1;
    }

    public b(boolean z, B2.n n0, int v, boolean z1) {
        this.a = 2;
        super();
        this.b = z;
        this.e = n0;
        this.d = v;
        this.c = z1;
    }

    public b(boolean z, boolean z1, a a0, int v) {
        this.a = 1;
        super();
        this.b = z;
        this.c = z1;
        this.e = a0;
        this.d = v;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                h.b(((String)this.e), this.b, this.c, ((l)object0), 1, this.d);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                o.h(this.b, this.c, ((a)this.e), ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
            default: {
                B2.n n0 = (B2.n)this.e;
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    if(this.b) {
                        ((p)(((l)object0))).a0(-722003131);
                        RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", 0x7F0D02ED);  // layout:glance_button
                        remoteViews0.setImageViewResource(0x7F0A01CA, this.d);  // id:button
                        remoteViews0.setInt(0x7F0A01CA, "setAlpha", (this.c ? 0xFF : 77));  // id:button
                        c.a(remoteViews0, u.n(n0), ((p)(((l)object0))), 0);
                    }
                    else {
                        ((p)(((l)object0))).a0(0xD358DF6A);
                    }
                    ((p)(((l)object0))).p(false);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
        }
    }
}

