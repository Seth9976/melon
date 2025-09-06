package com.iloen.melon.custom.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.fragment.app.I;
import androidx.viewpager.widget.a;
import b3.Z;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import n8.q;

public class FiveItemTabLayout extends AbsTabIndicatorLayout {
    public FiveItemTabLayout(Context context0) {
        this(context0, null);
    }

    public FiveItemTabLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void a(TabInfo tabInfo0, int v) {
        if(this.a == null) {
            LogU.w("FiveItemTabLayout", "TabContainer is invalid!!");
            return;
        }
        TabView tabView0 = new TabView(this.getContext());
        tabView0.setTabInfo(tabInfo0);
        tabView0.setId(v);
        tabView0.setFocusable(true);
        tabView0.setOnClickListener(this.h);
        tabView0.measure(0, 0);
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-2, -1);
        this.a.addView(tabView0, linearLayout$LayoutParams0);
        this.a.measure(0, 0);
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void b() {
        int v = Math.min(this.getResources().getDisplayMetrics().widthPixels, this.getResources().getDisplayMetrics().heightPixels);
        Z.r(v, "Layout Width: ", "FiveItemTabLayout");
        a a0 = this.b.getAdapter();
        if(a0 instanceof q) {
            int v2 = ((q)a0).a.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                I i0 = ((q)a0).getItem(v3);
                if(i0 instanceof MelonBaseFragment) {
                    TabInfo tabInfo0 = ((MelonBaseFragment)i0).getTabInfo();
                    tabInfo0.k = 0.0f;
                    tabInfo0.l = 0.0f;
                }
            }
        }
        super.b();
        if(a0 instanceof q) {
            int v4 = ((q)a0).a.size();
            int v6 = 0;
            for(int v5 = 0; v5 < v4; ++v5) {
                View view0 = this.a.getChildAt(v5);
                v6 += view0.getMeasuredWidth();
                LogU.d("FiveItemTabLayout", "child width: " + view0.getMeasuredWidth());
            }
            LogU.d("FiveItemTabLayout", "total width: " + v6);
            int v7 = (v - v6 - ScreenUtils.dipToPixel(this.getContext(), 16.0f)) / (v4 * 2);
            Z.r(v7, "padding: ", "FiveItemTabLayout");
            for(int v1 = 0; v1 < v4; ++v1) {
                View view1 = this.a.getChildAt(v1);
                int v8 = v1 == 0 ? ScreenUtils.dipToPixel(this.getContext(), 8.0f) + v7 : v7;
                int v9 = v1 == v4 - 1 ? ScreenUtils.dipToPixel(this.getContext(), 8.0f) + v7 : v7;
                view1.setPadding(v8, view1.getPaddingTop(), v9, view1.getPaddingBottom());
            }
        }
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void d() {
        View.inflate(this.getContext(), 0x7F0D086A, this);  // layout:tab_layout_fix
        this.a = (LinearLayout)this.findViewById(0x7F0A0B12);  // id:tab_container
    }

    @Override  // com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout
    public final void onPageSelected(int v) {
        this.setCurrentItem(v);
        super.onPageSelected(v);
    }
}

