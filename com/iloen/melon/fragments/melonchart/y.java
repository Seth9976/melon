package com.iloen.melon.fragments.melonchart;

import androidx.compose.runtime.l;
import we.n;

public final class y implements n {
    public final int a;
    public final MelonChartPeriodFragment b;

    public y(MelonChartPeriodFragment melonChartPeriodFragment0, int v) {
        this.a = v;
        this.b = melonChartPeriodFragment0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        switch(this.a) {
            case 0: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$44(this.b, ((l)object0), v);
            }
            case 1: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$51(this.b, ((l)object0), v);
            }
            case 2: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$56(this.b, ((l)object0), v);
            }
            default: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$59(this.b, ((l)object0), v);
            }
        }
    }
}

