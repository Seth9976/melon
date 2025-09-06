package com.iloen.melon.fragments.melonchart;

import we.o;

public final class b implements o {
    public final int a;
    public final MelonChartBaseFragment b;

    public b(MelonChartBaseFragment melonChartBaseFragment0, int v) {
        this.a = v;
        this.b = melonChartBaseFragment0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        return this.a == 0 ? MelonChartAgeFragment.onViewCreated$lambda$11$lambda$9(((MelonChartAgeFragment)this.b), ((int)(((Integer)object0))), ((int)(((Integer)object1))), ((int)(((Integer)object2)))) : MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$56$lambda$55$lambda$54$lambda$52(((MelonChartPeriodFragment)this.b), ((int)(((Integer)object0))), ((int)(((Integer)object1))), ((int)(((Integer)object2))));
    }
}

