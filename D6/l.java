package D6;

import B6.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.l1;
import c2.O;
import com.google.android.material.internal.B;
import com.google.android.material.tabs.TabLayout;
import d2.c;
import d5.w;
import f6.a;

public final class l extends LinearLayout {
    public i a;
    public TextView b;
    public ImageView c;
    public View d;
    public a e;
    public View f;
    public TextView g;
    public ImageView h;
    public Drawable i;
    public int j;
    public final TabLayout k;
    public static final int l;

    public l(TabLayout tabLayout0, Context context0) {
        this.k = tabLayout0;
        super(context0);
        this.j = 2;
        this.e(context0);
        this.setPaddingRelative(tabLayout0.e, tabLayout0.f, tabLayout0.g, tabLayout0.h);
        this.setGravity(17);
        this.setOrientation(!tabLayout0.c0);
        this.setClickable(true);
        O.a(this, PointerIcon.getSystemIcon(this.getContext(), 1002));
    }

    public final void a() {
        if(this.e != null) {
            this.setClipChildren(true);
            this.setClipToPadding(true);
            ViewGroup viewGroup0 = (ViewGroup)this.getParent();
            if(viewGroup0 != null) {
                viewGroup0.setClipChildren(true);
                viewGroup0.setClipToPadding(true);
            }
            View view0 = this.d;
            if(view0 != null) {
                a a0 = this.e;
                if(a0 != null) {
                    if(a0.d() == null) {
                        view0.getOverlay().remove(a0);
                    }
                    else {
                        a0.d().setForeground(null);
                    }
                }
                this.d = null;
            }
        }
    }

    public final void b() {
        if(this.e != null) {
            if(this.f != null) {
                this.a();
                return;
            }
            ImageView imageView0 = this.c;
            if(imageView0 != null && (this.a != null && this.a.a != null)) {
                if(this.d != imageView0) {
                    this.a();
                    ImageView imageView1 = this.c;
                    if(this.e == null || imageView1 == null) {
                        return;
                    }
                    this.setClipChildren(false);
                    this.setClipToPadding(false);
                    ViewGroup viewGroup0 = (ViewGroup)this.getParent();
                    if(viewGroup0 != null) {
                        viewGroup0.setClipChildren(false);
                        viewGroup0.setClipToPadding(false);
                    }
                    a a0 = this.e;
                    Rect rect0 = new Rect();
                    imageView1.getDrawingRect(rect0);
                    a0.setBounds(rect0);
                    a0.i(imageView1, null);
                    if(a0.d() == null) {
                        imageView1.getOverlay().add(a0);
                    }
                    else {
                        a0.d().setForeground(a0);
                    }
                    this.d = imageView1;
                    return;
                }
                this.c(imageView0);
                return;
            }
            TextView textView0 = this.b;
            if(textView0 != null && this.a != null) {
                if(this.d != textView0) {
                    this.a();
                    TextView textView1 = this.b;
                    if(this.e != null && textView1 != null) {
                        this.setClipChildren(false);
                        this.setClipToPadding(false);
                        ViewGroup viewGroup1 = (ViewGroup)this.getParent();
                        if(viewGroup1 != null) {
                            viewGroup1.setClipChildren(false);
                            viewGroup1.setClipToPadding(false);
                        }
                        a a1 = this.e;
                        Rect rect1 = new Rect();
                        textView1.getDrawingRect(rect1);
                        a1.setBounds(rect1);
                        a1.i(textView1, null);
                        if(a1.d() == null) {
                            textView1.getOverlay().add(a1);
                        }
                        else {
                            a1.d().setForeground(a1);
                        }
                        this.d = textView1;
                    }
                    return;
                }
                this.c(textView0);
                return;
            }
            this.a();
        }
    }

    public final void c(View view0) {
        a a0 = this.e;
        if(a0 != null && view0 == this.d) {
            Rect rect0 = new Rect();
            view0.getDrawingRect(rect0);
            a0.setBounds(rect0);
            a0.i(view0, null);
        }
    }

    public final void d() {
        boolean z;
        this.f();
        i i0 = this.a;
        if(i0 == null) {
            z = false;
        }
        else {
            TabLayout tabLayout0 = i0.f;
            if(tabLayout0 == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int v = tabLayout0.getSelectedTabPosition();
            z = v == -1 || v != i0.d ? false : true;
        }
        this.setSelected(z);
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] arr_v = this.getDrawableState();
        if((this.i == null || !this.i.isStateful() ? false : this.i.setState(arr_v))) {
            this.invalidate();
            this.k.invalidate();
        }
    }

    public final void e(Context context0) {
        TabLayout tabLayout0 = this.k;
        int v = tabLayout0.E;
        GradientDrawable gradientDrawable0 = null;
        if(v == 0) {
            this.i = null;
        }
        else {
            Drawable drawable0 = w.B(context0, v);
            this.i = drawable0;
            if(drawable0 != null && drawable0.isStateful()) {
                this.i.setState(this.getDrawableState());
            }
        }
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        gradientDrawable1.setColor(0);
        if(tabLayout0.n != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(0.00001f);
            gradientDrawable2.setColor(-1);
            ColorStateList colorStateList0 = x6.a.a(tabLayout0.n);
            boolean z = tabLayout0.g0;
            if(z) {
                gradientDrawable1 = null;
            }
            if(!z) {
                gradientDrawable0 = gradientDrawable2;
            }
            gradientDrawable1 = new RippleDrawable(colorStateList0, gradientDrawable1, gradientDrawable0);
        }
        this.setBackground(gradientDrawable1);
        tabLayout0.invalidate();
    }

    public final void f() {
        i i0 = this.a;
        View view0 = i0 == null ? null : i0.e;
        if(view0 == null) {
            View view2 = this.f;
            if(view2 != null) {
                this.removeView(view2);
                this.f = null;
            }
            this.g = null;
            this.h = null;
        }
        else {
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 != this) {
                if(viewParent0 != null) {
                    ((ViewGroup)viewParent0).removeView(view0);
                }
                View view1 = this.f;
                if(view1 != null) {
                    ViewParent viewParent1 = view1.getParent();
                    if(viewParent1 != null) {
                        ((ViewGroup)viewParent1).removeView(this.f);
                    }
                }
                this.addView(view0);
            }
            this.f = view0;
            TextView textView0 = this.b;
            if(textView0 != null) {
                textView0.setVisibility(8);
            }
            ImageView imageView0 = this.c;
            if(imageView0 != null) {
                imageView0.setVisibility(8);
                this.c.setImageDrawable(null);
            }
            TextView textView1 = (TextView)view0.findViewById(0x1020014);
            this.g = textView1;
            if(textView1 != null) {
                this.j = textView1.getMaxLines();
            }
            this.h = (ImageView)view0.findViewById(0x1020006);
        }
        if(this.f == null) {
            if(this.c == null) {
                ImageView imageView1 = (ImageView)LayoutInflater.from(this.getContext()).inflate(0x7F0D01EC, this, false);  // layout:design_layout_tab_icon
                this.c = imageView1;
                this.addView(imageView1, 0);
            }
            if(this.b == null) {
                TextView textView2 = (TextView)LayoutInflater.from(this.getContext()).inflate(0x7F0D01ED, this, false);  // layout:design_layout_tab_text
                this.b = textView2;
                this.addView(textView2);
                this.j = this.b.getMaxLines();
            }
            TabLayout tabLayout0 = this.k;
            this.b.setTextAppearance(tabLayout0.i);
            if(this.isSelected()) {
                int v = tabLayout0.k;
                if(v == -1) {
                    this.b.setTextAppearance(tabLayout0.j);
                }
                else {
                    this.b.setTextAppearance(v);
                }
            }
            else {
                this.b.setTextAppearance(tabLayout0.j);
            }
            ColorStateList colorStateList0 = tabLayout0.l;
            if(colorStateList0 != null) {
                this.b.setTextColor(colorStateList0);
            }
            this.g(this.b, this.c, true);
            this.b();
            ImageView imageView2 = this.c;
            if(imageView2 != null) {
                imageView2.addOnLayoutChangeListener(new k(this, imageView2));
            }
            TextView textView3 = this.b;
            if(textView3 != null) {
                textView3.addOnLayoutChangeListener(new k(this, textView3));
            }
        }
        else {
            TextView textView4 = this.g;
            if(textView4 != null || this.h != null) {
                this.g(textView4, this.h, false);
            }
        }
        if(i0 != null && !TextUtils.isEmpty(i0.c)) {
            this.setContentDescription(i0.c);
        }
    }

    public final void g(TextView textView0, ImageView imageView0, boolean z) {
        boolean z2;
        Drawable drawable1;
        i i0 = this.a;
        CharSequence charSequence0 = null;
        if(i0 == null) {
            drawable1 = null;
        }
        else {
            Drawable drawable0 = i0.a;
            drawable1 = drawable0 == null ? null : drawable0.mutate();
        }
        TabLayout tabLayout0 = this.k;
        if(drawable1 != null) {
            drawable1.setTintList(tabLayout0.m);
            PorterDuff.Mode porterDuff$Mode0 = tabLayout0.w;
            if(porterDuff$Mode0 != null) {
                drawable1.setTintMode(porterDuff$Mode0);
            }
        }
        CharSequence charSequence1 = this.a == null ? null : this.a.b;
        if(imageView0 != null) {
            if(drawable1 == null) {
                imageView0.setVisibility(8);
                imageView0.setImageDrawable(null);
            }
            else {
                imageView0.setImageDrawable(drawable1);
                imageView0.setVisibility(0);
                this.setVisibility(0);
            }
        }
        boolean z1 = TextUtils.isEmpty(charSequence1);
        if(textView0 == null) {
            z2 = false;
        }
        else {
            if(z1) {
                z2 = false;
            }
            else {
                this.a.getClass();
                z2 = true;
            }
            textView0.setText((z1 ? null : charSequence1));
            textView0.setVisibility((z2 ? 0 : 8));
            if(!z1) {
                this.setVisibility(0);
            }
        }
        if(z && imageView0 != null) {
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)imageView0.getLayoutParams();
            int v = !z2 || imageView0.getVisibility() != 0 ? 0 : ((int)B.g(this.getContext(), 8));
            if(!tabLayout0.c0) {
                if(v != viewGroup$MarginLayoutParams0.bottomMargin) {
                    viewGroup$MarginLayoutParams0.bottomMargin = v;
                    viewGroup$MarginLayoutParams0.setMarginEnd(0);
                    imageView0.setLayoutParams(viewGroup$MarginLayoutParams0);
                    imageView0.requestLayout();
                }
            }
            else if(v != viewGroup$MarginLayoutParams0.getMarginEnd()) {
                viewGroup$MarginLayoutParams0.setMarginEnd(v);
                viewGroup$MarginLayoutParams0.bottomMargin = 0;
                imageView0.setLayoutParams(viewGroup$MarginLayoutParams0);
                imageView0.requestLayout();
            }
        }
        i i1 = this.a;
        if(i1 != null) {
            charSequence0 = i1.c;
        }
        if(z1) {
            charSequence1 = charSequence0;
        }
        l1.a(this, charSequence1);
    }

    private a getBadge() {
        return this.e;
    }

    public int getContentHeight() {
        View[] arr_view = {this.b, this.c, this.f};
        int v = 0;
        int v1 = 0;
        boolean z = false;
        for(int v2 = 0; v2 < 3; ++v2) {
            View view0 = arr_view[v2];
            if(view0 != null && view0.getVisibility() == 0) {
                v1 = z ? Math.min(v1, view0.getTop()) : view0.getTop();
                v = z ? Math.max(v, view0.getBottom()) : view0.getBottom();
                z = true;
            }
        }
        return v - v1;
    }

    public int getContentWidth() {
        View[] arr_view = {this.b, this.c, this.f};
        int v = 0;
        int v1 = 0;
        boolean z = false;
        for(int v2 = 0; v2 < 3; ++v2) {
            View view0 = arr_view[v2];
            if(view0 != null && view0.getVisibility() == 0) {
                v1 = z ? Math.min(v1, view0.getLeft()) : view0.getLeft();
                v = z ? Math.max(v, view0.getRight()) : view0.getRight();
                z = true;
            }
        }
        return v - v1;
    }

    private a getOrCreateBadge() {
        if(this.e == null) {
            this.e = new a(this.getContext(), null);
        }
        this.b();
        a a0 = this.e;
        if(a0 == null) {
            throw new IllegalStateException("Unable to create badge");
        }
        return a0;
    }

    public i getTab() {
        return this.a;
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        if(this.e != null && this.e.isVisible()) {
            accessibilityNodeInfo0.setContentDescription(this.e.c());
        }
        accessibilityNodeInfo0.setCollectionItemInfo(((AccessibilityNodeInfo.CollectionItemInfo)f.c(0, 1, this.a.d, 1, false, this.isSelected()).a));
        if(this.isSelected()) {
            accessibilityNodeInfo0.setClickable(false);
            accessibilityNodeInfo0.removeAction(((AccessibilityNodeInfo.AccessibilityAction)c.g.a));
        }
        accessibilityNodeInfo0.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", "Tab");
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = View.MeasureSpec.getMode(v);
        TabLayout tabLayout0 = this.k;
        int v4 = tabLayout0.getTabMaxWidth();
        if(v4 > 0 && (v3 == 0 || v2 > v4)) {
            v = View.MeasureSpec.makeMeasureSpec(tabLayout0.G, 0x80000000);
        }
        super.onMeasure(v, v1);
        if(this.b != null) {
            float f = tabLayout0.B;
            int v5 = this.j;
            if(this.c != null && this.c.getVisibility() == 0) {
                v5 = 1;
            }
            else if(this.b != null && this.b.getLineCount() > 1) {
                f = tabLayout0.D;
            }
            float f1 = this.b.getTextSize();
            int v6 = this.b.getLineCount();
            int v7 = this.b.getMaxLines();
            int v8 = Float.compare(f, f1);
            if(v8 != 0 || v7 >= 0 && v5 != v7) {
                if(tabLayout0.b0 == 1 && v8 > 0 && v6 == 1) {
                    Layout layout0 = this.b.getLayout();
                    if(layout0 == null) {
                        return;
                    }
                    float f2 = layout0.getLineWidth(0);
                    if(f / layout0.getPaint().getTextSize() * f2 > ((float)(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()))) {
                        return;
                    }
                }
                this.b.setTextSize(0, f);
                this.b.setMaxLines(v5);
                super.onMeasure(v, v1);
            }
        }
    }

    @Override  // android.view.View
    public final boolean performClick() {
        boolean z = super.performClick();
        if(this.a != null) {
            if(!z) {
                this.playSoundEffect(0);
            }
            i i0 = this.a;
            TabLayout tabLayout0 = i0.f;
            if(tabLayout0 == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout0.j(i0, true);
            return true;
        }
        return z;
    }

    @Override  // android.view.View
    public void setSelected(boolean z) {
        this.isSelected();
        super.setSelected(z);
        TextView textView0 = this.b;
        if(textView0 != null) {
            textView0.setSelected(z);
        }
        ImageView imageView0 = this.c;
        if(imageView0 != null) {
            imageView0.setSelected(z);
        }
        View view0 = this.f;
        if(view0 != null) {
            view0.setSelected(z);
        }
    }

    public void setTab(i i0) {
        if(i0 != this.a) {
            this.a = i0;
            this.d();
        }
    }
}

