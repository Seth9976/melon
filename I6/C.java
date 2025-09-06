package i6;

import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.b;
import c2.B0;
import c2.C0;
import c2.D0;
import c2.E0;
import c2.F0;
import c2.M;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e1.n;
import z6.i;

public final class c extends a {
    public final Boolean a;
    public final B0 b;
    public Window c;
    public boolean d;

    public c(View view0, B0 b00) {
        this.b = b00;
        i i0 = BottomSheetBehavior.D(view0).i;
        ColorStateList colorStateList0 = i0 == null ? M.c(view0) : i0.a.c;
        if(colorStateList0 != null) {
            this.a = Boolean.valueOf(n.x(colorStateList0.getDefaultColor()));
            return;
        }
        ColorStateList colorStateList1 = e2.a.F(view0.getBackground());
        Integer integer0 = colorStateList1 == null ? null : colorStateList1.getDefaultColor();
        if(integer0 != null) {
            this.a = Boolean.valueOf(n.x(((int)integer0)));
            return;
        }
        this.a = null;
    }

    @Override  // i6.a
    public final void a(View view0) {
        this.b(view0);
    }

    public final void b(View view0) {
        D0 d01;
        D0 d00;
        int v = view0.getTop();
        B0 b00 = this.b;
        if(v < b00.d()) {
            Window window0 = this.c;
            if(window0 != null) {
                boolean z = this.a == null ? this.d : this.a.booleanValue();
                b b0 = new b(window0.getDecorView());
                int v1 = Build.VERSION.SDK_INT;
                if(v1 >= 35) {
                    d00 = new E0(window0, b0);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
                }
                else if(v1 >= 30) {
                    d00 = new D0(window0, b0);
                }
                else {
                    d00 = new C0(window0, b0);
                }
                d00.Q(z);
            }
            view0.setPadding(view0.getPaddingLeft(), b00.d() - view0.getTop(), view0.getPaddingRight(), view0.getPaddingBottom());
            return;
        }
        if(view0.getTop() != 0) {
            Window window1 = this.c;
            if(window1 != null) {
                boolean z1 = this.d;
                b b1 = new b(window1.getDecorView());
                int v2 = Build.VERSION.SDK_INT;
                if(v2 >= 35) {
                    d01 = new E0(window1, b1);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
                }
                else if(v2 >= 30) {
                    d01 = new D0(window1, b1);
                }
                else {
                    d01 = new C0(window1, b1);
                }
                d01.Q(z1);
            }
            view0.setPadding(view0.getPaddingLeft(), 0, view0.getPaddingRight(), view0.getPaddingBottom());
        }
    }

    public final void c(Window window0) {
        if(this.c != window0) {
            this.c = window0;
            if(window0 != null) {
                this.d = new F0(window0, window0.getDecorView()).a.H();
            }
        }
    }

    @Override  // i6.a
    public final void onSlide(View view0, float f) {
        this.b(view0);
    }

    @Override  // i6.a
    public final void onStateChanged(View view0, int v) {
        this.b(view0);
    }
}

