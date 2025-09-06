package androidx.appcompat.widget;

import G6.e;
import Q5.k;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    public h a;
    public final LinearLayoutCompat b;
    public AppCompatSpinner c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;

    static {
        new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context context0) {
        super(context0);
        new e(this, 1);
        this.setHorizontalScrollBarEnabled(false);
        k k0 = k.c(context0);
        this.setContentHeight(k0.e());
        this.f = k0.a.getResources().getDimensionPixelSize(0x7F07000A);  // dimen:abc_action_bar_stacked_tab_max_width
        LinearLayoutCompat linearLayoutCompat0 = new LinearLayoutCompat(this.getContext(), null, 0x7F040009);  // attr:actionBarTabBarStyle
        linearLayoutCompat0.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat0.setGravity(17);
        linearLayoutCompat0.setLayoutParams(new LayoutParams(-2, -1));  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
        this.b = linearLayoutCompat0;
        this.addView(linearLayoutCompat0, new ViewGroup.LayoutParams(-2, -1));
    }

    public final void a() {
        if(this.c != null && this.c.getParent() == this) {
            this.removeView(this.c);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = new ViewGroup.LayoutParams(-2, -1);
            this.addView(this.b, viewGroup$LayoutParams0);
            this.setTabSelected(this.c.getSelectedItemPosition());
        }
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h h0 = this.a;
        if(h0 != null) {
            this.post(h0);
        }
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        k k0 = k.c(this.getContext());
        this.setContentHeight(k0.e());
        this.f = k0.a.getResources().getDimensionPixelSize(0x7F07000A);  // dimen:abc_action_bar_stacked_tab_max_width
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h h0 = this.a;
        if(h0 != null) {
            this.removeCallbacks(h0);
        }
    }

    @Override  // android.widget.AdapterView$OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView0, View view0, int v, long v1) {
        ((I0)view0).getClass();
        throw null;
    }

    @Override  // android.widget.HorizontalScrollView
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v);
        this.setFillViewport(v2 == 0x40000000);
        LinearLayoutCompat linearLayoutCompat0 = this.b;
        int v3 = linearLayoutCompat0.getChildCount();
        if(v3 <= 1 || v2 != 0x80000000 && v2 != 0x40000000) {
            this.e = -1;
        }
        else {
            this.e = v3 > 2 ? ((int)(((float)View.MeasureSpec.getSize(v)) * 0.4f)) : View.MeasureSpec.getSize(v) / 2;
            this.e = Math.min(this.e, this.f);
        }
        int v4 = View.MeasureSpec.makeMeasureSpec(this.g, 0x40000000);
        if(v2 == 0x40000000 || !this.d) {
            this.a();
        }
        else {
            linearLayoutCompat0.measure(0, v4);
            if(linearLayoutCompat0.getMeasuredWidth() <= View.MeasureSpec.getSize(v)) {
                this.a();
            }
            else if(this.c == null || this.c.getParent() != this) {
                if(this.c == null) {
                    AppCompatSpinner appCompatSpinner0 = new AppCompatSpinner(this.getContext(), null, 0x7F040018);  // attr:actionDropDownStyle
                    appCompatSpinner0.setLayoutParams(new LayoutParams(-2, -1));  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
                    appCompatSpinner0.setOnItemSelectedListener(this);
                    this.c = appCompatSpinner0;
                }
                this.removeView(linearLayoutCompat0);
                this.addView(this.c, new ViewGroup.LayoutParams(-2, -1));
                if(this.c.getAdapter() == null) {
                    this.c.setAdapter(new H0(this));
                }
                h h0 = this.a;
                if(h0 != null) {
                    this.removeCallbacks(h0);
                    this.a = null;
                }
                this.c.setSelection(this.h);
            }
        }
        int v5 = this.getMeasuredWidth();
        super.onMeasure(v, v4);
        if(v2 == 0x40000000 && v5 != this.getMeasuredWidth()) {
            this.setTabSelected(this.h);
        }
    }

    @Override  // android.widget.AdapterView$OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView0) {
    }

    public void setAllowCollapse(boolean z) {
        this.d = z;
    }

    public void setContentHeight(int v) {
        this.g = v;
        this.requestLayout();
    }

    public void setTabSelected(int v) {
        this.h = v;
        LinearLayoutCompat linearLayoutCompat0 = this.b;
        int v1 = linearLayoutCompat0.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            boolean z = v2 == v;
            linearLayoutCompat0.getChildAt(v2).setSelected(z);
            if(z) {
                View view0 = linearLayoutCompat0.getChildAt(v);
                h h0 = this.a;
                if(h0 != null) {
                    this.removeCallbacks(h0);
                }
                h h1 = new h(1, this, view0);
                this.a = h1;
                this.post(h1);
            }
        }
        AppCompatSpinner appCompatSpinner0 = this.c;
        if(appCompatSpinner0 != null && v >= 0) {
            appCompatSpinner0.setSelection(v);
        }
    }
}

