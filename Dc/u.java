package Dc;

import G.a0;
import G.e;
import G.f;
import I.Z0;
import O.F;
import O.v;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import ie.H;
import java.util.HashSet;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.c;
import we.a;
import we.n;

public final class u {
    public final F a;
    public final CoroutineScope b;
    public final n c;
    public final a d;
    public final n e;
    public final float f;
    public final b0 g;
    public final b0 h;
    public final b0 i;
    public Integer j;
    public Integer k;
    public float l;
    public final HashSet m;
    public final B n;
    public final b0 o;
    public final e p;
    public int q;
    public int r;

    public u(F f0, CoroutineScope coroutineScope0, n n0, a a0, n n1, float f1) {
        q.g(f0, "state");
        q.g(coroutineScope0, "scope");
        q.g(n0, "onMove");
        q.g(n1, "onMoveEnd");
        super();
        this.a = f0;
        this.b = coroutineScope0;
        this.c = n0;
        this.d = a0;
        this.e = n1;
        this.f = f1;
        this.g = w.s(null);
        this.h = w.s(0.0f);
        this.i = w.s(0);
        HashSet hashSet0 = new HashSet();
        this.m = hashSet0;
        this.n = new B(f0, coroutineScope0, hashSet0, new s(2, this, u.class, "swapItems", "swapItems(Landroidx/compose/foundation/lazy/LazyListItemInfo;Landroidx/compose/foundation/lazy/LazyListItemInfo;)V", 0, 0));
        this.o = w.s(null);
        this.p = f.a(0.0f);
        this.q = -1;
        this.r = -1;
    }

    public final v a() {
        for(Object object0: ((Iterable)this.a.h().k)) {
            Object object1 = ((O0)this.g).getValue();
            if(((v)object0).j.equals(object1)) {
                return (v)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final float b() {
        int v1;
        v v0 = this.a();
        if(v0 != null) {
            if(this.j == null || v0.a != ((int)this.j)) {
                v1 = this.k == null ? v0.m : ((int)this.k);
            }
            else {
                this.k = null;
                v1 = v0.m;
            }
            float f = (float)((Number)((O0)this.i).getValue()).intValue();
            return ((Number)((O0)this.h).getValue()).floatValue() + f - ((float)v1);
        }
        return 0.0f;
    }

    public final Object c(Object object0, float f, c c0) {
        v v1;
        Dc.q q0;
        if(c0 instanceof Dc.q) {
            q0 = (Dc.q)c0;
            int v = q0.G;
            if((v & 0x80000000) == 0) {
                q0 = new Dc.q(this, c0);
            }
            else {
                q0.G = v ^ 0x80000000;
            }
        }
        else {
            q0 = new Dc.q(this, c0);
        }
        Object object1 = q0.D;
        ne.a a0 = ne.a.a;
        switch(q0.G) {
            case 0: {
                Object object2 = null;
                d5.n.D(object1);
                F f1 = this.a;
                for(Object object3: ((Iterable)f1.h().k)) {
                    if(((v)object3).j.equals(object0)) {
                        object2 = object3;
                        break;
                    }
                }
                v1 = (v)object2;
                if(v1 != null) {
                    a a1 = this.d;
                    if(a1 != null) {
                        a1.invoke();
                    }
                    int v2 = v1.m;
                    if(v2 < 0) {
                        a0 a00 = f.q(0.0f, 7, null);
                        q0.r = object0;
                        q0.w = v1;
                        q0.B = f;
                        q0.G = 1;
                        if(Z0.a(f1, ((float)v2), a00, q0) == a0) {
                            return a0;
                        }
                    }
                    ((O0)this.g).setValue(object0);
                    ((O0)this.i).setValue(v1.m);
                    this.l = f;
                    break;
                }
                break;
            }
            case 1: {
                f = q0.B;
                v v3 = q0.w;
                Object object4 = q0.r;
                d5.n.D(object1);
                v1 = v3;
                object0 = object4;
                ((O0)this.g).setValue(object0);
                ((O0)this.i).setValue(v1.m);
                this.l = f;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public final void d(v v0, v v1) {
        Integer integer0;
        if(v0.a == v1.a) {
            return;
        }
        if(this.q == -1) {
            this.q = v0.a;
        }
        int v2 = v1.a;
        this.r = v2;
        int v3 = v0.a;
        this.k = v2 <= v3 ? v1.m : ((int)(v1.n + v1.m - v0.n));
        this.j = v2;
        F f0 = this.a;
        if(v2 == f0.d.a()) {
            integer0 = v3;
        }
        else {
            integer0 = v3 == f0.d.a() ? v2 : null;
        }
        if(integer0 != null) {
            t t0 = new t(this, v0, v1, null);
            BuildersKt__Builders_commonKt.launch$default(this.b, null, null, t0, 3, null);
            return;
        }
        this.c.invoke(v0, v1);
    }
}

