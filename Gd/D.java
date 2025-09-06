package gd;

import P.i;
import P.v;
import android.content.Context;
import androidx.compose.runtime.b0;
import cd.X;
import ie.H;
import kotlin.jvm.internal.q;
import m0.b;
import r1.c;
import r1.f;
import r1.l;
import we.k;

public final class d implements k {
    public final int a;
    public final float b;
    public final Object c;
    public final Object d;
    public final Object e;

    public d(Object object0, float f, Object object1, Object object2, int v) {
        this.a = v;
        this.c = object0;
        this.b = f;
        this.d = object1;
        this.e = object2;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            f f0 = new f(((c)this.c).R(((int)(((l)object0).a & 0xFFFFFFFFL))));
            ((b0)this.d).setValue(f0);
            boolean z = Float.compare(((f)((b0)this.d).getValue()).a, this.b) > 0;
            ((b0)this.e).setValue(Boolean.valueOf(z));
            return H.a;
        }
        q.g(((v)object0), "$this$MelonLazyHorizontalGrid");
        X x0 = new X(((B2)this.c).b, 15);
        b b0 = new b(0x49456F69, new gd.f(((B2)this.c).b, this.b, ((Context)this.d), ((k)this.e)), true);
        ((i)(((v)object0))).t(((B2)this.c).b.size(), null, null, x0, b0);
        return H.a;
    }
}

