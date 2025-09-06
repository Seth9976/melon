package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.appcompat.app.D;
import androidx.appcompat.app.q;
import androidx.appcompat.view.menu.MenuBuilder;

public class ContentFrameLayout extends FrameLayout {
    public TypedValue a;
    public TypedValue b;
    public TypedValue c;
    public TypedValue d;
    public TypedValue e;
    public TypedValue f;
    public final Rect g;
    public c0 h;

    public ContentFrameLayout(Context context0) {
        this(context0, null);
    }

    public ContentFrameLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ContentFrameLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.g = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if(this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if(this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedWidthMajor() {
        if(this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if(this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if(this.a == null) {
            this.a = new TypedValue();
        }
        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if(this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c0 c00 = this.h;
        if(c00 != null) {
            c00.getClass();
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c0 c00 = this.h;
        if(c00 != null) {
            D d0 = ((q)c00).b;
            d0 d00 = d0.B;
            if(d00 != null) {
                ((ActionBarOverlayLayout)d00).g();
                ActionMenuView actionMenuView0 = ((k1)((ActionBarOverlayLayout)d00).e).a.a;
                if(actionMenuView0 != null) {
                    ActionMenuPresenter actionMenuPresenter0 = actionMenuView0.E;
                    if(actionMenuPresenter0 != null) {
                        actionMenuPresenter0.l();
                        f f0 = actionMenuPresenter0.G;
                        if(f0 != null && f0.b()) {
                            f0.i.dismiss();
                        }
                    }
                }
            }
            if(d0.M != null) {
                d0.l.getDecorView().removeCallbacks(d0.N);
                if(d0.M.isShowing()) {
                    try {
                        d0.M.dismiss();
                    }
                    catch(IllegalArgumentException unused_ex) {
                    }
                }
                d0.M = null;
            }
            c2.c0 c01 = d0.S;
            if(c01 != null) {
                c01.b();
            }
            MenuBuilder menuBuilder0 = d0.A(0).h;
            if(menuBuilder0 != null) {
                menuBuilder0.c(true);
            }
        }
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        int v10;
        int v6;
        int v7;
        int v4;
        boolean z2;
        int v5;
        DisplayMetrics displayMetrics0 = this.getContext().getResources().getDisplayMetrics();
        boolean z = true;
        boolean z1 = displayMetrics0.widthPixels < displayMetrics0.heightPixels;
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getMode(v1);
        Rect rect0 = this.g;
        if(v2 == 0x80000000) {
            TypedValue typedValue0 = z1 ? this.d : this.c;
            if(typedValue0 == null) {
                v5 = v;
                z2 = false;
            }
            else {
                switch(typedValue0.type) {
                    case 0: {
                        v5 = v;
                        z2 = false;
                        break;
                    }
                    case 5: {
                        v4 = (int)typedValue0.getDimension(displayMetrics0);
                        goto label_18;
                    }
                    case 6: {
                        v4 = (int)typedValue0.getFraction(((float)displayMetrics0.widthPixels), ((float)displayMetrics0.widthPixels));
                    label_18:
                        if(v4 > 0) {
                            v5 = View.MeasureSpec.makeMeasureSpec(Math.min(v4 - (rect0.left + rect0.right), View.MeasureSpec.getSize(v)), 0x40000000);
                            z2 = true;
                        }
                        else {
                            v5 = v;
                            z2 = false;
                        }
                        break;
                    }
                    default: {
                        v4 = 0;
                        goto label_18;
                    }
                }
            }
        }
        else {
            v5 = v;
            z2 = false;
        }
        if(v3 == 0x80000000) {
            TypedValue typedValue1 = z1 ? this.e : this.f;
            if(typedValue1 == null) {
                v7 = v1;
            }
            else {
                switch(typedValue1.type) {
                    case 0: {
                        v7 = v1;
                        break;
                    }
                    case 5: {
                        v6 = (int)typedValue1.getDimension(displayMetrics0);
                        v7 = v6 > 0 ? View.MeasureSpec.makeMeasureSpec(Math.min(v6 - (rect0.top + rect0.bottom), View.MeasureSpec.getSize(v1)), 0x40000000) : v1;
                        break;
                    }
                    case 6: {
                        v6 = (int)typedValue1.getFraction(((float)displayMetrics0.heightPixels), ((float)displayMetrics0.heightPixels));
                        v7 = v6 > 0 ? View.MeasureSpec.makeMeasureSpec(Math.min(v6 - (rect0.top + rect0.bottom), View.MeasureSpec.getSize(v1)), 0x40000000) : v1;
                        break;
                    }
                    default: {
                        v6 = 0;
                        v7 = v6 > 0 ? View.MeasureSpec.makeMeasureSpec(Math.min(v6 - (rect0.top + rect0.bottom), View.MeasureSpec.getSize(v1)), 0x40000000) : v1;
                        break;
                    }
                }
            }
        }
        else {
            v7 = v1;
        }
        super.onMeasure(v5, v7);
        int v8 = this.getMeasuredWidth();
        int v9 = View.MeasureSpec.makeMeasureSpec(v8, 0x40000000);
        if(z2 || v2 != 0x80000000) {
            z = false;
        }
        else {
            TypedValue typedValue2 = z1 ? this.b : this.a;
            if(typedValue2 == null) {
                z = false;
            }
            else {
                switch(typedValue2.type) {
                    case 0: {
                        z = false;
                        goto label_73;
                    }
                    case 5: {
                        v10 = (int)typedValue2.getDimension(displayMetrics0);
                        break;
                    }
                    case 6: {
                        v10 = (int)typedValue2.getFraction(((float)displayMetrics0.widthPixels), ((float)displayMetrics0.widthPixels));
                        break;
                    }
                    default: {
                        v10 = 0;
                    }
                }
                if(v10 > 0) {
                    v10 -= rect0.left + rect0.right;
                }
                if(v8 < v10) {
                    v9 = View.MeasureSpec.makeMeasureSpec(v10, 0x40000000);
                }
                else {
                    z = false;
                }
            }
        }
    label_73:
        if(z) {
            super.onMeasure(v9, v7);
        }
    }

    public void setAttachListener(c0 c00) {
        this.h = c00;
    }
}

