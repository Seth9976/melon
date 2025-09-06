package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c2.b;
import d2.d;

public final class c extends b {
    public final AppBarLayout a;
    public final CoordinatorLayout b;
    public final BaseBehavior c;

    public c(CoordinatorLayout coordinatorLayout0, BaseBehavior appBarLayout$BaseBehavior0, AppBarLayout appBarLayout0) {
        this.c = appBarLayout$BaseBehavior0;
        this.a = appBarLayout0;
        this.b = coordinatorLayout0;
        super();
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        d0.l("android.widget.ScrollView");
        AppBarLayout appBarLayout0 = this.a;
        if(appBarLayout0.getTotalScrollRange() != 0) {
            BaseBehavior appBarLayout$BaseBehavior0 = this.c;
            View view1 = BaseBehavior.G(appBarLayout$BaseBehavior0, this.b);
            if(view1 != null) {
                int v = appBarLayout0.getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    if(((LayoutParams)appBarLayout0.getChildAt(v1).getLayoutParams()).a != 0) {
                        if(appBarLayout$BaseBehavior0.x() != -appBarLayout0.getTotalScrollRange()) {
                            d0.b(d2.c.j);
                            d0.p(true);
                        }
                        if(appBarLayout$BaseBehavior0.x() == 0) {
                            break;
                        }
                        if(view1.canScrollVertically(-1)) {
                            if(-appBarLayout0.getDownNestedPreScrollRange() == 0) {
                                break;
                            }
                            d0.b(d2.c.k);
                            d0.p(true);
                            return;
                        }
                        d0.b(d2.c.k);
                        d0.p(true);
                        return;
                    }
                }
            }
        }
    }

    @Override  // c2.b
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        AppBarLayout appBarLayout0 = this.a;
        if(v == 0x1000) {
            appBarLayout0.setExpanded(false);
            return true;
        }
        if(v == 0x2000) {
            BaseBehavior appBarLayout$BaseBehavior0 = this.c;
            if(appBarLayout$BaseBehavior0.x() != 0) {
                CoordinatorLayout coordinatorLayout0 = this.b;
                View view1 = BaseBehavior.G(appBarLayout$BaseBehavior0, coordinatorLayout0);
                if(!view1.canScrollVertically(-1)) {
                    appBarLayout0.setExpanded(true);
                    return true;
                }
                int v1 = appBarLayout0.getDownNestedPreScrollRange();
                if(-v1 != 0) {
                    appBarLayout$BaseBehavior0.J(coordinatorLayout0, this.a, view1, -v1, new int[]{0, 0});
                    return true;
                }
            }
            return false;
        }
        return super.performAccessibilityAction(view0, v, bundle0);
    }
}

