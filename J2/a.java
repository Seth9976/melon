package j2;

import Q0.y;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.W;
import c2.b;
import d2.d;
import d2.f;
import df.v;
import e1.F;
import e3.h;
import java.util.ArrayList;
import java.util.Collections;

public abstract class a extends b {
    public final Rect a;
    public final Rect b;
    public final Rect c;
    public final int[] d;
    public final AccessibilityManager e;
    public final View f;
    public y g;
    public int h;
    public int i;
    public int j;
    public static final Rect k;
    public static final h l;
    public static final F m;

    static {
        a.k = new Rect(0x7FFFFFFF, 0x7FFFFFFF, 0x80000000, 0x80000000);
        a.l = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.m = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public a(View view0) {
        this.a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = new int[2];
        this.h = 0x80000000;
        this.i = 0x80000000;
        this.j = 0x80000000;
        this.f = view0;
        this.e = (AccessibilityManager)view0.getContext().getSystemService("accessibility");
        view0.setFocusable(true);
        if(view0.getImportantForAccessibility() == 0) {
            view0.setImportantForAccessibility(1);
        }
    }

    public final boolean a(int v) {
        if(this.i != v) {
            return false;
        }
        this.i = 0x80000000;
        this.m(v, false);
        this.o(v, 8);
        return true;
    }

    public final AccessibilityEvent b(int v, int v1) {
        View view0 = this.f;
        if(v != -1) {
            AccessibilityEvent accessibilityEvent0 = AccessibilityEvent.obtain(v1);
            d d0 = this.i(v);
            accessibilityEvent0.getText().add(d0.g());
            AccessibilityNodeInfo accessibilityNodeInfo0 = d0.a;
            accessibilityEvent0.setContentDescription(accessibilityNodeInfo0.getContentDescription());
            accessibilityEvent0.setScrollable(accessibilityNodeInfo0.isScrollable());
            accessibilityEvent0.setPassword(accessibilityNodeInfo0.isPassword());
            accessibilityEvent0.setEnabled(accessibilityNodeInfo0.isEnabled());
            accessibilityEvent0.setChecked(accessibilityNodeInfo0.isChecked());
            if(accessibilityEvent0.getText().isEmpty() && accessibilityEvent0.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEvent0.setClassName(accessibilityNodeInfo0.getClassName());
            accessibilityEvent0.setSource(view0, v);
            accessibilityEvent0.setPackageName("com.iloen.melon");
            return accessibilityEvent0;
        }
        AccessibilityEvent accessibilityEvent1 = AccessibilityEvent.obtain(v1);
        view0.onInitializeAccessibilityEvent(accessibilityEvent1);
        return accessibilityEvent1;
    }

    public final d c(int v) {
        AccessibilityNodeInfo accessibilityNodeInfo0 = AccessibilityNodeInfo.obtain();
        d d0 = new d(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setEnabled(true);
        accessibilityNodeInfo0.setFocusable(true);
        d0.l("android.view.View");
        Rect rect0 = a.k;
        d0.j(rect0);
        d0.k(rect0);
        d0.b = -1;
        View view0 = this.f;
        accessibilityNodeInfo0.setParent(view0);
        this.l(v, d0);
        if(d0.g() == null && accessibilityNodeInfo0.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect1 = this.b;
        d0.f(rect1);
        if(rect1.equals(rect0)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int v1 = accessibilityNodeInfo0.getActions();
        if((v1 & 0x40) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if((v1 & 0x80) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfo0.setPackageName("com.iloen.melon");
        d0.c = v;
        accessibilityNodeInfo0.setSource(view0, v);
        if(this.h == v) {
            d0.h(true);
            d0.a(0x80);
        }
        else {
            d0.h(false);
            d0.a(0x40);
        }
        boolean z = this.i == v;
        if(z) {
            d0.a(2);
        }
        else if(accessibilityNodeInfo0.isFocusable()) {
            d0.a(1);
        }
        accessibilityNodeInfo0.setFocused(z);
        int[] arr_v = this.d;
        view0.getLocationOnScreen(arr_v);
        Rect rect2 = this.a;
        accessibilityNodeInfo0.getBoundsInScreen(rect2);
        if(rect2.equals(rect0)) {
            d0.f(rect2);
            if(d0.b != -1) {
                d d1 = new d(AccessibilityNodeInfo.obtain());
                for(int v2 = d0.b; v2 != -1; v2 = d1.b) {
                    d1.b = -1;
                    d1.a.setParent(view0, -1);
                    d1.j(rect0);
                    this.l(v2, d1);
                    d1.f(rect1);
                    rect2.offset(rect1.left, rect1.top);
                }
            }
            rect2.offset(arr_v[0] - view0.getScrollX(), arr_v[1] - view0.getScrollY());
        }
        Rect rect3 = this.c;
        if(view0.getLocalVisibleRect(rect3)) {
            rect3.offset(arr_v[0] - view0.getScrollX(), arr_v[1] - view0.getScrollY());
            if(rect2.intersect(rect3)) {
                d0.k(rect2);
                if(!rect2.isEmpty() && view0.getWindowVisibility() == 0) {
                    for(ViewParent viewParent0 = view0.getParent(); true; viewParent0 = ((View)viewParent0).getParent()) {
                        if(!(viewParent0 instanceof View)) {
                            if(viewParent0 == null) {
                                break;
                            }
                            d0.a.setVisibleToUser(true);
                            break;
                        }
                        if(((View)viewParent0).getAlpha() <= 0.0f || ((View)viewParent0).getVisibility() != 0) {
                            break;
                        }
                    }
                }
            }
        }
        return d0;
    }

    public final boolean d(MotionEvent motionEvent0) {
        if(this.e.isEnabled() && this.e.isTouchExplorationEnabled()) {
            switch(motionEvent0.getAction()) {
                case 7: 
                case 9: {
                    int v = this.e(motionEvent0.getX(), motionEvent0.getY());
                    int v1 = this.j;
                    if(v1 != v) {
                        this.j = v;
                        this.o(v, 0x80);
                        this.o(v1, 0x100);
                    }
                    return v != 0x80000000;
                }
                case 10: {
                    int v2 = this.j;
                    if(v2 != 0x80000000) {
                        this.j = 0x80000000;
                        this.o(0x80000000, 0x80);
                        this.o(v2, 0x100);
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

    public abstract int e(float arg1, float arg2);

    public abstract void f(ArrayList arg1);

    public final void g(int v) {
        if(v != 0x80000000 && this.e.isEnabled()) {
            View view0 = this.f;
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 != null) {
                AccessibilityEvent accessibilityEvent0 = this.b(v, 0x800);
                accessibilityEvent0.setContentChangeTypes(0);
                viewParent0.requestSendAccessibilityEvent(view0, accessibilityEvent0);
            }
        }
    }

    @Override  // c2.b
    public final f getAccessibilityNodeProvider(View view0) {
        if(this.g == null) {
            this.g = new y(this, 1);
        }
        return this.g;
    }

    public final boolean h(int v, Rect rect0) {
        d d2;
        Object object0;
        ArrayList arrayList0 = new ArrayList();
        this.f(arrayList0);
        W w0 = new W(0);
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            d d0 = this.c(((int)(((Integer)arrayList0.get(v1)))));
            w0.d(((int)(((Integer)arrayList0.get(v1)))), d0);
        }
        d d1 = this.i == 0x80000000 ? null : ((d)w0.c(this.i));
        h h0 = a.l;
        F f0 = a.m;
        View view0 = this.f;
        if(v == 1 || v == 2) {
            boolean z = view0.getLayoutDirection() == 1;
            f0.getClass();
            int v11 = w0.c;
            ArrayList arrayList1 = new ArrayList(v11);
            for(int v12 = 0; v12 < v11; ++v12) {
                arrayList1.add(((d)w0.e(v12)));
            }
            Collections.sort(arrayList1, new j2.b(z, h0));
            switch(v) {
                case 1: {
                    int v13 = d1 == null ? arrayList1.size() : arrayList1.indexOf(d1);
                    object0 = v13 - 1 >= 0 ? arrayList1.get(v13 - 1) : null;
                    break;
                }
                case 2: {
                    int v14 = d1 == null ? -1 : arrayList1.lastIndexOf(d1);
                    object0 = v14 + 1 >= arrayList1.size() ? null : arrayList1.get(v14 + 1);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
            }
            d2 = (d)object0;
        }
        else {
            if(v != 17 && v != 33 && v != 66 && v != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect1 = new Rect();
            int v2 = this.i;
            if(v2 != 0x80000000) {
                this.i(v2).f(rect1);
            }
            else if(rect0 == null) {
                int v3 = view0.getWidth();
                int v4 = view0.getHeight();
                switch(v) {
                    case 17: {
                        rect1.set(v3, 0, v3, v4);
                        break;
                    }
                    case 33: {
                        rect1.set(0, v4, v3, v4);
                        break;
                    }
                    case 66: {
                        rect1.set(-1, 0, -1, v4);
                        break;
                    }
                    case 130: {
                        rect1.set(0, -1, v3, -1);
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            else {
                rect1.set(rect0);
            }
            Rect rect2 = new Rect(rect1);
            switch(v) {
                case 17: {
                    rect2.offset(rect1.width() + 1, 0);
                    break;
                }
                case 33: {
                    rect2.offset(0, rect1.height() + 1);
                    break;
                }
                case 66: {
                    rect2.offset(-(rect1.width() + 1), 0);
                    break;
                }
                case 130: {
                    rect2.offset(0, -(rect1.height() + 1));
                    break;
                }
                default: {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }
            f0.getClass();
            int v5 = w0.c;
            Rect rect3 = new Rect();
            d2 = null;
            for(int v6 = 0; v6 < v5; ++v6) {
                d d3 = (d)w0.e(v6);
                if(d3 != d1) {
                    h0.getClass();
                    d3.f(rect3);
                    if(v.A(v, rect1, rect3)) {
                        if(!v.A(v, rect1, rect2) || v.l(v, rect1, rect3, rect2)) {
                            rect2.set(rect3);
                            d2 = d3;
                        }
                        else if(!v.l(v, rect1, rect2, rect3)) {
                            int v7 = v.C(v, rect1, rect3);
                            int v8 = v.D(v, rect1, rect3);
                            int v9 = v.C(v, rect1, rect2);
                            int v10 = v.D(v, rect1, rect2);
                            if(v8 * v8 + v7 * 13 * v7 < v10 * v10 + v9 * 13 * v9) {
                                rect2.set(rect3);
                                d2 = d3;
                            }
                        }
                    }
                }
            }
        }
        if(d2 == null) {
            return this.n(0x80000000);
        }
        int v15 = w0.c;
        for(int v16 = 0; v16 < v15; ++v16) {
            if(w0.b[v16] == d2) {
                return this.n(w0.a[v16]);
            }
        }
        throw new ArrayIndexOutOfBoundsException(-1);
    }

    public final d i(int v) {
        if(v == -1) {
            View view0 = this.f;
            AccessibilityNodeInfo accessibilityNodeInfo0 = AccessibilityNodeInfo.obtain(view0);
            d d0 = new d(accessibilityNodeInfo0);
            view0.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
            ArrayList arrayList0 = new ArrayList();
            this.f(arrayList0);
            if(accessibilityNodeInfo0.getChildCount() > 0 && arrayList0.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                int v3 = (int)(((Integer)arrayList0.get(v2)));
                d0.a.addChild(view0, v3);
            }
            return d0;
        }
        return this.c(v);
    }

    public abstract boolean j(int arg1, int arg2, Bundle arg3);

    public void k(d d0) {
    }

    public abstract void l(int arg1, d arg2);

    public void m(int v, boolean z) {
    }

    public final boolean n(int v) {
        if(this.f.isFocused() || this.f.requestFocus()) {
            int v1 = this.i;
            if(v1 != v) {
                if(v1 != 0x80000000) {
                    this.a(v1);
                }
                if(v != 0x80000000) {
                    this.i = v;
                    this.m(v, true);
                    this.o(v, 8);
                    return true;
                }
            }
        }
        return false;
    }

    public final void o(int v, int v1) {
        if(v != 0x80000000 && this.e.isEnabled()) {
            View view0 = this.f;
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 != null) {
                viewParent0.requestSendAccessibilityEvent(view0, this.b(v, v1));
            }
        }
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        this.k(d0);
    }
}

