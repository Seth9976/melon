package com.google.android.material.bottomsheet;

import A6.c;
import E6.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import c2.W;
import i6.b;

public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    public final AccessibilityManager a;
    public BottomSheetBehavior b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final String f;
    public final String g;
    public final String h;
    public final b i;
    public static final int j;

    public BottomSheetDragHandleView(Context context0) {
        this(context0, null);
    }

    public BottomSheetDragHandleView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04009C);  // attr:bottomSheetDragHandleStyle
    }

    public BottomSheetDragHandleView(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1403D9), attributeSet0, v);  // style:Widget.Material3.BottomSheet.DragHandle
        this.f = "Expand the bottom sheet";
        this.g = "Collapse the bottom sheet";
        this.h = "Drag handle double-tapped";
        this.i = new b(this, 1);
        this.a = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.e();
        W.o(this, new c(this, 6));
    }

    public final boolean c() {
        if(!this.d) {
            return false;
        }
        AccessibilityManager accessibilityManager0 = this.a;
        if(accessibilityManager0 != null) {
            AccessibilityEvent accessibilityEvent0 = AccessibilityEvent.obtain(0x4000);
            accessibilityEvent0.getText().add(this.h);
            accessibilityManager0.sendAccessibilityEvent(accessibilityEvent0);
        }
        BottomSheetBehavior bottomSheetBehavior0 = this.b;
        boolean z = bottomSheetBehavior0.b;
        int v = bottomSheetBehavior0.h0;
        int v1 = 6;
        int v2 = 3;
        if(v != 4) {
            if(v != 3) {
                if(!this.e) {
                    v2 = 4;
                }
                v1 = v2;
            }
            else if(z) {
                v1 = 4;
            }
        }
        else if(z) {
            v1 = 3;
        }
        bottomSheetBehavior0.M(v1);
        return true;
    }

    public final void d(int v) {
        switch(v) {
            case 3: {
                this.e = false;
                break;
            }
            case 4: {
                this.e = true;
            }
        }
        W.m(this, d2.c.g, (this.e ? this.f : this.g), new com.iloen.melon.fragments.radio.a(this, 29));
    }

    public final void e() {
        int v = 1;
        this.d = this.c && this.b != null;
        if(this.b == null) {
            v = 2;
        }
        this.setImportantForAccessibility(v);
        this.setClickable(this.d);
    }

    @Override  // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        this.c = z;
        this.e();
    }

    @Override  // android.widget.ImageView
    public final void onAttachedToWindow() {
        Behavior coordinatorLayout$Behavior0;
        BottomSheetBehavior bottomSheetBehavior0;
        super.onAttachedToWindow();
        View view0 = this;
    alab1:
        while(true) {
            do {
                ViewParent viewParent0 = view0.getParent();
                bottomSheetBehavior0 = null;
                view0 = viewParent0 instanceof View ? ((View)viewParent0) : null;
                if(view0 == null) {
                    break alab1;
                }
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                if(!(viewGroup$LayoutParams0 instanceof androidx.coordinatorlayout.widget.c)) {
                    continue alab1;
                }
                coordinatorLayout$Behavior0 = ((androidx.coordinatorlayout.widget.c)viewGroup$LayoutParams0).a;
            }
            while(!(coordinatorLayout$Behavior0 instanceof BottomSheetBehavior));
            bottomSheetBehavior0 = (BottomSheetBehavior)coordinatorLayout$Behavior0;
            break;
        }
        this.setBottomSheetBehavior(bottomSheetBehavior0);
        AccessibilityManager accessibilityManager0 = this.a;
        if(accessibilityManager0 != null) {
            accessibilityManager0.addAccessibilityStateChangeListener(this);
            this.onAccessibilityStateChanged(accessibilityManager0.isEnabled());
        }
    }

    @Override  // android.widget.ImageView
    public final void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager0 = this.a;
        if(accessibilityManager0 != null) {
            accessibilityManager0.removeAccessibilityStateChangeListener(this);
        }
        this.setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    private void setBottomSheetBehavior(BottomSheetBehavior bottomSheetBehavior0) {
        BottomSheetBehavior bottomSheetBehavior1 = this.b;
        b b0 = this.i;
        if(bottomSheetBehavior1 != null) {
            bottomSheetBehavior1.t0.remove(b0);
            this.b.I(null);
        }
        this.b = bottomSheetBehavior0;
        if(bottomSheetBehavior0 != null) {
            bottomSheetBehavior0.I(this);
            this.d(this.b.h0);
            this.b.w(b0);
        }
        this.e();
    }
}

