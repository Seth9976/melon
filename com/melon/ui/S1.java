package com.melon.ui;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.jvm.internal.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

public final class s1 extends a implements we.a {
    public final CoroutineScope a;
    public final u1 b;
    public final b0 c;

    public s1(CoroutineScope coroutineScope0, u1 u10, b0 b00) {
        this.a = coroutineScope0;
        this.b = u10;
        this.c = b00;
        super(0, 8, p.class, e.NO_RECEIVER, "refresh", "onViewCreated$lambda$9$refresh(Lkotlinx/coroutines/CoroutineScope;Lcom/melon/ui/MainBottomTabInnerBaseFragment;Landroidx/compose/runtime/MutableState;)Lkotlinx/coroutines/Job;");
    }

    @Override  // we.a
    public final Object invoke() {
        t1 t10 = new t1(this.b, this.c, null);
        BuildersKt__Builders_commonKt.launch$default(this.a, null, null, t10, 3, null);
        return H.a;
    }
}

