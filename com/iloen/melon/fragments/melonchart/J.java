package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;

public final class j implements View.OnClickListener {
    public final int a;
    public final Object b;

    public j(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                AgeAdapter.onBindViewImpl$lambda$5(((AgeAdapter)this.b), view0);
                return;
            }
            case 1: {
                ArtistHeaderHolder._init_$lambda$1(((MelonChartArtistFragment)this.b), view0);
                return;
            }
            case 2: {
                InnerAdapter.onCreateViewHolderImpl$lambda$2$lambda$1(((InnerAdapter)this.b), view0);
                return;
            }
            default: {
                MelonChartReportBottomSheetFragment.initCloseButton$lambda$1$lambda$0(((MelonChartReportBottomSheetFragment)this.b), view0);
            }
        }
    }
}

