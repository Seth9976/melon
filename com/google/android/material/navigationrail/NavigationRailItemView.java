package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View.MeasureSpec;
import com.google.android.material.navigation.NavigationBarItemView;

final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(Context context0) {
        super(context0);
    }

    @Override  // com.google.android.material.navigation.NavigationBarItemView
    public final int getItemDefaultMarginResId() {
        return 0x7F0703B0;  // dimen:mtrl_navigation_rail_icon_margin
    }

    @Override  // com.google.android.material.navigation.NavigationBarItemView
    public final int getItemLayoutResId() {
        return 0x7F0D0542;  // layout:mtrl_navigation_rail_item
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(View.MeasureSpec.getMode(v1) == 0) {
            int v2 = View.MeasureSpec.getSize(v1);
            int v3 = Math.max(this.getMeasuredHeight(), v2);
            this.setMeasuredDimension(this.getMeasuredWidthAndState(), v3);
        }
    }
}

