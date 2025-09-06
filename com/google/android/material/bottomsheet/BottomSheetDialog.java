package com.google.android.material.bottomsheet;

import E8.a;
import H0.e;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.media3.session.legacy.V;
import c2.M;
import c2.W;
import i.n.i.b.a.s.e.Ga;
import i6.b;
import i6.c;

public class BottomSheetDialog extends AppCompatDialog {
    public BottomSheetBehavior f;
    public FrameLayout g;
    public CoordinatorLayout h;
    public FrameLayout i;
    public boolean j;
    public boolean k;
    public boolean l;
    public c m;
    public final boolean n;
    public V o;
    public final b r;

    public BottomSheetDialog(Context context0) {
        this(context0, 0);
        this.n = this.getContext().getTheme().obtainStyledAttributes(new int[]{0x7F040239}).getBoolean(0, false);  // attr:enableEdgeToEdge
    }

    public BottomSheetDialog(Context context0, int v) {
        if(v == 0) {
            TypedValue typedValue0 = new TypedValue();
            v = context0.getTheme().resolveAttribute(0x7F04009B, typedValue0, true) ? typedValue0.resourceId : 0x7F1402A8;  // attr:bottomSheetDialogTheme
        }
        super(context0, v);
        this.j = true;
        this.k = true;
        this.r = new b(this, 0);
        this.b().h(1);
        this.n = this.getContext().getTheme().obtainStyledAttributes(new int[]{0x7F040239}).getBoolean(0, false);  // attr:enableEdgeToEdge
    }

    @Override  // android.app.Dialog
    public final void cancel() {
        this.e();
        super.cancel();
    }

    public final void d() {
        if(this.g == null) {
            FrameLayout frameLayout0 = (FrameLayout)View.inflate(this.getContext(), 0x7F0D01E9, null);  // layout:design_bottom_sheet_dialog
            this.g = frameLayout0;
            this.h = (CoordinatorLayout)frameLayout0.findViewById(0x7F0A0347);  // id:coordinator
            FrameLayout frameLayout1 = (FrameLayout)this.g.findViewById(0x7F0A03B3);  // id:design_bottom_sheet
            this.i = frameLayout1;
            BottomSheetBehavior bottomSheetBehavior0 = BottomSheetBehavior.D(frameLayout1);
            this.f = bottomSheetBehavior0;
            bottomSheetBehavior0.w(this.r);
            this.f.K(this.j);
            this.o = new V(this.f, this.i);
        }
    }

    public final BottomSheetBehavior e() {
        if(this.f == null) {
            this.d();
        }
        return this.f;
    }

    public final FrameLayout f(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.d();
        CoordinatorLayout coordinatorLayout0 = (CoordinatorLayout)this.g.findViewById(0x7F0A0347);  // id:coordinator
        if(v != 0 && view0 == null) {
            view0 = this.getLayoutInflater().inflate(v, coordinatorLayout0, false);
        }
        if(this.n) {
            M.n(this.i, new Ga(this, 10));
        }
        this.i.removeAllViews();
        if(viewGroup$LayoutParams0 == null) {
            this.i.addView(view0);
        }
        else {
            this.i.addView(view0, viewGroup$LayoutParams0);
        }
        coordinatorLayout0.findViewById(0x7F0A0BDB).setOnClickListener(new a(this, 10));  // id:touch_outside
        W.o(this.i, new A6.c(this, 5));
        this.i.setOnTouchListener(new B6.b(2));
        return this.g;
    }

    @Override  // android.app.Dialog
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window0 = this.getWindow();
        if(window0 != null) {
            int v = !this.n || Color.alpha(window0.getNavigationBarColor()) >= 0xFF ? 0 : 1;
            FrameLayout frameLayout0 = this.g;
            if(frameLayout0 != null) {
                frameLayout0.setFitsSystemWindows(((boolean)(v ^ 1)));
            }
            CoordinatorLayout coordinatorLayout0 = this.h;
            if(coordinatorLayout0 != null) {
                coordinatorLayout0.setFitsSystemWindows(((boolean)(v ^ 1)));
            }
            e.W(window0, ((boolean)(v ^ 1)));
            c c0 = this.m;
            if(c0 != null) {
                c0.c(window0);
            }
        }
        V v1 = this.o;
        if(v1 == null) {
            return;
        }
        if(this.j) {
            v1.z(false);
            return;
        }
        v1.A();
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setStatusBarColor(0);
            window0.addFlags(0x80000000);
            window0.setLayout(-1, -1);
        }
    }

    @Override  // android.app.Dialog
    public final void onDetachedFromWindow() {
        c c0 = this.m;
        if(c0 != null) {
            c0.c(null);
        }
        V v0 = this.o;
        if(v0 != null) {
            v0.A();
        }
    }

    @Override  // androidx.activity.ComponentDialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior0 = this.f;
        if(bottomSheetBehavior0 != null && bottomSheetBehavior0.h0 == 5) {
            bottomSheetBehavior0.M(4);
        }
    }

    @Override  // android.app.Dialog
    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        if(this.j != z) {
            this.j = z;
            BottomSheetBehavior bottomSheetBehavior0 = this.f;
            if(bottomSheetBehavior0 != null) {
                bottomSheetBehavior0.K(z);
            }
            if(this.getWindow() != null) {
                V v0 = this.o;
                if(v0 != null) {
                    if(this.j) {
                        v0.z(false);
                        return;
                    }
                    v0.A();
                }
            }
        }
    }

    @Override  // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if(z && !this.j) {
            this.j = true;
        }
        this.k = z;
        this.l = true;
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setContentView(int v) {
        super.setContentView(this.f(null, v, null));
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setContentView(View view0) {
        super.setContentView(this.f(view0, 0, null));
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super.setContentView(this.f(view0, 0, viewGroup$LayoutParams0));
    }
}

