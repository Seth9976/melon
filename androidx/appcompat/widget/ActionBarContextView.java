package androidx.appcompat.widget;

import O.a;
import Q5.k;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import c2.W;
import c2.c0;
import d5.w;
import j.b;
import k.y;

public class ActionBarContextView extends ViewGroup {
    public final int B;
    public boolean D;
    public final int E;
    public final a a;
    public final Context b;
    public ActionMenuView c;
    public ActionMenuPresenter d;
    public int e;
    public c0 f;
    public boolean g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public View k;
    public View l;
    public View m;
    public LinearLayout n;
    public TextView o;
    public TextView r;
    public final int w;

    public ActionBarContextView(Context context0) {
        this(context0, null);
    }

    public ActionBarContextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040028);  // attr:actionModeStyle
    }

    public ActionBarContextView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Drawable drawable0;
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.c = this;
        a0.b = false;
        this.a = a0;
        TypedValue typedValue0 = new TypedValue();
        this.b = !context0.getTheme().resolveAttribute(0x7F040005, typedValue0, true) || typedValue0.resourceId == 0 ? context0 : new ContextThemeWrapper(context0, typedValue0.resourceId);  // attr:actionBarPopupTheme
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, g.a.d, v, 0);
        if(typedArray0.hasValue(0)) {
            int v1 = typedArray0.getResourceId(0, 0);
            drawable0 = v1 == 0 ? typedArray0.getDrawable(0) : w.B(context0, v1);
        }
        else {
            drawable0 = typedArray0.getDrawable(0);
        }
        this.setBackground(drawable0);
        this.w = typedArray0.getResourceId(5, 0);
        this.B = typedArray0.getResourceId(4, 0);
        this.e = typedArray0.getLayoutDimension(3, 0);
        this.E = typedArray0.getResourceId(2, 0x7F0D0005);  // layout:abc_action_mode_close_item_material
        typedArray0.recycle();
    }

    public static void a(ActionBarContextView actionBarContextView0) {
        actionBarContextView0.super.setVisibility(0);
    }

    public final void c(b b0) {
        View view0 = this.k;
        if(view0 == null) {
            View view1 = LayoutInflater.from(this.getContext()).inflate(this.E, this, false);
            this.k = view1;
            this.addView(view1);
        }
        else if(view0.getParent() == null) {
            this.addView(this.k);
        }
        View view2 = this.k.findViewById(0x7F0A0063);  // id:action_mode_close_button
        this.l = view2;
        view2.setOnClickListener(new androidx.appcompat.widget.b(b0, 0));
        MenuBuilder menuBuilder0 = b0.d();
        ActionMenuPresenter actionMenuPresenter0 = this.d;
        if(actionMenuPresenter0 != null) {
            actionMenuPresenter0.l();
            f f0 = actionMenuPresenter0.G;
            if(f0 != null && f0.b()) {
                f0.i.dismiss();
            }
        }
        ActionMenuPresenter actionMenuPresenter1 = new ActionMenuPresenter(this.getContext());
        this.d = actionMenuPresenter1;
        actionMenuPresenter1.m = true;
        actionMenuPresenter1.n = true;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder0.b(this.d, this.b);
        ActionMenuPresenter actionMenuPresenter2 = this.d;
        y y0 = actionMenuPresenter2.h;
        if(y0 == null) {
            y y1 = (y)actionMenuPresenter2.d.inflate(actionMenuPresenter2.f, this, false);
            actionMenuPresenter2.h = y1;
            y1.a(actionMenuPresenter2.c);
            actionMenuPresenter2.i(true);
        }
        y y2 = actionMenuPresenter2.h;
        if(y0 != y2) {
            ((ActionMenuView)y2).setPresenter(actionMenuPresenter2);
        }
        this.c = (ActionMenuView)y2;
        ((ActionMenuView)y2).setBackground(null);
        this.addView(this.c, viewGroup$LayoutParams0);
    }

    public final void d() {
        if(this.n == null) {
            LayoutInflater.from(this.getContext()).inflate(0x7F0D0000, this);  // layout:abc_action_bar_title_item
            LinearLayout linearLayout0 = (LinearLayout)this.getChildAt(this.getChildCount() - 1);
            this.n = linearLayout0;
            this.o = (TextView)linearLayout0.findViewById(0x7F0A0059);  // id:action_bar_title
            this.r = (TextView)this.n.findViewById(0x7F0A0058);  // id:action_bar_subtitle
            int v = this.w;
            if(v != 0) {
                this.o.setTextAppearance(this.getContext(), v);
            }
            int v1 = this.B;
            if(v1 != 0) {
                this.r.setTextAppearance(this.getContext(), v1);
            }
        }
        this.o.setText(this.i);
        this.r.setText(this.j);
        boolean z = TextUtils.isEmpty(this.i);
        boolean z1 = TextUtils.isEmpty(this.j);
        int v2 = 8;
        this.r.setVisibility((z1 ? 8 : 0));
        LinearLayout linearLayout1 = this.n;
        if(!z || !z1) {
            v2 = 0;
        }
        linearLayout1.setVisibility(v2);
        if(this.n.getParent() == null) {
            this.addView(this.n);
        }
    }

    public final void e() {
        this.removeAllViews();
        this.m = null;
        this.c = null;
        this.d = null;
        View view0 = this.l;
        if(view0 != null) {
            view0.setOnClickListener(null);
        }
    }

    public static int f(View view0, int v, int v1) {
        view0.measure(View.MeasureSpec.makeMeasureSpec(v, 0x80000000), v1);
        return Math.max(0, v - view0.getMeasuredWidth());
    }

    public static int g(View view0, boolean z, int v, int v1, int v2) {
        int v3 = view0.getMeasuredWidth();
        int v4 = view0.getMeasuredHeight();
        int v5 = (v2 - v4) / 2 + v1;
        if(z) {
            view0.layout(v - v3, v5, v, v4 + v5);
            return -v3;
        }
        view0.layout(v, v5, v + v3, v4 + v5);
        return v3;
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new ViewGroup.MarginLayoutParams(this.getContext(), attributeSet0);
    }

    public int getAnimatedVisibility() {
        return this.f == null ? this.getVisibility() : this.a.a;
    }

    public int getContentHeight() {
        return this.e;
    }

    public CharSequence getSubtitle() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.i;
    }

    public final void h(int v) {
        if(v != this.getVisibility()) {
            c0 c00 = this.f;
            if(c00 != null) {
                c00.b();
            }
            super.setVisibility(v);
        }
    }

    public final c0 i(int v, long v1) {
        c0 c00 = this.f;
        if(c00 != null) {
            c00.b();
        }
        a a0 = this.a;
        if(v == 0) {
            if(this.getVisibility() != 0) {
                this.setAlpha(0.0f);
            }
            c0 c01 = W.a(this);
            c01.a(1.0f);
            c01.c(v1);
            ((ActionBarContextView)a0.c).f = c01;
            a0.a = 0;
            c01.d(a0);
            return c01;
        }
        c0 c02 = W.a(this);
        c02.a(0.0f);
        c02.c(v1);
        ((ActionBarContextView)a0.c).f = c02;
        a0.a = v;
        c02.d(a0);
        return c02;
    }

    public final void j() {
        ActionMenuPresenter actionMenuPresenter0 = this.d;
        if(actionMenuPresenter0 != null) {
            actionMenuPresenter0.o();
        }
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(null, g.a.a, 0x7F040008, 0);  // attr:actionBarStyle
        this.setContentHeight(typedArray0.getLayoutDimension(13, 0));
        typedArray0.recycle();
        ActionMenuPresenter actionMenuPresenter0 = this.d;
        if(actionMenuPresenter0 != null) {
            actionMenuPresenter0.w = k.c(actionMenuPresenter0.b).d();
            MenuBuilder menuBuilder0 = actionMenuPresenter0.c;
            if(menuBuilder0 != null) {
                menuBuilder0.p(true);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter0 = this.d;
        if(actionMenuPresenter0 != null) {
            actionMenuPresenter0.l();
            f f0 = this.d.G;
            if(f0 != null && f0.b()) {
                f0.i.dismiss();
            }
        }
    }

    @Override  // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 9) {
            this.h = false;
        }
        if(!this.h && (v == 9 && !super.onHoverEvent(motionEvent0))) {
            this.h = true;
        }
        if(v != 3 && v != 10) {
            return true;
        }
        this.h = false;
        return true;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        boolean z1 = this.getLayoutDirection() == 1;
        int v4 = z1 ? v2 - v - this.getPaddingRight() : this.getPaddingLeft();
        int v5 = this.getPaddingTop();
        int v6 = v3 - v1 - this.getPaddingTop() - this.getPaddingBottom();
        if(this.k != null && this.k.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
            int v7 = z1 ? viewGroup$MarginLayoutParams0.rightMargin : viewGroup$MarginLayoutParams0.leftMargin;
            int v8 = z1 ? viewGroup$MarginLayoutParams0.leftMargin : viewGroup$MarginLayoutParams0.rightMargin;
            int v9 = z1 ? v4 - v7 : v4 + v7;
            int v10 = ActionBarContextView.g(this.k, z1, v9, v5, v6) + v9;
            v4 = z1 ? v10 - v8 : v10 + v8;
        }
        if(this.n != null && this.m == null && this.n.getVisibility() != 8) {
            v4 += ActionBarContextView.g(this.n, z1, v4, v5, v6);
        }
        View view0 = this.m;
        if(view0 != null) {
            ActionBarContextView.g(view0, z1, v4, v5, v6);
        }
        int v11 = z1 ? this.getPaddingLeft() : v2 - v - this.getPaddingRight();
        ActionMenuView actionMenuView0 = this.c;
        if(actionMenuView0 != null) {
            ActionBarContextView.g(actionMenuView0, !z1, v11, v5, v6);
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v2 = 0x40000000;
        if(View.MeasureSpec.getMode(v) != 0x40000000) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if(View.MeasureSpec.getMode(v1) == 0) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int v3 = View.MeasureSpec.getSize(v);
        int v4 = this.e > 0 ? this.e : View.MeasureSpec.getSize(v1);
        int v5 = this.getPaddingTop();
        int v6 = this.getPaddingBottom() + v5;
        int v7 = v3 - this.getPaddingLeft() - this.getPaddingRight();
        int v8 = v4 - v6;
        int v9 = View.MeasureSpec.makeMeasureSpec(v8, 0x80000000);
        View view0 = this.k;
        if(view0 != null) {
            int v10 = ActionBarContextView.f(view0, v7, v9);
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
            v7 = v10 - (viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin);
        }
        if(this.c != null && this.c.getParent() == this) {
            v7 = ActionBarContextView.f(this.c, v7, v9);
        }
        LinearLayout linearLayout0 = this.n;
        if(linearLayout0 != null && this.m == null) {
            if(this.D) {
                this.n.measure(0, v9);
                int v12 = this.n.getMeasuredWidth();
                boolean z = v12 <= v7;
                if(z) {
                    v7 -= v12;
                }
                this.n.setVisibility((z ? 0 : 8));
            }
            else {
                v7 = ActionBarContextView.f(linearLayout0, v7, v9);
            }
        }
        View view1 = this.m;
        if(view1 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
            int v13 = viewGroup$LayoutParams0.width;
            if(v13 >= 0) {
                v7 = Math.min(v13, v7);
            }
            int v14 = viewGroup$LayoutParams0.height;
            if(v14 == -2) {
                v2 = 0x80000000;
            }
            if(v14 >= 0) {
                v8 = Math.min(v14, v8);
            }
            this.m.measure(View.MeasureSpec.makeMeasureSpec(v7, (v13 == -2 ? 0x80000000 : 0x40000000)), View.MeasureSpec.makeMeasureSpec(v8, v2));
        }
        if(this.e <= 0) {
            int v15 = this.getChildCount();
            int v16 = 0;
            for(int v11 = 0; v11 < v15; ++v11) {
                int v17 = this.getChildAt(v11).getMeasuredHeight() + v6;
                if(v17 > v16) {
                    v16 = v17;
                }
            }
            this.setMeasuredDimension(v3, v16);
            return;
        }
        this.setMeasuredDimension(v3, v4);
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 0) {
            this.g = false;
        }
        if(!this.g && (v == 0 && !super.onTouchEvent(motionEvent0))) {
            this.g = true;
        }
        if(v != 1 && v != 3) {
            return true;
        }
        this.g = false;
        return true;
    }

    public void setContentHeight(int v) {
        this.e = v;
    }

    public void setCustomView(View view0) {
        View view1 = this.m;
        if(view1 != null) {
            this.removeView(view1);
        }
        this.m = view0;
        if(view0 != null) {
            LinearLayout linearLayout0 = this.n;
            if(linearLayout0 != null) {
                this.removeView(linearLayout0);
                this.n = null;
            }
        }
        if(view0 != null) {
            this.addView(view0);
        }
        this.requestLayout();
    }

    public void setSubtitle(CharSequence charSequence0) {
        this.j = charSequence0;
        this.d();
    }

    public void setTitle(CharSequence charSequence0) {
        this.i = charSequence0;
        this.d();
        W.p(this, charSequence0);
    }

    public void setTitleOptional(boolean z) {
        if(z != this.D) {
            this.requestLayout();
        }
        this.D = z;
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        this.h(v);
    }

    @Override  // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}

