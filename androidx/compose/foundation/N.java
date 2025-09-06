package androidx.compose.foundation;

import A7.d;
import M.i0;
import android.content.Context;
import kotlin.jvm.internal.q;
import r1.c;
import y0.s;

public final class n {
    public final Context a;
    public final c b;
    public final long c;
    public final i0 d;

    public n(Context context0, c c0, long v, i0 i00) {
        this.a = context0;
        this.b = c0;
        this.c = v;
        this.d = i00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!n.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory");
        if(!q.b(this.a, ((n)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((n)object0).b)) {
            return false;
        }
        return s.d(this.c, ((n)object0).c) ? q.b(this.d, ((n)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + d.c((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c);
    }
}

