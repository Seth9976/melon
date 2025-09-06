package com.iloen.melon.fragments.melonchart;

import androidx.compose.runtime.l;
import we.n;

public final class w implements n {
    public final int a;
    public final MelonChartPeriodFragment b;
    public final int c;

    public w(MelonChartPeriodFragment melonChartPeriodFragment0, int v, int v1) {
        this.a = v1;
        this.b = melonChartPeriodFragment0;
        this.c = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        return this.a == 0 ? MelonChartPeriodFragment.DivisionPoint$lambda$67(this.b, this.c, ((l)object0), v) : MelonChartPeriodFragment.InfoTime$lambda$66(this.b, this.c, ((l)object0), v);
    }
}

