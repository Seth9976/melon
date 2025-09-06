package com.viewpagerindicator;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public final class d extends TextView {
    public int a;
    public final TabPageIndicator b;

    public d(TabPageIndicator tabPageIndicator0, Context context0) {
        this.b = tabPageIndicator0;
        super(context0, null, 0x7F0406AC);  // attr:vpiTabPageIndicatorStyle
    }

    @Override  // android.widget.TextView
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        TabPageIndicator tabPageIndicator0 = this.b;
        if(tabPageIndicator0.f > 0) {
            int v2 = this.getMeasuredWidth();
            int v3 = tabPageIndicator0.f;
            if(v2 > v3) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(v3, 0x40000000), v1);
            }
        }
    }
}

