package com.iloen.melon.fragments.melonchart;

import com.iloen.melon.fragments.MetaContentBaseFragment;
import we.a;

public final class x implements a {
    public final int a;
    public final MetaContentBaseFragment b;

    public x(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$51$lambda$47$lambda$46(((MelonChartPeriodFragment)this.b));
            }
            case 1: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$56$lambda$55$lambda$54(((MelonChartPeriodFragment)this.b));
            }
            case 2: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$59$lambda$58$lambda$57(((MelonChartPeriodFragment)this.b));
            }
            case 3: {
                return MelonChartPeriodFragment.initPromoBanner$lambda$30$lambda$29$lambda$28(((MelonChartPeriodFragment)this.b));
            }
            case 4: {
                return MelonChartPeriodFragment.setAllCheckButtonVisibility$lambda$44$lambda$43$lambda$42(((MelonChartPeriodFragment)this.b));
            }
            case 5: {
                return MelonChartPeriodFragment.initHot100PromoBanner$lambda$40$lambda$39$lambda$38(((MelonChartPeriodFragment)this.b));
            }
            default: {
                return ChartReportFragment.animScroll_delegate$lambda$7(((ChartReportFragment)this.b));
            }
        }
    }
}

