package com.google.android.material.sidesheet;

import A6.b;
import A6.j;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.c;
import androidx.media3.session.legacy.V;
import c2.W;

public class SideSheetDialog extends AppCompatDialog {
    public SideSheetBehavior f;
    public FrameLayout g;
    public FrameLayout h;
    public boolean i;
    public boolean j;
    public boolean k;
    public V l;

    public SideSheetDialog(Context context0) {
        TypedValue typedValue0 = new TypedValue();
        super(context0, (context0.getTheme().resolveAttribute(0x7F040567, typedValue0, true) ? typedValue0.resourceId : 0x7F1402C8));  // attr:sideSheetDialogTheme
        this.i = true;
        this.j = true;
        this.b().h(1);
    }

    @Override  // android.app.Dialog
    public final void cancel() {
        if(this.f == null) {
            this.d();
        }
        if(this.f == null) {
            throw new IllegalStateException("The view is not associated with SideSheetBehavior");
        }
        super.cancel();
    }

    public final void d() {
        if(this.g == null) {
            FrameLayout frameLayout0 = (FrameLayout)View.inflate(this.getContext(), 0x7F0D04C7, null);  // layout:m3_side_sheet_dialog
            this.g = frameLayout0;
            FrameLayout frameLayout1 = (FrameLayout)frameLayout0.findViewById(0x7F0A07C4);  // id:m3_side_sheet
            this.h = frameLayout1;
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout1.getLayoutParams();
            if(!(viewGroup$LayoutParams0 instanceof c)) {
                throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
            }
            Behavior coordinatorLayout$Behavior0 = ((c)viewGroup$LayoutParams0).a;
            if(!(coordinatorLayout$Behavior0 instanceof SideSheetBehavior)) {
                throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
            }
            this.f = (SideSheetBehavior)coordinatorLayout$Behavior0;
            j j0 = new j(this);
            ((SideSheetBehavior)coordinatorLayout$Behavior0).getClass();
            ((SideSheetBehavior)coordinatorLayout$Behavior0).I.add(j0);
            this.l = new V(this.f, this.h);
        }
    }

    public final FrameLayout e(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.d();
        if(this.g == null) {
            this.d();
        }
        CoordinatorLayout coordinatorLayout0 = (CoordinatorLayout)this.g.findViewById(0x7F0A0347);  // id:coordinator
        if(v != 0 && view0 == null) {
            view0 = this.getLayoutInflater().inflate(v, coordinatorLayout0, false);
        }
        if(this.h == null) {
            this.d();
        }
        FrameLayout frameLayout0 = this.h;
        frameLayout0.removeAllViews();
        if(viewGroup$LayoutParams0 == null) {
            frameLayout0.addView(view0);
        }
        else {
            frameLayout0.addView(view0, viewGroup$LayoutParams0);
        }
        coordinatorLayout0.findViewById(0x7F0A0BDB).setOnClickListener(new b(this, 0));  // id:touch_outside
        if(this.h == null) {
            this.d();
        }
        W.o(this.h, new A6.c(this, 0));
        return this.g;
    }

    @Override  // android.app.Dialog
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window0 = this.getWindow();
        if(window0 != null && (this.h != null && this.h.getLayoutParams() instanceof c)) {
            window0.setWindowAnimations((Gravity.getAbsoluteGravity(((c)this.h.getLayoutParams()).c, this.h.getLayoutDirection()) == 3 ? 0x7F140008 : 0x7F140009));  // style:Animation.Material3.SideSheetDialog.Left
        }
        V v0 = this.l;
        if(v0 == null) {
            return;
        }
        if(this.i) {
            v0.z(false);
            return;
        }
        v0.A();
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
        super.onDetachedFromWindow();
        V v0 = this.l;
        if(v0 != null) {
            v0.A();
        }
    }

    @Override  // androidx.activity.ComponentDialog
    public final void onStart() {
        super.onStart();
        SideSheetBehavior sideSheetBehavior0 = this.f;
        if(sideSheetBehavior0 != null && sideSheetBehavior0.h == 5) {
            sideSheetBehavior0.w(3);
        }
    }

    @Override  // android.app.Dialog
    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        if(this.i != z) {
            this.i = z;
        }
        if(this.getWindow() != null) {
            V v0 = this.l;
            if(v0 != null) {
                if(this.i) {
                    v0.z(false);
                    return;
                }
                v0.A();
            }
        }
    }

    @Override  // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if(z && !this.i) {
            this.i = true;
        }
        this.j = z;
        this.k = true;
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setContentView(int v) {
        super.setContentView(this.e(null, v, null));
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setContentView(View view0) {
        super.setContentView(this.e(view0, 0, null));
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super.setContentView(this.e(view0, 0, viewGroup$LayoutParams0));
    }
}

