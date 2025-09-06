package androidx.core.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.drawerlayout.widget.DrawerLayout;
import c2.b;
import d2.c;
import d2.d;

public final class f extends b {
    public final int a;

    public f(int v) {
        this.a = v;
        super();
    }

    @Override  // c2.b
    public void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        if(this.a != 0) {
            super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
            return;
        }
        super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
        accessibilityEvent0.setClassName("android.widget.ScrollView");
        accessibilityEvent0.setScrollable(((NestedScrollView)view0).getScrollRange() > 0);
        accessibilityEvent0.setScrollX(((NestedScrollView)view0).getScrollX());
        accessibilityEvent0.setScrollY(((NestedScrollView)view0).getScrollY());
        accessibilityEvent0.setMaxScrollX(((NestedScrollView)view0).getScrollX());
        accessibilityEvent0.setMaxScrollY(((NestedScrollView)view0).getScrollRange());
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        switch(this.a) {
            case 0: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.l("android.widget.ScrollView");
                if(((NestedScrollView)view0).isEnabled()) {
                    int v = ((NestedScrollView)view0).getScrollRange();
                    if(v > 0) {
                        d0.p(true);
                        if(((NestedScrollView)view0).getScrollY() > 0) {
                            d0.b(c.k);
                            d0.b(c.p);
                        }
                        if(((NestedScrollView)view0).getScrollY() < v) {
                            d0.b(c.j);
                            d0.b(c.r);
                        }
                    }
                }
                return;
            }
            case 1: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.m(null);
                return;
            }
            case 2: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.p(false);
                return;
            }
            case 3: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.m(null);
                return;
            }
            default: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                if(!DrawerLayout.h(view0)) {
                    d0.b = -1;
                    d0.a.setParent(null);
                }
            }
        }
    }

    @Override  // c2.b
    public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        if(this.a != 0) {
            return super.performAccessibilityAction(view0, v, bundle0);
        }
        if(!super.performAccessibilityAction(view0, v, bundle0)) {
            if(((NestedScrollView)view0).isEnabled()) {
                int v1 = ((NestedScrollView)view0).getHeight();
                Rect rect0 = new Rect();
                if(((NestedScrollView)view0).getMatrix().isIdentity() && ((NestedScrollView)view0).getGlobalVisibleRect(rect0)) {
                    v1 = rect0.height();
                }
                switch(v) {
                    case 0x2000: 
                    case 0x1020038: {
                        int v5 = ((NestedScrollView)view0).getPaddingBottom();
                        int v6 = ((NestedScrollView)view0).getPaddingTop();
                        int v7 = Math.max(((NestedScrollView)view0).getScrollY() - (v1 - v5 - v6), 0);
                        if(v7 != ((NestedScrollView)view0).getScrollY()) {
                            ((NestedScrollView)view0).p(-((NestedScrollView)view0).getScrollX(), v7 - ((NestedScrollView)view0).getScrollY(), true);
                            return true;
                        }
                        break;
                    }
                    case 0x1000: 
                    case 0x102003A: {
                        int v2 = ((NestedScrollView)view0).getPaddingBottom();
                        int v3 = ((NestedScrollView)view0).getPaddingTop();
                        int v4 = Math.min(((NestedScrollView)view0).getScrollY() + (v1 - v2 - v3), ((NestedScrollView)view0).getScrollRange());
                        if(v4 != ((NestedScrollView)view0).getScrollY()) {
                            ((NestedScrollView)view0).p(-((NestedScrollView)view0).getScrollX(), v4 - ((NestedScrollView)view0).getScrollY(), true);
                            return true;
                        }
                        break;
                    }
                    default: {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }
}

