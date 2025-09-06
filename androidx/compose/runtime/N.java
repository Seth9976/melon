package androidx.compose.runtime;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import m0.b;
import m0.g;
import me.i;

public final class n extends s {
    public final int a;
    public final boolean b;
    public final boolean c;
    public HashSet d;
    public final LinkedHashSet e;
    public final b0 f;
    public final p g;

    public n(p p0, int v, boolean z, boolean z1, V v1) {
        this.g = p0;
        this.a = v;
        this.b = z;
        this.c = z1;
        this.e = new LinkedHashSet();
        this.f = new ParcelableSnapshotMutableState(g.d, V.d);  // 初始化器: Landroidx/compose/runtime/O0;-><init>(Ljava/lang/Object;Landroidx/compose/runtime/P0;)V
    }

    @Override  // androidx.compose.runtime.s
    public final void a(v v0, b b0) {
        this.g.b.a(v0, b0);
    }

    @Override  // androidx.compose.runtime.s
    public final void b() {
        --this.g.z;
    }

    @Override  // androidx.compose.runtime.s
    public final boolean c() {
        return this.g.b.c();
    }

    @Override  // androidx.compose.runtime.s
    public final boolean d() {
        return this.b;
    }

    @Override  // androidx.compose.runtime.s
    public final boolean e() {
        return this.c;
    }

    @Override  // androidx.compose.runtime.s
    public final i0 f() {
        return (i0)((O0)this.f).getValue();
    }

    @Override  // androidx.compose.runtime.s
    public final int g() {
        return this.a;
    }

    @Override  // androidx.compose.runtime.s
    public final i h() {
        return this.g.b.h();
    }

    @Override  // androidx.compose.runtime.s
    public final void i(v v0) {
        this.g.b.i(this.g.g);
        this.g.b.i(v0);
    }

    @Override  // androidx.compose.runtime.s
    public final X j(Y y0) {
        return this.g.b.j(y0);
    }

    @Override  // androidx.compose.runtime.s
    public final void k(Set set0) {
        HashSet hashSet0 = this.d;
        if(hashSet0 == null) {
            hashSet0 = new HashSet();
            this.d = hashSet0;
        }
        hashSet0.add(set0);
    }

    @Override  // androidx.compose.runtime.s
    public final void l(p p0) {
        this.e.add(p0);
    }

    @Override  // androidx.compose.runtime.s
    public final void m(v v0) {
        this.g.b.m(v0);
    }

    @Override  // androidx.compose.runtime.s
    public final void n() {
        ++this.g.z;
    }

    @Override  // androidx.compose.runtime.s
    public final void o(l l0) {
        HashSet hashSet0 = this.d;
        if(hashSet0 != null) {
            for(Object object0: hashSet0) {
                q.e(l0, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                ((Set)object0).remove(((p)l0).c);
            }
        }
        N.a(this.e).remove(l0);
    }

    @Override  // androidx.compose.runtime.s
    public final void p(v v0) {
        this.g.b.p(v0);
    }

    public final void q() {
        LinkedHashSet linkedHashSet0 = this.e;
        if(!linkedHashSet0.isEmpty()) {
            HashSet hashSet0 = this.d;
            if(hashSet0 != null) {
                for(Object object0: linkedHashSet0) {
                    p p0 = (p)object0;
                    for(Object object1: hashSet0) {
                        ((Set)object1).remove(p0.c);
                    }
                }
            }
            linkedHashSet0.clear();
        }
    }
}

