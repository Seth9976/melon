package com.iloen.melon.custom.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import com.iloen.melon.utils.log.LogU;

public class FixedTabLayout extends AbsTabIndicatorLayout {
    public FixedTabLayout(Context context0) {
        this(context0, null);
    }

    public FixedTabLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void a(TabInfo tabInfo0, int v) {
        if(this.a == null) {
            LogU.w("FixedTabLayout", "TabContainer is invalid!!");
            return;
        }
        TabView tabView0 = new TabView(this.getContext());
        tabView0.setTabInfo(tabInfo0);
        tabView0.setId(v);
        tabView0.setFocusable(true);
        tabView0.setOnClickListener(this.h);
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.a.addView(tabView0, linearLayout$LayoutParams0);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void d() {
        this.a = (LinearLayout)View.inflate(this.getContext(), 0x7F0D086A, this).findViewById(0x7F0A0B12);  // layout:tab_layout_fix
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void onPageSelected(int v) {
        this.setCurrentItem(v);
        super.onPageSelected(v);
    }
}

