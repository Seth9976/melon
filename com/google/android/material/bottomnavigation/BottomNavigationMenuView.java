package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.iloen.melon.utils.a;
import java.util.ArrayList;

public class BottomNavigationMenuView extends NavigationBarMenuView {
    public final int g0;
    public final int h0;
    public final int i0;
    public final int j0;
    public boolean k0;
    public final ArrayList l0;

    public BottomNavigationMenuView(Context context0) {
        super(context0);
        this.l0 = new ArrayList();
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(-2, -2);
        frameLayout$LayoutParams0.gravity = 17;
        this.setLayoutParams(frameLayout$LayoutParams0);
        Resources resources0 = this.getResources();
        this.g0 = resources0.getDimensionPixelSize(0x7F0700BA);  // dimen:design_bottom_navigation_item_max_width
        this.h0 = resources0.getDimensionPixelSize(0x7F0700BB);  // dimen:design_bottom_navigation_item_min_width
        this.i0 = resources0.getDimensionPixelSize(0x7F0700B4);  // dimen:design_bottom_navigation_active_item_max_width
        this.j0 = resources0.getDimensionPixelSize(0x7F0700B5);  // dimen:design_bottom_navigation_active_item_min_width
    }

    @Override  // com.google.android.material.navigation.NavigationBarMenuView
    public final NavigationBarItemView e(Context context0) {
        return new BottomNavigationItemView(context0);
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getChildCount();
        int v5 = v3 - v1;
        int v7 = 0;
        for(int v6 = 0; v6 < v4; ++v6) {
            View view0 = this.getChildAt(v6);
            if(view0.getVisibility() != 8) {
                if(this.getLayoutDirection() == 1) {
                    int v8 = v2 - v - v7;
                    view0.layout(v8 - view0.getMeasuredWidth(), 0, v8, v5);
                }
                else {
                    view0.layout(v7, 0, view0.getMeasuredWidth() + v7, v5);
                }
                v7 += view0.getMeasuredWidth();
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v17;
        int v21;
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = this.getMenu().l().size();
        int v4 = this.getChildCount();
        ArrayList arrayList0 = this.l0;
        arrayList0.clear();
        int v5 = View.MeasureSpec.getSize(v1);
        int v6 = View.MeasureSpec.makeMeasureSpec(v5, 0x40000000);
        int v7 = this.i0;
        if(!NavigationBarMenuView.f(this.getLabelVisibilityMode(), v3) || !this.k0) {
            int v18 = Math.min(v2 / (v3 == 0 ? 1 : v3), v7);
            int v19 = v2 - v3 * v18;
            for(int v20 = 0; v20 < v4; v20 = a.d(v21, v20, 1, arrayList0)) {
                if(this.getChildAt(v20).getVisibility() == 8) {
                    v21 = 0;
                }
                else if(v19 > 0) {
                    v21 = v18 + 1;
                    --v19;
                }
                else {
                    v21 = v18;
                }
            }
        }
        else {
            View view0 = this.getChildAt(this.getSelectedItemPosition());
            int v9 = view0.getVisibility();
            int v10 = this.j0;
            if(v9 != 8) {
                view0.measure(View.MeasureSpec.makeMeasureSpec(v7, 0x80000000), v6);
                v10 = Math.max(v10, view0.getMeasuredWidth());
            }
            int v11 = v3 - (view0.getVisibility() == 8 ? 0 : 1);
            int v12 = Math.min(v2 - this.h0 * v11, Math.min(v10, v7));
            int v13 = v2 - v12;
            int v14 = Math.min(v13 / (v11 == 0 ? 1 : v11), this.g0);
            int v15 = v13 - v11 * v14;
            for(int v16 = 0; v16 < v4; v16 = a.d(v17, v16, 1, arrayList0)) {
                if(this.getChildAt(v16).getVisibility() == 8) {
                    v17 = 0;
                }
                else {
                    v17 = v16 == this.getSelectedItemPosition() ? v12 : v14;
                    if(v15 > 0) {
                        ++v17;
                        --v15;
                    }
                }
            }
        }
        int v22 = 0;
        for(int v8 = 0; v8 < v4; ++v8) {
            View view1 = this.getChildAt(v8);
            if(view1.getVisibility() != 8) {
                view1.measure(View.MeasureSpec.makeMeasureSpec(((int)(((Integer)arrayList0.get(v8)))), 0x40000000), v6);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
                viewGroup$LayoutParams0.width = view1.getMeasuredWidth();
                v22 = view1.getMeasuredWidth() + v22;
            }
        }
        this.setMeasuredDimension(v22, v5);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.k0 = z;
    }
}

