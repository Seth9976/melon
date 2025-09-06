package com.melon.ui;

import ie.m;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

public abstract class i3 extends n0 {
    public int a;
    public boolean b;
    public final ArrayList c;
    public final MutableStateFlow d;

    public i3() {
        this.b = true;
        this.c = new ArrayList();
        this.d = StateFlowKt.MutableStateFlow(new m(0, 0));
    }

    public final List b() {
        ArrayList arrayList0 = this.c;
        if(arrayList0.isEmpty()) {
            arrayList0.addAll(this.c());
        }
        return p.P0(arrayList0);
    }

    public abstract List c();
}

