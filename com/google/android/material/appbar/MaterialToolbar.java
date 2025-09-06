package com.google.android.material.appbar;

import A1.f;
import E6.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View.MeasureSpec;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import c2.M;
import com.google.android.material.internal.B;
import d5.n;
import java.util.ArrayList;
import java.util.Collections;
import z6.i;

public class MaterialToolbar extends Toolbar {
    public Integer t0;
    public boolean u0;
    public boolean v0;
    public ImageView.ScaleType w0;
    public Boolean x0;
    public static final ImageView.ScaleType[] y0;

    static {
        MaterialToolbar.y0 = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public MaterialToolbar(Context context0) {
        this(context0, null);
    }

    public MaterialToolbar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040663);  // attr:toolbarStyle
    }

    public MaterialToolbar(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1404ED), attributeSet0, v);  // style:Widget.MaterialComponents.Toolbar
        Context context1 = this.getContext();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.M, v, 0x7F1404ED, new int[0]);  // style:Widget.MaterialComponents.Toolbar
        if(typedArray0.hasValue(2)) {
            this.setNavigationIconTint(typedArray0.getColor(2, -1));
        }
        this.u0 = typedArray0.getBoolean(4, false);
        this.v0 = typedArray0.getBoolean(3, false);
        int v1 = typedArray0.getInt(1, -1);
        if(v1 >= 0) {
            ImageView.ScaleType[] arr_imageView$ScaleType = MaterialToolbar.y0;
            if(v1 < arr_imageView$ScaleType.length) {
                this.w0 = arr_imageView$ScaleType[v1];
            }
        }
        if(typedArray0.hasValue(0)) {
            this.x0 = Boolean.valueOf(typedArray0.getBoolean(0, false));
        }
        typedArray0.recycle();
        Drawable drawable0 = this.getBackground();
        ColorStateList colorStateList0 = drawable0 == null ? ColorStateList.valueOf(0) : e2.a.F(drawable0);
        if(colorStateList0 != null) {
            i i0 = new i();
            i0.m(colorStateList0);
            i0.k(context1);
            i0.l(M.e(this));
            this.setBackground(i0);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.w0;
    }

    public Integer getNavigationIconTint() {
        return this.t0;
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void m(int v) {
        Menu menu0 = this.getMenu();
        if(menu0 instanceof MenuBuilder) {
            ((MenuBuilder)menu0).y();
        }
        super.m(v);
        if(menu0 instanceof MenuBuilder) {
            ((MenuBuilder)menu0).x();
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        n.B(this);
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        f f0 = B.c;
        ImageView imageView0 = null;
        if(this.u0 || this.v0) {
            ArrayList arrayList0 = B.k(this, this.getTitle());
            TextView textView0 = arrayList0.isEmpty() ? null : ((TextView)Collections.min(arrayList0, f0));
            ArrayList arrayList1 = B.k(this, this.getSubtitle());
            TextView textView1 = arrayList1.isEmpty() ? null : ((TextView)Collections.max(arrayList1, f0));
            if(textView0 != null || textView1 != null) {
                int v5 = this.getMeasuredWidth();
                int v6 = this.getPaddingLeft();
                int v7 = v5 - this.getPaddingRight();
                for(int v8 = 0; v8 < this.getChildCount(); ++v8) {
                    View view0 = this.getChildAt(v8);
                    if(view0.getVisibility() != 8 && view0 != textView0 && view0 != textView1) {
                        if(view0.getRight() < v5 / 2 && view0.getRight() > v6) {
                            v6 = view0.getRight();
                        }
                        if(view0.getLeft() > v5 / 2 && view0.getLeft() < v7) {
                            v7 = view0.getLeft();
                        }
                    }
                }
                Pair pair0 = new Pair(v6, v7);
                if(this.u0 && textView0 != null) {
                    this.x(textView0, pair0);
                }
                if(this.v0 && textView1 != null) {
                    this.x(textView1, pair0);
                }
            }
        }
        Drawable drawable0 = this.getLogo();
        if(drawable0 != null) {
            for(int v4 = 0; v4 < this.getChildCount(); ++v4) {
                View view1 = this.getChildAt(v4);
                if(view1 instanceof ImageView) {
                    Drawable drawable1 = ((ImageView)view1).getDrawable();
                    if(drawable1 != null && drawable1.getConstantState() != null && drawable1.getConstantState().equals(drawable0.getConstantState())) {
                        imageView0 = (ImageView)view1;
                        break;
                    }
                }
            }
        }
        if(imageView0 != null) {
            Boolean boolean0 = this.x0;
            if(boolean0 != null) {
                imageView0.setAdjustViewBounds(boolean0.booleanValue());
            }
            ImageView.ScaleType imageView$ScaleType0 = this.w0;
            if(imageView$ScaleType0 != null) {
                imageView0.setScaleType(imageView$ScaleType0);
            }
        }
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        n.z(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        if(this.x0 != null && this.x0.booleanValue() == z) {
            return;
        }
        this.x0 = Boolean.valueOf(z);
        this.requestLayout();
    }

    public void setLogoScaleType(ImageView.ScaleType imageView$ScaleType0) {
        if(this.w0 != imageView$ScaleType0) {
            this.w0 = imageView$ScaleType0;
            this.requestLayout();
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable0) {
        if(drawable0 != null && this.t0 != null) {
            drawable0 = drawable0.mutate();
            drawable0.setTint(((int)this.t0));
        }
        super.setNavigationIcon(drawable0);
    }

    public void setNavigationIconTint(int v) {
        this.t0 = v;
        Drawable drawable0 = this.getNavigationIcon();
        if(drawable0 != null) {
            this.setNavigationIcon(drawable0);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if(this.v0 != z) {
            this.v0 = z;
            this.requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if(this.u0 != z) {
            this.u0 = z;
            this.requestLayout();
        }
    }

    public final void x(TextView textView0, Pair pair0) {
        int v = this.getMeasuredWidth();
        int v1 = textView0.getMeasuredWidth();
        int v2 = v / 2 - v1 / 2;
        int v3 = v1 + v2;
        int v4 = Math.max(Math.max(((int)(((Integer)pair0.first))) - v2, 0), Math.max(v3 - ((int)(((Integer)pair0.second))), 0));
        if(v4 > 0) {
            v2 += v4;
            v3 -= v4;
            textView0.measure(View.MeasureSpec.makeMeasureSpec(v3 - v2, 0x40000000), textView0.getMeasuredHeightAndState());
        }
        textView0.layout(v2, textView0.getTop(), v3, textView0.getBottom());
    }
}

