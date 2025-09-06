package com.melon.ui;

import com.iloen.melon.custom.L0;
import ea.a;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import we.k;

public final class t3 {
    public final a a;

    public t3(a a0) {
        this.a = a0;
    }

    public final void a(q3 q30, T2.a a0, boolean z, k k0, L0 l00) {
        q.g(q30, "event");
        q.g(l00, "progressUpdatable");
        if(!(q30 instanceof q3)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(!z) {
            k0.invoke(s4.a);
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getDefault(), null, new r3(l00, this, q30, k0, null), 2, null);
    }
}

