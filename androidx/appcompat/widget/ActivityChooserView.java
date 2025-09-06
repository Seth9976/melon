package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import androidx.core.view.ActionProvider;
import c2.W;
import c2.c;
import d5.m;
import g.a;

public class ActivityChooserView extends ViewGroup {
    public static class InnerLayout extends LinearLayout {
        public static final int[] a;

        static {
            InnerLayout.a = new int[]{0x10100D4};
        }

        public InnerLayout(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            m m0 = m.q(context0, attributeSet0, InnerLayout.a);
            this.setBackgroundDrawable(m0.k(0));
            m0.t();
        }
    }

    public final t a;
    public final u b;
    public final View c;
    public final Drawable d;
    public final FrameLayout e;
    public final ImageView f;
    public final FrameLayout g;
    public final int h;
    public ActionProvider i;
    public final q j;
    public final r k;
    public ListPopupWindow l;
    public PopupWindow.OnDismissListener m;
    public boolean n;
    public int o;
    public boolean r;

    public ActivityChooserView(Context context0) {
        this(context0, null);
    }

    public ActivityChooserView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ActivityChooserView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.j = new q(this, 0);
        this.k = new r(this, 0);
        this.o = 4;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.e, v, 0);
        W.n(this, context0, a.e, attributeSet0, typedArray0, v);
        this.o = typedArray0.getInt(1, 4);
        Drawable drawable0 = typedArray0.getDrawable(0);
        typedArray0.recycle();
        LayoutInflater.from(this.getContext()).inflate(0x7F0D0006, this, true);  // layout:abc_activity_chooser_view
        u u0 = new u(this);
        this.b = u0;
        View view0 = this.findViewById(0x7F0A0066);  // id:activity_chooser_view_content
        this.c = view0;
        this.d = view0.getBackground();
        FrameLayout frameLayout0 = (FrameLayout)this.findViewById(0x7F0A0395);  // id:default_activity_button
        this.g = frameLayout0;
        frameLayout0.setOnClickListener(u0);
        frameLayout0.setOnLongClickListener(u0);
        ImageView imageView0 = (ImageView)frameLayout0.findViewById(0x7F0A0558);  // id:image
        FrameLayout frameLayout1 = (FrameLayout)this.findViewById(0x7F0A0472);  // id:expand_activities_button
        frameLayout1.setOnClickListener(u0);
        frameLayout1.setAccessibilityDelegate(new s());  // 初始化器: Landroid/view/View$AccessibilityDelegate;-><init>()V
        frameLayout1.setOnTouchListener(new i(this, frameLayout1, 1));
        this.e = frameLayout1;
        ImageView imageView1 = (ImageView)frameLayout1.findViewById(0x7F0A0558);  // id:image
        this.f = imageView1;
        imageView1.setImageDrawable(drawable0);
        t t0 = new t(this);
        this.a = t0;
        t0.registerDataSetObserver(new q(this, 1));
        Resources resources0 = context0.getResources();
        this.h = Math.max(resources0.getDisplayMetrics().widthPixels / 2, resources0.getDimensionPixelSize(0x7F070017));  // dimen:abc_config_prefDialogWidth
    }

    public final void a() {
        if(this.b()) {
            this.getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver0 = this.getViewTreeObserver();
            if(viewTreeObserver0.isAlive()) {
                viewTreeObserver0.removeGlobalOnLayoutListener(this.k);
            }
        }
    }

    public final boolean b() {
        return this.getListPopupWindow().T.isShowing();
    }

    public final void c(int v) {
        t t0 = this.a;
        if(t0.a == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        this.getViewTreeObserver().addOnGlobalLayoutListener(this.k);
        int v1 = this.g.getVisibility() == 0 ? 1 : 0;
        if(v == 0x7FFFFFFF || t0.a.d() <= v + v1) {
            if(t0.e) {
                t0.e = false;
                t0.notifyDataSetChanged();
            }
            if(t0.b != v) {
                t0.b = v;
                t0.notifyDataSetChanged();
            }
        }
        else {
            if(!t0.e) {
                t0.e = true;
                t0.notifyDataSetChanged();
            }
            if(t0.b != v - 1) {
                t0.b = v - 1;
                t0.notifyDataSetChanged();
            }
        }
        ListPopupWindow listPopupWindow0 = this.getListPopupWindow();
        if(!listPopupWindow0.T.isShowing()) {
            if(this.n || v1 == 0) {
                if(!t0.c || t0.d != v1) {
                    t0.c = true;
                    t0.d = v1;
                    t0.notifyDataSetChanged();
                }
            }
            else if(t0.c || t0.d) {
                t0.c = false;
                t0.d = false;
                t0.notifyDataSetChanged();
            }
            int v2 = t0.b;
            t0.b = 0x7FFFFFFF;
            int v3 = t0.getCount();
            int v5 = 0;
            View view0 = null;
            for(int v4 = 0; v4 < v3; ++v4) {
                view0 = t0.getView(v4, view0, null);
                view0.measure(0, 0);
                v5 = Math.max(v5, view0.getMeasuredWidth());
            }
            t0.b = v2;
            listPopupWindow0.q(Math.min(v5, this.h));
            listPopupWindow0.show();
            ActionProvider actionProvider0 = this.i;
            if(actionProvider0 != null) {
                c c0 = actionProvider0.b;
                if(c0 != null) {
                    ((ActionMenuPresenter)c0).n(true);
                }
            }
            listPopupWindow0.c.setContentDescription("Choose an app");
            listPopupWindow0.c.setSelector(new ColorDrawable(0));
        }
    }

    public p getDataModel() {
        return this.a.a;
    }

    public ListPopupWindow getListPopupWindow() {
        if(this.l == null) {
            ListPopupWindow listPopupWindow0 = new ListPopupWindow(this.getContext());
            this.l = listPopupWindow0;
            listPopupWindow0.l(this.a);
            this.l.o = this;
            this.l.S = true;
            this.l.T.setFocusable(true);
            this.l.r = this.b;
            this.l.T.setOnDismissListener(this.b);
        }
        return this.l;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        p p0 = this.a.a;
        if(p0 != null) {
            p0.registerObserver(this.j);
        }
        this.r = true;
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p p0 = this.a.a;
        if(p0 != null) {
            p0.unregisterObserver(this.j);
        }
        ViewTreeObserver viewTreeObserver0 = this.getViewTreeObserver();
        if(viewTreeObserver0.isAlive()) {
            viewTreeObserver0.removeGlobalOnLayoutListener(this.k);
        }
        if(this.b()) {
            this.a();
        }
        this.r = false;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        this.c.layout(0, 0, v2 - v, v3 - v1);
        if(!this.b()) {
            this.a();
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        if(this.g.getVisibility() != 0) {
            v1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(v1), 0x40000000);
        }
        this.measureChild(this.c, v, v1);
        this.setMeasuredDimension(this.c.getMeasuredWidth(), this.c.getMeasuredHeight());
    }

    public void setActivityChooserModel(p p0) {
        t t0 = this.a;
        ActivityChooserView activityChooserView0 = t0.f;
        q q0 = activityChooserView0.j;
        p p1 = activityChooserView0.a.a;
        if(p1 != null && activityChooserView0.isShown()) {
            p1.unregisterObserver(q0);
        }
        t0.a = p0;
        if(p0 != null && activityChooserView0.isShown()) {
            p0.registerObserver(q0);
        }
        t0.notifyDataSetChanged();
        if(this.b()) {
            this.a();
            if(!this.b() && this.r) {
                this.n = false;
                this.c(this.o);
            }
        }
    }

    public void setDefaultActionButtonContentDescription(int v) {
    }

    public void setExpandActivityOverflowButtonContentDescription(int v) {
        String s = this.getContext().getString(v);
        this.f.setContentDescription(s);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable0) {
        this.f.setImageDrawable(drawable0);
    }

    public void setInitialActivityCount(int v) {
        this.o = v;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener popupWindow$OnDismissListener0) {
        this.m = popupWindow$OnDismissListener0;
    }

    public void setProvider(ActionProvider actionProvider0) {
        this.i = actionProvider0;
    }
}

