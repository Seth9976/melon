package com.melon.ui;

import com.iloen.melon.custom.L0;
import com.melon.ui.interfaces.StringProviderImpl;
import ie.H;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import vb.o;
import we.k;

public final class n4 {
    public final o a;
    public final s2 b;
    public final StringProviderImpl c;

    public n4(o o0, s2 s20, StringProviderImpl stringProviderImpl0) {
        q.g(s20, "playlistManager");
        super();
        this.a = o0;
        this.b = s20;
        this.c = stringProviderImpl0;
    }

    public static final Object a(n4 n40, Flow flow0, k k0, i i0) {
        n40.getClass();
        Object object0 = flow0.collect(new m4(k0), i0);
        return object0 == a.a ? object0 : H.a;
    }

    public final void b(N3 n30, T2.a a0, boolean z, k k0, L0 l00) {
        q.g(n30, "event");
        q.g(l00, "progressUpdatable");
        if(n30 instanceof z3) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new Y3(n30, this, null, k0), 2, null);
            return;
        }
        if(n30 instanceof A3) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new Z3(l00, this, n30, k0, null), 2, null);
            return;
        }
        if(n30 instanceof B3) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new a4(n30, k0, this, z, null), 2, null);
            return;
        }
        if(n30 instanceof L3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new c4(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof M3) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new d4(l00, this, n30, k0, null), 2, null);
            return;
        }
        if(n30 instanceof C3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new f4(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof J3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new h4(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof F3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new j4(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof K3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new l4(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof E3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new P3(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof H3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new R3(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof I3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new T3(n30, this, null, k0), 3, null);
            return;
        }
        if(n30 instanceof G3) {
            BuildersKt__Builders_commonKt.launch$default(a0, null, null, new V3(n30, this, null, k0), 3, null);
            return;
        }
        if(!(n30 instanceof D3)) {
            throw new i.n.i.b.a.s.e.M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        BuildersKt__Builders_commonKt.launch$default(a0, null, null, new X3(n30, this, null, k0), 3, null);
    }
}

