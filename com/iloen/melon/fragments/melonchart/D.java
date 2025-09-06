package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;

public final class d implements View.OnClickListener {
    public final int a;
    public final MelonChartAgeFragment b;

    public d(MelonChartAgeFragment melonChartAgeFragment0, int v) {
        this.a = v;
        this.b = melonChartAgeFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MelonChartAgeFragment.onViewCreated$lambda$5(this.b, view0);
            return;
        }
        MelonChartAgeFragment.onViewCreated$lambda$4(this.b, view0);
    }
}

