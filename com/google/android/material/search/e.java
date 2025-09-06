package com.google.android.material.search;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment.ChartReportFragment;
import com.iloen.melon.fragments.settings.SettingMainFragment;

public final class e implements View.OnTouchListener {
    public final int a;

    public e(int v) {
        this.a = v;
        super();
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        switch(this.a) {
            case 0: {
                return true;
            }
            case 1: {
                return ChartReportFragment.f0(view0, motionEvent0);
            }
            default: {
                return SettingMainFragment.d0(view0, motionEvent0);
            }
        }
    }
}

