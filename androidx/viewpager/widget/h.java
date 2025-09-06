package androidx.viewpager.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import c2.b;
import d2.d;

public final class h extends b {
    public final ViewPager a;

    public h(ViewPager viewPager0) {
        this.a = viewPager0;
        super();
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        boolean z = true;
        super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
        accessibilityEvent0.setClassName("androidx.viewpager.widget.ViewPager");
        ViewPager viewPager0 = this.a;
        if(viewPager0.mAdapter == null || viewPager0.mAdapter.getCount() <= 1) {
            z = false;
        }
        accessibilityEvent0.setScrollable(z);
        if(accessibilityEvent0.getEventType() == 0x1000) {
            a a0 = viewPager0.mAdapter;
            if(a0 != null) {
                accessibilityEvent0.setItemCount(a0.getCount());
                accessibilityEvent0.setFromIndex(viewPager0.mCurItem);
                accessibilityEvent0.setToIndex(viewPager0.mCurItem);
            }
        }
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        d0.l("androidx.viewpager.widget.ViewPager");
        ViewPager viewPager0 = this.a;
        d0.p(viewPager0.mAdapter != null && viewPager0.mAdapter.getCount() > 1);
        if(viewPager0.canScrollHorizontally(1)) {
            d0.a(0x1000);
        }
        if(viewPager0.canScrollHorizontally(-1)) {
            d0.a(0x2000);
        }
    }

    @Override  // c2.b
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        if(super.performAccessibilityAction(view0, v, bundle0)) {
            return true;
        }
        ViewPager viewPager0 = this.a;
        switch(v) {
            case 0x1000: {
                if(viewPager0.canScrollHorizontally(1)) {
                    viewPager0.setCurrentItem(viewPager0.mCurItem + 1);
                    return true;
                }
                return false;
            }
            case 0x2000: {
                if(viewPager0.canScrollHorizontally(-1)) {
                    viewPager0.setCurrentItem(viewPager0.mCurItem - 1);
                    return true;
                }
                return false;
            }
            default: {
                return false;
            }
        }
    }
}

