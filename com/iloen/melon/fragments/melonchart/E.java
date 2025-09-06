package com.iloen.melon.fragments.melonchart;

import android.view.View;
import we.k;

public final class e implements k {
    public final int a;
    public final MelonChartBaseFragment b;

    public e(MelonChartBaseFragment melonChartBaseFragment0, int v) {
        this.a = v;
        this.b = melonChartBaseFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.a == 0 ? MelonChartAgeFragment.onViewCreated$lambda$11(((MelonChartAgeFragment)this.b), ((View)object0)) : MelonChartHotTrackListFragment.onViewCreated$lambda$8(((MelonChartHotTrackListFragment)this.b), ((View)object0));
    }
}

