package com.google.android.material.navigation;

import B6.f;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.l1;
import c2.O;
import e1.n;
import f6.a;
import k.m;
import k.x;

public abstract class NavigationBarItemView extends FrameLayout implements x {
    public int B;
    public int D;
    public m E;
    public ColorStateList G;
    public Drawable I;
    public Drawable M;
    public ValueAnimator N;
    public c S;
    public float T;
    public boolean V;
    public int W;
    public boolean a;
    public ColorStateList b;
    public int b0;
    public Drawable c;
    public boolean c0;
    public int d;
    public int d0;
    public int e;
    public a e0;
    public int f;
    public static final int[] f0;
    public float g;
    public static final c g0;
    public float h;
    public static final d h0;
    public float i;
    public int j;
    public boolean k;
    public final FrameLayout l;
    public final View m;
    public final ImageView n;
    public final ViewGroup o;
    public final TextView r;
    public final TextView w;

    static {
        NavigationBarItemView.f0 = new int[]{0x10100A0};
        NavigationBarItemView.g0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        NavigationBarItemView.h0 = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public NavigationBarItemView(Context context0) {
        super(context0);
        this.a = false;
        this.B = -1;
        this.D = 0;
        this.S = NavigationBarItemView.g0;
        this.T = 0.0f;
        this.V = false;
        this.W = 0;
        this.b0 = 0;
        this.c0 = false;
        this.d0 = 0;
        LayoutInflater.from(context0).inflate(this.getItemLayoutResId(), this, true);
        this.l = (FrameLayout)this.findViewById(0x7F0A0897);  // id:navigation_bar_item_icon_container
        this.m = this.findViewById(0x7F0A0896);  // id:navigation_bar_item_active_indicator_view
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0898);  // id:navigation_bar_item_icon_view
        this.n = imageView0;
        ViewGroup viewGroup0 = (ViewGroup)this.findViewById(0x7F0A0899);  // id:navigation_bar_item_labels_group
        this.o = viewGroup0;
        TextView textView0 = (TextView)this.findViewById(0x7F0A089B);  // id:navigation_bar_item_small_label_view
        this.r = textView0;
        TextView textView1 = (TextView)this.findViewById(0x7F0A089A);  // id:navigation_bar_item_large_label_view
        this.w = textView1;
        this.setBackgroundResource(0x7F080771);  // drawable:mtrl_navigation_bar_item_background
        this.d = this.getResources().getDimensionPixelSize(this.getItemDefaultMarginResId());
        this.e = viewGroup0.getPaddingBottom();
        this.f = this.getResources().getDimensionPixelSize(0x7F070267);  // dimen:m3_navigation_item_active_indicator_label_padding
        textView0.setImportantForAccessibility(2);
        textView1.setImportantForAccessibility(2);
        this.setFocusable(true);
        this.a(textView0.getTextSize(), textView1.getTextSize());
        if(imageView0 != null) {
            imageView0.addOnLayoutChangeListener(new F6.a(this, 1));
        }
    }

    public final void a(float f, float f1) {
        this.g = f - f1;
        this.h = f1 * 1.0f / f;
        this.i = f * 1.0f / f1;
    }

    public final void b() {
        m m0 = this.E;
        if(m0 != null) {
            this.setChecked(m0.isChecked());
        }
    }

    @Override  // k.x
    public final void c(m m0) {
        this.E = m0;
        this.setCheckable(m0.isCheckable());
        this.setChecked(m0.isChecked());
        this.setEnabled(m0.isEnabled());
        this.setIcon(m0.getIcon());
        this.setTitle(m0.e);
        this.setId(m0.a);
        if(!TextUtils.isEmpty(m0.q)) {
            this.setContentDescription(m0.q);
        }
        l1.a(this, (TextUtils.isEmpty(m0.r) ? m0.e : m0.r));
        this.setVisibility((m0.isVisible() ? 0 : 8));
        this.a = true;
    }

    public final void d() {
        Drawable drawable0 = this.c;
        FrameLayout frameLayout0 = this.l;
        Drawable drawable1 = null;
        boolean z = true;
        if(this.b != null) {
            Drawable drawable2 = this.getActiveIndicatorDrawable();
            if(this.V && this.getActiveIndicatorDrawable() != null && frameLayout0 != null && drawable2 != null) {
                drawable1 = new RippleDrawable(x6.a.c(this.b), null, drawable2);
                z = false;
            }
            else if(drawable0 == null) {
                drawable0 = new RippleDrawable(x6.a.a(this.b), null, null);
            }
        }
        if(frameLayout0 != null) {
            frameLayout0.setPadding(0, 0, 0, 0);
            frameLayout0.setForeground(drawable1);
        }
        this.setBackground(drawable0);
        this.setDefaultFocusHighlightEnabled(z);
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        FrameLayout frameLayout0 = this.l;
        if(frameLayout0 != null && this.V) {
            frameLayout0.dispatchTouchEvent(motionEvent0);
        }
        return super.dispatchTouchEvent(motionEvent0);
    }

    public final void e(float f, float f1) {
        View view0 = this.m;
        if(view0 != null) {
            c c0 = this.S;
            c0.getClass();
            view0.setScaleX(e6.a.a(0.4f, 1.0f, f));
            view0.setScaleY(c0.a(f, f1));
            int v = Float.compare(f1, 0.0f);
            view0.setAlpha(e6.a.b(0.0f, 1.0f, (v == 0 ? 0.8f : 0.0f), (v == 0 ? 1.0f : 0.2f), f));
        }
        this.T = f;
    }

    public static void f(TextView textView0, int v) {
        int v1;
        textView0.setTextAppearance(v);
        Context context0 = textView0.getContext();
        if(v == 0) {
            v1 = 0;
        }
        else {
            TypedArray typedArray0 = context0.obtainStyledAttributes(v, d6.a.f0);
            TypedValue typedValue0 = new TypedValue();
            boolean z = typedArray0.getValue(0, typedValue0);
            typedArray0.recycle();
            if(z) {
                v1 = typedValue0.getComplexUnit() == 2 ? Math.round(TypedValue.complexToFloat(typedValue0.data) * context0.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue0.data, context0.getResources().getDisplayMetrics());
            }
            else {
                v1 = 0;
            }
        }
        if(v1 != 0) {
            textView0.setTextSize(0, ((float)v1));
        }
    }

    public static void g(View view0, float f, float f1, int v) {
        view0.setScaleX(f);
        view0.setScaleY(f1);
        view0.setVisibility(v);
    }

    public Drawable getActiveIndicatorDrawable() {
        return this.m == null ? null : this.m.getBackground();
    }

    public a getBadge() {
        return this.e0;
    }

    private View getIconOrContainer() {
        View view0 = this.l;
        return view0 != null ? view0 : this.n;
    }

    public int getItemBackgroundResId() [...] // Inlined contents

    @Override  // k.x
    public m getItemData() {
        return this.E;
    }

    public int getItemDefaultMarginResId() {
        return 0x7F0703A5;  // dimen:mtrl_navigation_bar_item_default_margin
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.B;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup0 = (ViewGroup)this.getParent();
        int v = viewGroup0.indexOfChild(this);
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            if(view0 instanceof NavigationBarItemView && view0.getVisibility() == 0) {
                ++v2;
            }
        }
        return v2;
    }

    private int getSuggestedIconHeight() {
        int v = ((FrameLayout.LayoutParams)this.getIconOrContainer().getLayoutParams()).topMargin;
        return this.getIconOrContainer().getMeasuredHeight() + v;
    }

    private int getSuggestedIconWidth() {
        int v = this.e0 == null ? 0 : this.e0.getMinimumWidth() - ((int)this.e0.e.b.M);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)this.getIconOrContainer().getLayoutParams();
        int v1 = Math.max(v, frameLayout$LayoutParams0.leftMargin);
        int v2 = this.n.getMeasuredWidth();
        return Math.max(v, frameLayout$LayoutParams0.rightMargin) + (v2 + v1);
    }

    @Override  // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)this.o.getLayoutParams();
        int v = this.getSuggestedIconHeight() + (this.o.getVisibility() == 0 ? this.f : 0) + frameLayout$LayoutParams0.topMargin;
        return this.o.getMeasuredHeight() + v + frameLayout$LayoutParams0.bottomMargin;
    }

    @Override  // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)this.o.getLayoutParams();
        int v = frameLayout$LayoutParams0.leftMargin;
        int v1 = this.o.getMeasuredWidth() + v + frameLayout$LayoutParams0.rightMargin;
        return Math.max(this.getSuggestedIconWidth(), v1);
    }

    public static void h(View view0, int v, int v1) {
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        frameLayout$LayoutParams0.topMargin = v;
        frameLayout$LayoutParams0.bottomMargin = v;
        frameLayout$LayoutParams0.gravity = v1;
        view0.setLayoutParams(frameLayout$LayoutParams0);
    }

    public final void i(int v) {
        View view0 = this.m;
        if(view0 != null && v > 0) {
            int v1 = Math.min(this.W, v - this.d0 * 2);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            frameLayout$LayoutParams0.height = !this.c0 || this.j != 2 ? this.b0 : v1;
            frameLayout$LayoutParams0.width = v1;
            view0.setLayoutParams(frameLayout$LayoutParams0);
        }
    }

    public static void j(View view0, int v) {
        view0.setPadding(view0.getPaddingLeft(), view0.getPaddingTop(), view0.getPaddingRight(), v);
    }

    @Override  // android.view.ViewGroup
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.E != null && this.E.isCheckable() && this.E.isChecked()) {
            View.mergeDrawableStates(arr_v, NavigationBarItemView.f0);
        }
        return arr_v;
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        if(this.e0 != null && this.e0.isVisible()) {
            accessibilityNodeInfo0.setContentDescription((TextUtils.isEmpty(this.E.q) ? this.E.e : this.E.q) + ", " + this.e0.c());
        }
        accessibilityNodeInfo0.setCollectionItemInfo(((AccessibilityNodeInfo.CollectionItemInfo)f.c(0, 1, this.getItemVisiblePosition(), 1, false, this.isSelected()).a));
        if(this.isSelected()) {
            accessibilityNodeInfo0.setClickable(false);
            accessibilityNodeInfo0.removeAction(((AccessibilityNodeInfo.AccessibilityAction)d2.c.g.a));
        }
        accessibilityNodeInfo0.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", "Tab");
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.post(new Z1.a(this, v, 2));
    }

    public void setActiveIndicatorDrawable(Drawable drawable0) {
        View view0 = this.m;
        if(view0 == null) {
            return;
        }
        view0.setBackgroundDrawable(drawable0);
        this.d();
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.V = z;
        this.d();
        View view0 = this.m;
        if(view0 != null) {
            view0.setVisibility((z ? 0 : 8));
            this.requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int v) {
        this.b0 = v;
        this.i(this.getWidth());
    }

    public void setActiveIndicatorLabelPadding(int v) {
        if(this.f != v) {
            this.f = v;
            this.b();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int v) {
        this.d0 = v;
        this.i(this.getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.c0 = z;
    }

    public void setActiveIndicatorWidth(int v) {
        this.W = v;
        this.i(this.getWidth());
    }

    public void setBadge(a a0) {
        a a1 = this.e0;
        if(a1 != a0) {
            ImageView imageView0 = this.n;
            if(a1 != null && imageView0 != null) {
                Log.w("NavigationBar", "Multiple badges shouldn\'t be attached to one item.");
                if(this.e0 != null) {
                    this.setClipChildren(true);
                    this.setClipToPadding(true);
                    a a2 = this.e0;
                    if(a2 != null) {
                        if(a2.d() == null) {
                            imageView0.getOverlay().remove(a2);
                        }
                        else {
                            a2.d().setForeground(null);
                        }
                    }
                    this.e0 = null;
                }
            }
            this.e0 = a0;
            if(imageView0 != null && a0 != null) {
                this.setClipChildren(false);
                this.setClipToPadding(false);
                a a3 = this.e0;
                Rect rect0 = new Rect();
                imageView0.getDrawingRect(rect0);
                a3.setBounds(rect0);
                a3.i(imageView0, null);
                if(a3.d() != null) {
                    a3.d().setForeground(a3);
                    return;
                }
                imageView0.getOverlay().add(a3);
            }
        }
    }

    public void setCheckable(boolean z) {
        this.refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView0 = this.w;
        textView0.setPivotX(((float)(textView0.getWidth() / 2)));
        textView0.setPivotY(((float)textView0.getBaseline()));
        TextView textView1 = this.r;
        textView1.setPivotX(((float)(textView1.getWidth() / 2)));
        textView1.setPivotY(((float)textView1.getBaseline()));
        if(!this.V || !this.a || !this.isAttachedToWindow()) {
            this.e((z ? 1.0f : 0.0f), (z ? 1.0f : 0.0f));
        }
        else {
            ValueAnimator valueAnimator0 = this.N;
            if(valueAnimator0 != null) {
                valueAnimator0.cancel();
                this.N = null;
            }
            ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[]{this.T, (z ? 1.0f : 0.0f)});
            this.N = valueAnimator1;
            valueAnimator1.addUpdateListener(new b(this, (z ? 1.0f : 0.0f)));
            this.N.setInterpolator(n.C(this.getContext(), 0x7F040464, e6.a.b));  // attr:motionEasingEmphasizedInterpolator
            this.N.setDuration(((long)n.B(this.getContext(), 0x7F040454, this.getResources().getInteger(0x7F0B0033))));  // attr:motionDurationLong2
            this.N.start();
        }
        ViewGroup viewGroup0 = this.o;
        switch(this.j) {
            case -1: {
                if(!this.k) {
                    NavigationBarItemView.j(viewGroup0, this.e);
                    if(z) {
                        NavigationBarItemView.h(this.getIconOrContainer(), ((int)(((float)this.d) + this.g)), 49);
                        NavigationBarItemView.g(textView0, 1.0f, 1.0f, 0);
                        NavigationBarItemView.g(textView1, this.h, this.h, 4);
                    }
                    else {
                        NavigationBarItemView.h(this.getIconOrContainer(), this.d, 49);
                        NavigationBarItemView.g(textView0, this.i, this.i, 4);
                        NavigationBarItemView.g(textView1, 1.0f, 1.0f, 0);
                    }
                }
                else if(z) {
                    NavigationBarItemView.h(this.getIconOrContainer(), this.d, 49);
                    NavigationBarItemView.j(viewGroup0, this.e);
                    textView0.setVisibility(0);
                    textView1.setVisibility(4);
                }
                else {
                    NavigationBarItemView.h(this.getIconOrContainer(), this.d, 17);
                    NavigationBarItemView.j(viewGroup0, 0);
                    textView0.setVisibility(4);
                    textView1.setVisibility(4);
                }
                break;
            }
            case 0: {
                if(z) {
                    NavigationBarItemView.h(this.getIconOrContainer(), this.d, 49);
                    NavigationBarItemView.j(viewGroup0, this.e);
                    textView0.setVisibility(0);
                }
                else {
                    NavigationBarItemView.h(this.getIconOrContainer(), this.d, 17);
                    NavigationBarItemView.j(viewGroup0, 0);
                    textView0.setVisibility(4);
                }
                textView1.setVisibility(4);
                break;
            }
            case 1: {
                NavigationBarItemView.j(viewGroup0, this.e);
                if(z) {
                    NavigationBarItemView.h(this.getIconOrContainer(), ((int)(((float)this.d) + this.g)), 49);
                    NavigationBarItemView.g(textView0, 1.0f, 1.0f, 0);
                    NavigationBarItemView.g(textView1, this.h, this.h, 4);
                }
                else {
                    NavigationBarItemView.h(this.getIconOrContainer(), this.d, 49);
                    NavigationBarItemView.g(textView0, this.i, this.i, 4);
                    NavigationBarItemView.g(textView1, 1.0f, 1.0f, 0);
                }
                break;
            }
            case 2: {
                NavigationBarItemView.h(this.getIconOrContainer(), this.d, 17);
                textView0.setVisibility(8);
                textView1.setVisibility(8);
            }
        }
        this.refreshDrawableState();
        this.setSelected(z);
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.r.setEnabled(z);
        this.w.setEnabled(z);
        this.n.setEnabled(z);
        if(z) {
            O.a(this, PointerIcon.getSystemIcon(this.getContext(), 1002));
            return;
        }
        O.a(this, null);
    }

    public void setIcon(Drawable drawable0) {
        if(drawable0 == this.I) {
            return;
        }
        this.I = drawable0;
        if(drawable0 != null) {
            Drawable.ConstantState drawable$ConstantState0 = drawable0.getConstantState();
            if(drawable$ConstantState0 != null) {
                drawable0 = drawable$ConstantState0.newDrawable();
            }
            drawable0 = drawable0.mutate();
            this.M = drawable0;
            ColorStateList colorStateList0 = this.G;
            if(colorStateList0 != null) {
                drawable0.setTintList(colorStateList0);
            }
        }
        this.n.setImageDrawable(drawable0);
    }

    public void setIconSize(int v) {
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)this.n.getLayoutParams();
        frameLayout$LayoutParams0.width = v;
        frameLayout$LayoutParams0.height = v;
        this.n.setLayoutParams(frameLayout$LayoutParams0);
    }

    public void setIconTintList(ColorStateList colorStateList0) {
        this.G = colorStateList0;
        if(this.E != null) {
            Drawable drawable0 = this.M;
            if(drawable0 != null) {
                drawable0.setTintList(colorStateList0);
                this.M.invalidateSelf();
            }
        }
    }

    public void setItemBackground(int v) {
        this.setItemBackground((v == 0 ? null : P1.c.getDrawable(this.getContext(), v)));
    }

    public void setItemBackground(Drawable drawable0) {
        if(drawable0 != null && drawable0.getConstantState() != null) {
            drawable0 = drawable0.getConstantState().newDrawable().mutate();
        }
        this.c = drawable0;
        this.d();
    }

    public void setItemPaddingBottom(int v) {
        if(this.e != v) {
            this.e = v;
            this.b();
        }
    }

    public void setItemPaddingTop(int v) {
        if(this.d != v) {
            this.d = v;
            this.b();
        }
    }

    public void setItemPosition(int v) {
        this.B = v;
    }

    public void setItemRippleColor(ColorStateList colorStateList0) {
        this.b = colorStateList0;
        this.d();
    }

    public void setLabelVisibilityMode(int v) {
        if(this.j != v) {
            this.j = v;
            this.S = !this.c0 || v != 2 ? NavigationBarItemView.g0 : NavigationBarItemView.h0;
            this.i(this.getWidth());
            this.b();
        }
    }

    public void setShifting(boolean z) {
        if(this.k != z) {
            this.k = z;
            this.b();
        }
    }

    public void setTextAppearanceActive(int v) {
        this.D = v;
        NavigationBarItemView.f(this.w, v);
        this.a(this.r.getTextSize(), this.w.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z) {
        this.setTextAppearanceActive(this.D);
        Typeface typeface0 = this.w.getTypeface();
        this.w.setTypeface(typeface0, ((int)z));
    }

    public void setTextAppearanceInactive(int v) {
        NavigationBarItemView.f(this.r, v);
        this.a(this.r.getTextSize(), this.w.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList0) {
        if(colorStateList0 != null) {
            this.r.setTextColor(colorStateList0);
            this.w.setTextColor(colorStateList0);
        }
    }

    public void setTitle(CharSequence charSequence0) {
        this.r.setText(charSequence0);
        this.w.setText(charSequence0);
        if(this.E == null || TextUtils.isEmpty(this.E.q)) {
            this.setContentDescription(charSequence0);
        }
        if(this.E != null && !TextUtils.isEmpty(this.E.r)) {
            charSequence0 = this.E.r;
        }
        l1.a(this, charSequence0);
    }
}

