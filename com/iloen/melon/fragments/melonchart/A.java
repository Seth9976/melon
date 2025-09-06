package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ChartReportRes.Response.FOOTBUTTON;

public final class a implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public a(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                FootButtonHolder.bind$lambda$0(((FootButtonHolder)this.b), ((FOOTBUTTON)this.c), view0);
                return;
            }
            case 1: {
                FootButtonHolder.bind$lambda$1(((FootButtonHolder)this.b), ((FOOTBUTTON)this.c), view0);
                return;
            }
            default: {
                MelonChartPeriodFragment.initChartReportFloatingButton$lambda$24$lambda$19(((MelonChartPeriodFragment)this.b), ((View)this.c), view0);
            }
        }
    }
}

