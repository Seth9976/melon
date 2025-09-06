package com.melon.ui;

import ie.H;
import ie.f;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.a;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.FlowCollector;

public final class x0 implements k, FlowCollector {
    public final int a;
    public final C0 b;

    public x0(C0 c00, int v) {
        this.a = v;
        this.b = c00;
        super();
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        H h0 = H.a;
        C0 c00 = this.b;
        if(this.a != 0) {
            c00.onUiEvent(((I4)object0));
            return h0;
        }
        c00.renderUi(((K4)object0));
        return h0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this.a != 0) {
            return !(object0 instanceof FlowCollector) || !(object0 instanceof k) ? false : this.getFunctionDelegate().equals(((k)object0).getFunctionDelegate());
        }
        return !(object0 instanceof FlowCollector) || !(object0 instanceof k) ? false : this.getFunctionDelegate().equals(((k)object0).getFunctionDelegate());
    }

    @Override  // kotlin.jvm.internal.k
    public final f getFunctionDelegate() {
        return this.a == 0 ? new a(2, 4, C0.class, this.b, "renderUi", "renderUi(Lcom/melon/ui/UiState;)V") : new a(2, 4, C0.class, this.b, "onUiEvent", "onUiEvent(Lcom/melon/ui/UiEvent;)V");
    }

    @Override
    public final int hashCode() {
        return this.getFunctionDelegate().hashCode();
    }
}

