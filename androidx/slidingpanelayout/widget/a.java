package androidx.slidingpanelayout.widget;

import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.drawerlayout.widget.DrawerLayout;
import c2.b;
import d2.c;
import d2.d;

public final class a extends b {
    public final int a;
    public final Rect b;
    public final ViewGroup c;

    public a(DrawerLayout drawerLayout0) {
        this.a = 1;
        this.c = drawerLayout0;
        super();
        this.b = new Rect();
    }

    public a(SlidingPaneLayout slidingPaneLayout0) {
        this.a = 0;
        this.c = slidingPaneLayout0;
        super();
        this.b = new Rect();
    }

    @Override  // c2.b
    public boolean dispatchPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        if(this.a != 1) {
            return super.dispatchPopulateAccessibilityEvent(view0, accessibilityEvent0);
        }
        DrawerLayout drawerLayout0 = (DrawerLayout)this.c;
        if(accessibilityEvent0.getEventType() == 0x20) {
            accessibilityEvent0.getText();
            View view1 = drawerLayout0.e();
            if(view1 != null) {
                int v = drawerLayout0.g(view1);
                drawerLayout0.getClass();
                Gravity.getAbsoluteGravity(v, drawerLayout0.getLayoutDirection());
            }
            return true;
        }
        return super.dispatchPopulateAccessibilityEvent(view0, accessibilityEvent0);
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        if(this.a != 0) {
            super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
            accessibilityEvent0.setClassName("androidx.drawerlayout.widget.DrawerLayout");
            return;
        }
        super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
        accessibilityEvent0.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        Rect rect0 = this.b;
        if(this.a != 0) {
            AccessibilityNodeInfo accessibilityNodeInfo0 = d0.a;
            if(DrawerLayout.e0) {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
            }
            else {
                AccessibilityNodeInfo accessibilityNodeInfo1 = AccessibilityNodeInfo.obtain(accessibilityNodeInfo0);
                super.onInitializeAccessibilityNodeInfo(view0, new d(accessibilityNodeInfo1));
                d0.c = -1;
                accessibilityNodeInfo0.setSource(view0);
                ViewParent viewParent0 = view0.getParentForAccessibility();
                if(viewParent0 instanceof View) {
                    d0.b = -1;
                    accessibilityNodeInfo0.setParent(((View)viewParent0));
                }
                accessibilityNodeInfo1.getBoundsInScreen(rect0);
                d0.k(rect0);
                accessibilityNodeInfo0.setVisibleToUser(accessibilityNodeInfo1.isVisibleToUser());
                accessibilityNodeInfo0.setPackageName(accessibilityNodeInfo1.getPackageName());
                d0.l(accessibilityNodeInfo1.getClassName());
                d0.o(accessibilityNodeInfo1.getContentDescription());
                accessibilityNodeInfo0.setEnabled(accessibilityNodeInfo1.isEnabled());
                accessibilityNodeInfo0.setFocused(accessibilityNodeInfo1.isFocused());
                d0.h(accessibilityNodeInfo1.isAccessibilityFocused());
                accessibilityNodeInfo0.setSelected(accessibilityNodeInfo1.isSelected());
                d0.a(accessibilityNodeInfo1.getActions());
                int v1 = ((ViewGroup)view0).getChildCount();
                for(int v2 = 0; v2 < v1; ++v2) {
                    View view1 = ((ViewGroup)view0).getChildAt(v2);
                    if(DrawerLayout.h(view1)) {
                        accessibilityNodeInfo0.addChild(view1);
                    }
                }
            }
            d0.l("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfo0.setFocusable(false);
            accessibilityNodeInfo0.setFocused(false);
            accessibilityNodeInfo0.removeAction(((AccessibilityNodeInfo.AccessibilityAction)c.e.a));
            accessibilityNodeInfo0.removeAction(((AccessibilityNodeInfo.AccessibilityAction)c.f.a));
            return;
        }
        SlidingPaneLayout slidingPaneLayout0 = (SlidingPaneLayout)this.c;
        AccessibilityNodeInfo accessibilityNodeInfo2 = d0.a;
        AccessibilityNodeInfo accessibilityNodeInfo3 = AccessibilityNodeInfo.obtain(accessibilityNodeInfo2);
        d d1 = new d(accessibilityNodeInfo3);
        super.onInitializeAccessibilityNodeInfo(view0, d1);
        d1.f(rect0);
        d0.j(rect0);
        accessibilityNodeInfo3.getBoundsInScreen(rect0);
        d0.k(rect0);
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo3.isVisibleToUser());
        accessibilityNodeInfo2.setPackageName(accessibilityNodeInfo3.getPackageName());
        d0.l(accessibilityNodeInfo3.getClassName());
        d0.o(accessibilityNodeInfo3.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo3.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo3.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo3.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo3.isFocused());
        d0.h(accessibilityNodeInfo3.isAccessibilityFocused());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo3.isSelected());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo3.isLongClickable());
        d0.a(accessibilityNodeInfo3.getActions());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo3.getMovementGranularities());
        d0.l("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        d0.c = -1;
        accessibilityNodeInfo2.setSource(view0);
        ViewParent viewParent1 = view0.getParentForAccessibility();
        if(viewParent1 instanceof View) {
            d0.b = -1;
            accessibilityNodeInfo2.setParent(((View)viewParent1));
        }
        int v3 = slidingPaneLayout0.getChildCount();
        for(int v = 0; v < v3; ++v) {
            View view2 = slidingPaneLayout0.getChildAt(v);
            if(!slidingPaneLayout0.b(view2) && view2.getVisibility() == 0) {
                view2.setImportantForAccessibility(1);
                accessibilityNodeInfo2.addChild(view2);
            }
        }
    }

    @Override  // c2.b
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup0, View view0, AccessibilityEvent accessibilityEvent0) {
        if(this.a != 0) {
            return DrawerLayout.e0 || DrawerLayout.h(view0) ? super.onRequestSendAccessibilityEvent(viewGroup0, view0, accessibilityEvent0) : false;
        }
        return ((SlidingPaneLayout)this.c).b(view0) ? false : super.onRequestSendAccessibilityEvent(viewGroup0, view0, accessibilityEvent0);
    }
}

