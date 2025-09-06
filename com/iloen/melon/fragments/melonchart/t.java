package com.iloen.melon.fragments.melonchart;

import we.o;

public final class t implements o {
    public final int a;
    public final MelonChartHotTrackListFragment b;

    public t(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, int v) {
        this.a = v;
        this.b = melonChartHotTrackListFragment0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object0));
        int v1 = (int)(((Integer)object1));
        int v2 = (int)(((Integer)object2));
        return this.a == 0 ? MelonChartHotTrackListFragment.onViewCreated$lambda$8$lambda$4(this.b, v, v1, v2) : MelonChartHotTrackListFragment.onViewCreated$lambda$8$lambda$6(this.b, v, v1, v2);
    }
}

