package com.google.android.material.search;

import Q0.x;
import R6.d;
import W.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.media3.session.a0;
import c2.M;
import com.google.android.material.appbar.AppBarLayout.LayoutParams;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.B;
import d5.w;
import e1.n;
import java.util.LinkedHashSet;
import z6.i;
import z6.o;

public class SearchBar extends Toolbar {
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public String c;

        static {
            SavedState.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readString();
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeString(this.c);
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior {
        public boolean g;

        public ScrollingViewBehavior() {
            this.g = false;
        }

        public ScrollingViewBehavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.g = false;
        }

        @Override  // com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior
        public final boolean h(CoordinatorLayout coordinatorLayout0, View view0, View view1) {
            super.h(coordinatorLayout0, view0, view1);
            if(!this.g && view1 instanceof AppBarLayout) {
                this.g = true;
                ((AppBarLayout)view1).setBackgroundColor(0);
                ((AppBarLayout)view1).setTargetElevation(0.0f);
            }
            return false;
        }
    }

    public View A0;
    public final Integer B0;
    public Drawable C0;
    public int D0;
    public boolean E0;
    public final i F0;
    public final AccessibilityManager G0;
    public final a0 H0;
    public static final int I0;
    public final TextView t0;
    public final boolean u0;
    public final boolean v0;
    public final d w0;
    public final Drawable x0;
    public final boolean y0;
    public final boolean z0;

    public SearchBar(Context context0) {
        this(context0, null);
    }

    public SearchBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040411);  // attr:materialSearchBarStyle
    }

    public SearchBar(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F140451), attributeSet0, v);  // style:Widget.Material3.SearchBar
        this.D0 = -1;
        this.H0 = new a0(this, 23);
        Context context1 = this.getContext();
        if(attributeSet0 != null) {
            if(attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "title") != null) {
                throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
            }
            if(attributeSet0.getAttributeValue("http://schemas.android.com/apk/res-auto", "subtitle") != null) {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
        Drawable drawable0 = w.B(context1, 0x7F0805CA);  // drawable:ic_search_black_24
        this.x0 = drawable0;
        d d0 = new d(23);
        new LinkedHashSet();
        new LinkedHashSet();
        new LinkedHashSet();
        this.w0 = d0;
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.V, v, 0x7F140451, new int[0]);  // style:Widget.Material3.SearchBar
        o o0 = o.d(context1, attributeSet0, v, 0x7F140451).a();  // style:Widget.Material3.SearchBar
        int v1 = typedArray0.getColor(3, 0);
        float f = typedArray0.getDimension(6, 0.0f);
        this.v0 = typedArray0.getBoolean(4, true);
        this.E0 = typedArray0.getBoolean(5, true);
        boolean z = typedArray0.getBoolean(8, false);
        this.z0 = typedArray0.getBoolean(7, false);
        this.y0 = typedArray0.getBoolean(12, true);
        if(typedArray0.hasValue(9)) {
            this.B0 = typedArray0.getColor(9, -1);
        }
        int v2 = typedArray0.getResourceId(0, -1);
        String s = typedArray0.getString(1);
        String s1 = typedArray0.getString(2);
        float f1 = typedArray0.getDimension(11, -1.0f);
        int v3 = typedArray0.getColor(10, 0);
        typedArray0.recycle();
        if(!z) {
            if(this.getNavigationIcon() != null) {
                drawable0 = this.getNavigationIcon();
            }
            this.setNavigationIcon(drawable0);
            this.setNavigationIconDecorative(true);
        }
        this.setClickable(true);
        this.setFocusable(true);
        LayoutInflater.from(context1).inflate(0x7F0D054D, this);  // layout:mtrl_search_bar
        this.u0 = true;
        TextView textView0 = (TextView)this.findViewById(0x7F0A08D9);  // id:open_search_bar_text_view
        this.t0 = textView0;
        M.l(this, f);
        if(v2 != -1) {
            textView0.setTextAppearance(v2);
        }
        this.setText(s);
        this.setHint(s1);
        if(this.getNavigationIcon() == null) {
            ((ViewGroup.MarginLayoutParams)textView0.getLayoutParams()).setMarginStart(this.getResources().getDimensionPixelSize(0x7F070288));  // dimen:m3_searchbar_text_margin_start_no_navigation_icon
        }
        i i0 = new i(o0);
        this.F0 = i0;
        i0.k(this.getContext());
        this.F0.l(f);
        if(f1 >= 0.0f) {
            this.F0.s(f1);
            ColorStateList colorStateList0 = ColorStateList.valueOf(v3);
            this.F0.r(colorStateList0);
        }
        int v4 = n.q(this, 0x7F040167);  // attr:colorControlHighlight
        ColorStateList colorStateList1 = ColorStateList.valueOf(v1);
        this.F0.m(colorStateList1);
        this.setBackground(new RippleDrawable(ColorStateList.valueOf(v4), this.F0, this.F0));
        AccessibilityManager accessibilityManager0 = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.G0 = accessibilityManager0;
        if(accessibilityManager0 != null) {
            if(accessibilityManager0.isEnabled() && accessibilityManager0.isTouchExplorationEnabled()) {
                this.setFocusableInTouchMode(true);
            }
            this.addOnAttachStateChangeListener(new x(this, 1));
        }
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.u0 && this.A0 == null && !(view0 instanceof ActionMenuView)) {
            this.A0 = view0;
            view0.setAlpha(0.0f);
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    public View getCenterView() {
        return this.A0;
    }

    public float getCompatElevation() {
        return this.F0 == null ? M.e(this) : this.F0.a.m;
    }

    public float getCornerSize() {
        return this.F0.i();
    }

    public int getDefaultMarginVerticalResource() [...] // Inlined contents

    public int getDefaultNavigationIconResource() [...] // Inlined contents

    public CharSequence getHint() {
        return this.t0.getHint();
    }

    public int getMenuResId() {
        return this.D0;
    }

    public int getStrokeColor() {
        return this.F0.a.d.getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.F0.a.j;
    }

    public CharSequence getText() {
        return this.t0.getText();
    }

    public TextView getTextView() {
        return this.t0;
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void m(int v) {
        Menu menu0 = this.getMenu();
        if(menu0 instanceof MenuBuilder) {
            ((MenuBuilder)menu0).y();
        }
        super.m(v);
        this.D0 = v;
        if(menu0 instanceof MenuBuilder) {
            ((MenuBuilder)menu0).x();
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.A(this, this.F0);
        if(this.v0 && this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            Resources resources0 = this.getResources();
            int v = resources0.getDimensionPixelSize(0x7F070284);  // dimen:m3_searchbar_margin_horizontal
            int v1 = resources0.getDimensionPixelSize(0x7F070285);  // dimen:m3_searchbar_margin_vertical
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.getLayoutParams();
            viewGroup$MarginLayoutParams0.leftMargin = viewGroup$MarginLayoutParams0.leftMargin == 0 ? v : viewGroup$MarginLayoutParams0.leftMargin;
            viewGroup$MarginLayoutParams0.topMargin = viewGroup$MarginLayoutParams0.topMargin == 0 ? v1 : viewGroup$MarginLayoutParams0.topMargin;
            int v2 = viewGroup$MarginLayoutParams0.rightMargin;
            if(v2 != 0) {
                v = v2;
            }
            viewGroup$MarginLayoutParams0.rightMargin = v;
            int v3 = viewGroup$MarginLayoutParams0.bottomMargin;
            if(v3 != 0) {
                v1 = v3;
            }
            viewGroup$MarginLayoutParams0.bottomMargin = v1;
        }
        this.y();
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("android.widget.EditText");
        accessibilityNodeInfo0.setEditable(this.isEnabled());
        CharSequence charSequence0 = this.getText();
        boolean z = TextUtils.isEmpty(charSequence0);
        accessibilityNodeInfo0.setHintText(this.getHint());
        accessibilityNodeInfo0.setShowingHintText(z);
        if(z) {
            charSequence0 = this.getHint();
        }
        accessibilityNodeInfo0.setText(charSequence0);
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        View view0 = this.A0;
        if(view0 != null) {
            int v4 = view0.getMeasuredWidth();
            int v5 = this.getMeasuredWidth() / 2 - v4 / 2;
            int v6 = v4 + v5;
            int v7 = this.A0.getMeasuredHeight();
            int v8 = this.getMeasuredHeight() / 2 - v7 / 2;
            int v9 = v7 + v8;
            View view1 = this.A0;
            if(this.getLayoutDirection() == 1) {
                view1.layout(this.getMeasuredWidth() - v6, v8, this.getMeasuredWidth() - v5, v9);
            }
            else {
                view1.layout(v5, v8, v6, v9);
            }
        }
        this.x();
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        View view0 = this.A0;
        if(view0 != null) {
            view0.measure(v, v1);
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.setText(((SavedState)parcelable0).c);
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        CharSequence charSequence0 = this.getText();
        parcelable0.c = charSequence0 == null ? null : charSequence0.toString();
        return parcelable0;
    }

    public void setCenterView(View view0) {
        View view1 = this.A0;
        if(view1 != null) {
            this.removeView(view1);
            this.A0 = null;
        }
        if(view0 != null) {
            this.addView(view0);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z) {
        this.E0 = z;
        this.y();
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        i i0 = this.F0;
        if(i0 != null) {
            i0.l(f);
        }
    }

    public void setHint(int v) {
        this.t0.setHint(v);
    }

    public void setHint(CharSequence charSequence0) {
        this.t0.setHint(charSequence0);
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable0) {
        if(this.y0 && drawable0 != null) {
            int v = this.B0 == null ? n.q(this, (drawable0 == this.x0 ? 0x7F04017B : 0x7F040179)) : ((int)this.B0);  // attr:colorOnSurfaceVariant
            drawable0 = drawable0.mutate();
            drawable0.setTint(v);
        }
        super.setNavigationIcon(drawable0);
    }

    private void setNavigationIconDecorative(boolean z) {
        ImageButton imageButton0 = B.j(this);
        if(imageButton0 == null) {
            return;
        }
        imageButton0.setClickable(!z);
        imageButton0.setFocusable(!z);
        Drawable drawable0 = imageButton0.getBackground();
        if(drawable0 != null) {
            this.C0 = drawable0;
        }
        imageButton0.setBackgroundDrawable((z ? null : this.C0));
        this.x();
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener view$OnClickListener0) {
        if(this.z0) {
            return;
        }
        super.setNavigationOnClickListener(view$OnClickListener0);
        this.setNavigationIconDecorative(view$OnClickListener0 == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z) {
        this.w0.getClass();
    }

    public void setStrokeColor(int v) {
        if(this.getStrokeColor() != v) {
            ColorStateList colorStateList0 = ColorStateList.valueOf(v);
            this.F0.r(colorStateList0);
        }
    }

    public void setStrokeWidth(float f) {
        if(this.getStrokeWidth() != f) {
            this.F0.s(f);
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence0) {
    }

    public void setText(int v) {
        this.t0.setText(v);
    }

    public void setText(CharSequence charSequence0) {
        this.t0.setText(charSequence0);
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence0) {
    }

    public final void x() {
        int v1;
        if(Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z = true;
        int v = 0;
        if(this.getLayoutDirection() != 1) {
            z = false;
        }
        ImageButton imageButton0 = B.j(this);
        if(imageButton0 == null || !imageButton0.isClickable()) {
            v1 = 0;
        }
        else if(z) {
            v1 = this.getWidth() - imageButton0.getLeft();
        }
        else {
            v1 = imageButton0.getRight();
        }
        ActionMenuView actionMenuView0 = B.h(this);
        if(actionMenuView0 != null) {
            v = z ? actionMenuView0.getRight() : this.getWidth() - actionMenuView0.getLeft();
        }
        int v2 = z ? v : v1;
        if(!z) {
            v1 = v;
        }
        m.w(this, ((float)(-v2)), ((float)(-v1)));
    }

    public final void y() {
        if(this.getLayoutParams() instanceof LayoutParams) {
            LayoutParams appBarLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
            if(this.E0) {
                if(appBarLayout$LayoutParams0.a == 0) {
                    appBarLayout$LayoutParams0.a = 53;
                }
            }
            else if(appBarLayout$LayoutParams0.a == 53) {
                appBarLayout$LayoutParams0.a = 0;
            }
        }
    }
}

