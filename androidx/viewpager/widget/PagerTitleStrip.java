package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@f
public class PagerTitleStrip extends ViewGroup {
    public ViewPager a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public int e;
    public float f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public final c k;
    public WeakReference l;
    public int m;
    public int n;
    public static final int[] o;
    public static final int[] r;

    static {
        PagerTitleStrip.o = new int[]{0x1010034, 0x1010095, 0x1010098, 0x10100AF};
        PagerTitleStrip.r = new int[]{0x101038C};
    }

    public PagerTitleStrip(Context context0) {
        this(context0, null);
    }

    public PagerTitleStrip(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.e = -1;
        this.f = -1.0f;
        this.k = new c(this);
        TextView textView0 = new TextView(context0);
        this.b = textView0;
        this.addView(textView0);
        TextView textView1 = new TextView(context0);
        this.c = textView1;
        this.addView(textView1);
        TextView textView2 = new TextView(context0);
        this.d = textView2;
        this.addView(textView2);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, PagerTitleStrip.o);
        boolean z = false;
        int v = typedArray0.getResourceId(0, 0);
        if(v != 0) {
            textView0.setTextAppearance(v);
            textView1.setTextAppearance(v);
            textView2.setTextAppearance(v);
        }
        int v1 = typedArray0.getDimensionPixelSize(1, 0);
        if(v1 != 0) {
            textView0.setTextSize(0, ((float)v1));
            textView1.setTextSize(0, ((float)v1));
            textView2.setTextSize(0, ((float)v1));
        }
        if(typedArray0.hasValue(2)) {
            int v2 = typedArray0.getColor(2, 0);
            textView0.setTextColor(v2);
            textView1.setTextColor(v2);
            textView2.setTextColor(v2);
        }
        this.h = typedArray0.getInteger(3, 80);
        typedArray0.recycle();
        this.n = textView1.getTextColors().getDefaultColor();
        this.setNonPrimaryAlpha(0.6f);
        TextUtils.TruncateAt textUtils$TruncateAt0 = TextUtils.TruncateAt.END;
        textView0.setEllipsize(textUtils$TruncateAt0);
        textView1.setEllipsize(textUtils$TruncateAt0);
        textView2.setEllipsize(textUtils$TruncateAt0);
        if(v != 0) {
            TypedArray typedArray1 = context0.obtainStyledAttributes(v, PagerTitleStrip.r);
            z = typedArray1.getBoolean(0, false);
            typedArray1.recycle();
        }
        if(z) {
            PagerTitleStrip.setSingleLineAllCaps(textView0);
            PagerTitleStrip.setSingleLineAllCaps(textView1);
            PagerTitleStrip.setSingleLineAllCaps(textView2);
        }
        else {
            textView0.setSingleLine();
            textView1.setSingleLine();
            textView2.setSingleLine();
        }
        this.g = (int)(context0.getResources().getDisplayMetrics().density * 16.0f);
    }

    public final void a(a a0, a a1) {
        c c0 = this.k;
        if(a0 != null) {
            a0.unregisterDataSetObserver(c0);
            this.l = null;
        }
        if(a1 != null) {
            a1.registerDataSetObserver(c0);
            this.l = new WeakReference(a1);
        }
        ViewPager viewPager0 = this.a;
        if(viewPager0 != null) {
            this.e = -1;
            this.f = -1.0f;
            this.b(viewPager0.getCurrentItem(), a1);
            this.requestLayout();
        }
    }

    public final void b(int v, a a0) {
        if(a0 != null) {
            a0.getCount();
        }
        this.i = true;
        this.b.setText(null);
        this.c.setText(null);
        this.d.setText(null);
        int v1 = View.MeasureSpec.makeMeasureSpec(Math.max(0, ((int)(((float)(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight())) * 0.8f))), 0x80000000);
        int v2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()), 0x80000000);
        this.b.measure(v1, v2);
        this.c.measure(v1, v2);
        this.d.measure(v1, v2);
        this.e = v;
        if(!this.j) {
            this.c(v, false, this.f);
        }
        this.i = false;
    }

    public void c(int v, boolean z, float f) {
        int v23;
        int v22;
        int v21;
        int v24;
        if(v != this.e) {
            this.b(v, this.a.getAdapter());
        }
        else if(!z && f == this.f) {
            return;
        }
        this.j = true;
        TextView textView0 = this.b;
        int v1 = textView0.getMeasuredWidth();
        TextView textView1 = this.c;
        int v2 = textView1.getMeasuredWidth();
        TextView textView2 = this.d;
        int v3 = textView2.getMeasuredWidth();
        int v4 = this.getWidth();
        int v5 = this.getHeight();
        int v6 = this.getPaddingLeft();
        int v7 = this.getPaddingRight();
        int v8 = this.getPaddingTop();
        int v9 = this.getPaddingBottom();
        int v10 = v7 + v2 / 2;
        float f1 = f + 0.5f;
        int v11 = v4 - v10 - ((int)(((float)(v4 - (v6 + v2 / 2) - v10)) * (f1 > 1.0f ? f1 - 1.0f : f + 0.5f))) - v2 / 2;
        int v12 = v2 + v11;
        int v13 = textView0.getBaseline();
        int v14 = textView1.getBaseline();
        int v15 = textView2.getBaseline();
        int v16 = Math.max(Math.max(v13, v14), v15);
        int v17 = v16 - v13;
        int v18 = v16 - v14;
        int v19 = v16 - v15;
        int v20 = Math.max(Math.max(textView0.getMeasuredHeight() + v17, textView1.getMeasuredHeight() + v18), textView2.getMeasuredHeight() + v19);
        switch(this.h & 0x70) {
            case 16: {
                v24 = (v5 - v8 - v9 - v20) / 2;
                v21 = v17 + v24;
                v22 = v24 + v18;
                v23 = v24 + v19;
                break;
            }
            case 80: {
                v24 = v5 - v9 - v20;
                v21 = v17 + v24;
                v22 = v24 + v18;
                v23 = v24 + v19;
                break;
            }
            default: {
                v21 = v17 + v8;
                v22 = v8 + v18;
                v23 = v8 + v19;
            }
        }
        textView1.layout(v11, v22, v12, textView1.getMeasuredHeight() + v22);
        int v25 = Math.min(v6, v11 - this.g - v1);
        textView0.layout(v25, v21, v25 + v1, textView0.getMeasuredHeight() + v21);
        int v26 = Math.max(v4 - v7 - v3, v12 + this.g);
        textView2.layout(v26, v23, v26 + v3, textView2.getMeasuredHeight() + v23);
        this.f = f;
        this.j = false;
    }

    public int getMinHeight() {
        Drawable drawable0 = this.getBackground();
        return drawable0 == null ? 0 : drawable0.getIntrinsicHeight();
    }

    public int getTextSpacing() {
        return this.g;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent viewParent0 = this.getParent();
        if(!(viewParent0 instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        a a0 = ((ViewPager)viewParent0).getAdapter();
        ((ViewPager)viewParent0).setInternalPageChangeListener(this.k);
        ((ViewPager)viewParent0).addOnAdapterChangeListener(this.k);
        this.a = (ViewPager)viewParent0;
        this.a((this.l == null ? null : ((a)this.l.get())), a0);
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager0 = this.a;
        if(viewPager0 != null) {
            this.a(viewPager0.getAdapter(), null);
            this.a.setInternalPageChangeListener(null);
            this.a.removeOnAdapterChangeListener(this.k);
            this.a = null;
        }
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(this.a != null) {
            this.c(this.e, true, (this.f >= 0.0f ? this.f : 0.0f));
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v7;
        if(View.MeasureSpec.getMode(v) != 0x40000000) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int v2 = this.getPaddingTop();
        int v3 = this.getPaddingBottom() + v2;
        int v4 = ViewGroup.getChildMeasureSpec(v1, v3, -2);
        int v5 = View.MeasureSpec.getSize(v);
        int v6 = ViewGroup.getChildMeasureSpec(v, ((int)(((float)v5) * 0.2f)), -2);
        this.b.measure(v6, v4);
        TextView textView0 = this.c;
        textView0.measure(v6, v4);
        this.d.measure(v6, v4);
        if(View.MeasureSpec.getMode(v1) == 0x40000000) {
            v7 = View.MeasureSpec.getSize(v1);
        }
        else {
            int v8 = textView0.getMeasuredHeight();
            v7 = Math.max(this.getMinHeight(), v8 + v3);
        }
        this.setMeasuredDimension(v5, View.resolveSizeAndState(v7, v1, textView0.getMeasuredState() << 16));
    }

    @Override  // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if(!this.i) {
            super.requestLayout();
        }
    }

    public void setGravity(int v) {
        this.h = v;
        this.requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        int v = ((int)(f * 255.0f)) & 0xFF;
        this.m = v;
        int v1 = v << 24 | this.n & 0xFFFFFF;
        this.b.setTextColor(v1);
        this.d.setTextColor(v1);
    }

    private static void setSingleLineAllCaps(TextView textView0) {
        Context context0 = textView0.getContext();
        d d0 = new d();  // 初始化器: Landroid/text/method/SingleLineTransformationMethod;-><init>()V
        d0.a = context0.getResources().getConfiguration().locale;
        textView0.setTransformationMethod(d0);
    }

    public void setTextColor(int v) {
        this.n = v;
        this.c.setTextColor(v);
        int v1 = this.m << 24 | this.n & 0xFFFFFF;
        this.b.setTextColor(v1);
        this.d.setTextColor(v1);
    }

    public void setTextSpacing(int v) {
        this.g = v;
        this.requestLayout();
    }
}

