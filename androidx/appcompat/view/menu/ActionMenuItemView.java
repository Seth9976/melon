package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.l1;
import androidx.appcompat.widget.m;
import g.a;
import k.b;
import k.c;
import k.k;
import k.x;

public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, m, x {
    public final int B;
    public k.m h;
    public CharSequence i;
    public Drawable j;
    public k k;
    public b l;
    public c m;
    public boolean n;
    public boolean o;
    public final int r;
    public int w;

    public ActionMenuItemView(Context context0) {
        this(context0, null);
    }

    public ActionMenuItemView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ActionMenuItemView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Resources resources0 = context0.getResources();
        this.n = this.g();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.c, v, 0);
        this.r = typedArray0.getDimensionPixelSize(0, 0);
        typedArray0.recycle();
        this.B = (int)(resources0.getDisplayMetrics().density * 32.0f + 0.5f);
        this.setOnClickListener(this);
        this.w = -1;
        this.setSaveEnabled(false);
    }

    @Override  // androidx.appcompat.widget.m
    public final boolean a() {
        return !TextUtils.isEmpty(this.getText());
    }

    @Override  // androidx.appcompat.widget.m
    public final boolean b() {
        return !TextUtils.isEmpty(this.getText()) && this.h.getIcon() == null;
    }

    @Override  // k.x
    public final void c(k.m m0) {
        this.h = m0;
        this.setIcon(m0.getIcon());
        this.setTitle(m0.getTitleCondensed());
        this.setId(m0.a);
        this.setVisibility((m0.isVisible() ? 0 : 8));
        this.setEnabled(m0.isEnabled());
        if(m0.hasSubMenu() && this.l == null) {
            this.l = new b(this);
        }
    }

    public final boolean g() {
        Configuration configuration0 = this.getContext().getResources().getConfiguration();
        return configuration0.screenWidthDp >= 480 || configuration0.screenWidthDp >= 640 && configuration0.screenHeightDp >= 480 || configuration0.orientation == 2;
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.TextView
    public CharSequence getAccessibilityClassName() {
        return "android.widget.Button";
    }

    @Override  // k.x
    public k.m getItemData() {
        return this.h;
    }

    public final void h() {
        int v = !TextUtils.isEmpty(this.i) & (this.j == null || (this.h.y & 4) == 4 && (this.n || this.o) ? 1 : 0);
        CharSequence charSequence0 = null;
        this.setText((v == 0 ? null : this.i));
        CharSequence charSequence1 = this.h.q;
        if(TextUtils.isEmpty(charSequence1)) {
            this.setContentDescription((v == 0 ? this.h.e : null));
        }
        else {
            this.setContentDescription(charSequence1);
        }
        CharSequence charSequence2 = this.h.r;
        if(TextUtils.isEmpty(charSequence2)) {
            if(v == 0) {
                charSequence0 = this.h.e;
            }
            l1.a(this, charSequence0);
            return;
        }
        l1.a(this, charSequence2);
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        k k0 = this.k;
        if(k0 != null) {
            k0.b(this.h);
        }
    }

    @Override  // android.widget.TextView
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.n = this.g();
        this.h();
    }

    @Override  // androidx.appcompat.widget.AppCompatTextView
    public final void onMeasure(int v, int v1) {
        boolean z = TextUtils.isEmpty(this.getText());
        if(!z) {
            int v2 = this.w;
            if(v2 >= 0) {
                super.setPadding(v2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
            }
        }
        super.onMeasure(v, v1);
        int v3 = View.MeasureSpec.getMode(v);
        int v4 = View.MeasureSpec.getSize(v);
        int v5 = this.getMeasuredWidth();
        int v6 = v3 == 0x80000000 ? Math.min(v4, this.r) : this.r;
        if(v3 != 0x40000000 && this.r > 0 && v5 < v6) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(v6, 0x40000000), v1);
        }
        if(z && this.j != null) {
            super.setPadding((this.getMeasuredWidth() - this.j.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }

    @Override  // android.widget.TextView
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(null);
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.TextView
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        return !this.h.hasSubMenu() || (this.l == null || !this.l.onTouch(this, motionEvent0)) ? super.onTouchEvent(motionEvent0) : true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if(this.o != z) {
            this.o = z;
            k.m m0 = this.h;
            if(m0 != null) {
                m0.n.k = true;
                m0.n.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable0) {
        this.j = drawable0;
        if(drawable0 != null) {
            int v = drawable0.getIntrinsicWidth();
            int v1 = drawable0.getIntrinsicHeight();
            int v2 = this.B;
            if(v > v2) {
                v1 = (int)(((float)v1) * (((float)v2) / ((float)v)));
                v = v2;
            }
            if(v1 > v2) {
                v = (int)(((float)v) * (((float)v2) / ((float)v1)));
            }
            else {
                v2 = v1;
            }
            drawable0.setBounds(0, 0, v, v2);
        }
        this.setCompoundDrawables(drawable0, null, null, null);
        this.h();
    }

    public void setItemInvoker(k k0) {
        this.k = k0;
    }

    @Override  // android.widget.TextView
    public final void setPadding(int v, int v1, int v2, int v3) {
        this.w = v;
        super.setPadding(v, v1, v2, v3);
    }

    public void setPopupCallback(c c0) {
        this.m = c0;
    }

    public void setTitle(CharSequence charSequence0) {
        this.i = charSequence0;
        this.h();
    }
}

