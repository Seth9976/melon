package com.google.android.material.navigation;

import E8.a;
import P1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.transition.AutoTransition;
import b2.f;
import com.google.android.material.internal.z;
import e1.n;
import java.util.HashSet;
import k.m;
import k.y;
import z6.i;
import z6.o;

public abstract class NavigationBarMenuView extends ViewGroup implements y {
    public int B;
    public final SparseArray D;
    public int E;
    public int G;
    public int I;
    public boolean M;
    public int N;
    public int S;
    public int T;
    public o V;
    public boolean W;
    public final AutoTransition a;
    public final a b;
    public ColorStateList b0;
    public final f c;
    public g c0;
    public final SparseArray d;
    public MenuBuilder d0;
    public int e;
    public static final int[] e0;
    public NavigationBarItemView[] f;
    public static final int[] f0;
    public int g;
    public int h;
    public ColorStateList i;
    public int j;
    public ColorStateList k;
    public final ColorStateList l;
    public int m;
    public int n;
    public boolean o;
    public Drawable r;
    public ColorStateList w;

    static {
        NavigationBarMenuView.e0 = new int[]{0x10100A0};
        NavigationBarMenuView.f0 = new int[]{0xFEFEFF62};
    }

    public NavigationBarMenuView(Context context0) {
        super(context0);
        this.c = new f(5);
        this.d = new SparseArray(5);
        this.g = 0;
        this.h = 0;
        this.D = new SparseArray(5);
        this.E = -1;
        this.G = -1;
        this.I = -1;
        this.W = false;
        this.l = this.c();
        if(this.isInEditMode()) {
            this.a = null;
        }
        else {
            AutoTransition autoTransition0 = new AutoTransition();
            this.a = autoTransition0;
            autoTransition0.S(0);
            autoTransition0.Q(((long)n.B(this.getContext(), 0x7F04045A, this.getResources().getInteger(0x7F0B0033))));  // attr:motionDurationMedium4
            autoTransition0.R(n.C(this.getContext(), 0x7F040467, e6.a.b));  // attr:motionEasingStandard
            autoTransition0.O(new z());  // 初始化器: Landroidx/transition/Transition;-><init>()V
        }
        this.b = new a(this, 4);
        this.setImportantForAccessibility(1);
    }

    @Override  // k.y
    public final void a(MenuBuilder menuBuilder0) {
        this.d0 = menuBuilder0;
    }

    public final void b() {
        this.removeAllViews();
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                NavigationBarItemView navigationBarItemView0 = arr_navigationBarItemView[v];
                if(navigationBarItemView0 != null) {
                    this.c.release(navigationBarItemView0);
                    ImageView imageView0 = navigationBarItemView0.n;
                    if(navigationBarItemView0.e0 != null) {
                        if(imageView0 != null) {
                            navigationBarItemView0.setClipChildren(true);
                            navigationBarItemView0.setClipToPadding(true);
                            f6.a a0 = navigationBarItemView0.e0;
                            if(a0 != null) {
                                if(a0.d() == null) {
                                    imageView0.getOverlay().remove(a0);
                                }
                                else {
                                    a0.d().setForeground(null);
                                }
                            }
                        }
                        navigationBarItemView0.e0 = null;
                    }
                    navigationBarItemView0.E = null;
                    navigationBarItemView0.T = 0.0f;
                    navigationBarItemView0.a = false;
                }
            }
        }
        if(this.d0.f.size() == 0) {
            this.g = 0;
            this.h = 0;
            this.f = null;
            return;
        }
        HashSet hashSet0 = new HashSet();
        for(int v1 = 0; v1 < this.d0.f.size(); ++v1) {
            hashSet0.add(this.d0.getItem(v1).getItemId());
        }
        for(int v2 = 0; true; ++v2) {
            SparseArray sparseArray0 = this.D;
            if(v2 >= sparseArray0.size()) {
                break;
            }
            int v3 = sparseArray0.keyAt(v2);
            if(!hashSet0.contains(v3)) {
                sparseArray0.delete(v3);
            }
        }
        this.f = new NavigationBarItemView[this.d0.f.size()];
        boolean z = NavigationBarMenuView.f(this.e, this.d0.l().size());
        for(int v4 = 0; v4 < this.d0.f.size(); ++v4) {
            this.c0.b = true;
            this.d0.getItem(v4).setCheckable(true);
            this.c0.b = false;
            NavigationBarItemView navigationBarItemView1 = this.getNewItem();
            this.f[v4] = navigationBarItemView1;
            navigationBarItemView1.setIconTintList(this.i);
            navigationBarItemView1.setIconSize(this.j);
            navigationBarItemView1.setTextColor(this.l);
            navigationBarItemView1.setTextAppearanceInactive(this.m);
            navigationBarItemView1.setTextAppearanceActive(this.n);
            navigationBarItemView1.setTextAppearanceActiveBoldEnabled(this.o);
            navigationBarItemView1.setTextColor(this.k);
            int v5 = this.E;
            if(v5 != -1) {
                navigationBarItemView1.setItemPaddingTop(v5);
            }
            int v6 = this.G;
            if(v6 != -1) {
                navigationBarItemView1.setItemPaddingBottom(v6);
            }
            int v7 = this.I;
            if(v7 != -1) {
                navigationBarItemView1.setActiveIndicatorLabelPadding(v7);
            }
            navigationBarItemView1.setActiveIndicatorWidth(this.N);
            navigationBarItemView1.setActiveIndicatorHeight(this.S);
            navigationBarItemView1.setActiveIndicatorMarginHorizontal(this.T);
            navigationBarItemView1.setActiveIndicatorDrawable(this.d());
            navigationBarItemView1.setActiveIndicatorResizeable(this.W);
            navigationBarItemView1.setActiveIndicatorEnabled(this.M);
            Drawable drawable0 = this.r;
            if(drawable0 == null) {
                navigationBarItemView1.setItemBackground(this.B);
            }
            else {
                navigationBarItemView1.setItemBackground(drawable0);
            }
            navigationBarItemView1.setItemRippleColor(this.w);
            navigationBarItemView1.setShifting(z);
            navigationBarItemView1.setLabelVisibilityMode(this.e);
            m m0 = (m)this.d0.getItem(v4);
            navigationBarItemView1.c(m0);
            navigationBarItemView1.setItemPosition(v4);
            navigationBarItemView1.setOnTouchListener(((View.OnTouchListener)this.d.get(m0.a)));
            navigationBarItemView1.setOnClickListener(this.b);
            if(this.g != 0 && m0.a == this.g) {
                this.h = v4;
            }
            this.setBadgeIfNeeded(navigationBarItemView1);
            this.addView(navigationBarItemView1);
        }
        int v8 = Math.min(this.d0.f.size() - 1, this.h);
        this.h = v8;
        this.d0.getItem(v8).setChecked(true);
    }

    public final ColorStateList c() {
        TypedValue typedValue0 = new TypedValue();
        if(this.getContext().getTheme().resolveAttribute(0x1010038, typedValue0, true)) {
            ColorStateList colorStateList0 = c.getColorStateList(this.getContext(), typedValue0.resourceId);
            if(this.getContext().getTheme().resolveAttribute(0x7F040182, typedValue0, true)) {  // attr:colorPrimary
                int v = typedValue0.data;
                int v1 = colorStateList0.getDefaultColor();
                return new ColorStateList(new int[][]{NavigationBarMenuView.f0, NavigationBarMenuView.e0, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList0.getColorForState(NavigationBarMenuView.f0, v1), v, v1});
            }
        }
        return null;
    }

    public final i d() {
        if(this.V != null && this.b0 != null) {
            i i0 = new i(this.V);
            i0.m(this.b0);
            return i0;
        }
        return null;
    }

    public abstract NavigationBarItemView e(Context arg1);

    public static boolean f(int v, int v1) {
        switch(v) {
            case -1: {
                return v1 > 3;
            }
            case 0: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public int getActiveIndicatorLabelPadding() {
        return this.I;
    }

    public SparseArray getBadgeDrawables() {
        return this.D;
    }

    public ColorStateList getIconTintList() {
        return this.i;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.b0;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.M;
    }

    public int getItemActiveIndicatorHeight() {
        return this.S;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.T;
    }

    public o getItemActiveIndicatorShapeAppearance() {
        return this.V;
    }

    public int getItemActiveIndicatorWidth() {
        return this.N;
    }

    public Drawable getItemBackground() {
        return this.f == null || this.f.length <= 0 ? this.r : this.f[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.B;
    }

    public int getItemIconSize() {
        return this.j;
    }

    public int getItemPaddingBottom() {
        return this.G;
    }

    public int getItemPaddingTop() {
        return this.E;
    }

    public ColorStateList getItemRippleColor() {
        return this.w;
    }

    public int getItemTextAppearanceActive() {
        return this.n;
    }

    public int getItemTextAppearanceInactive() {
        return this.m;
    }

    public ColorStateList getItemTextColor() {
        return this.k;
    }

    public int getLabelVisibilityMode() {
        return this.e;
    }

    public MenuBuilder getMenu() {
        return this.d0;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView0 = (NavigationBarItemView)this.c.acquire();
        return navigationBarItemView0 == null ? this.e(this.getContext()) : navigationBarItemView0;
    }

    public int getSelectedItemId() {
        return this.g;
    }

    public int getSelectedItemPosition() {
        return this.h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setCollectionInfo(((AccessibilityNodeInfo.CollectionInfo)B6.f.d(1, this.d0.l().size(), 1, false).a));
    }

    public void setActiveIndicatorLabelPadding(int v) {
        this.I = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setActiveIndicatorLabelPadding(v);
            }
        }
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView0) {
        int v = navigationBarItemView0.getId();
        if(v != -1) {
            f6.a a0 = (f6.a)this.D.get(v);
            if(a0 != null) {
                navigationBarItemView0.setBadge(a0);
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList0) {
        this.i = colorStateList0;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setIconTintList(colorStateList0);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList0) {
        this.b0 = colorStateList0;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setActiveIndicatorDrawable(this.d());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.M = z;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setActiveIndicatorEnabled(z);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int v) {
        this.S = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setActiveIndicatorHeight(v);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int v) {
        this.T = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setActiveIndicatorMarginHorizontal(v);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z) {
        this.W = z;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setActiveIndicatorResizeable(z);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(o o0) {
        this.V = o0;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setActiveIndicatorDrawable(this.d());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int v) {
        this.N = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setActiveIndicatorWidth(v);
            }
        }
    }

    public void setItemBackground(Drawable drawable0) {
        this.r = drawable0;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setItemBackground(drawable0);
            }
        }
    }

    public void setItemBackgroundRes(int v) {
        this.B = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setItemBackground(v);
            }
        }
    }

    public void setItemIconSize(int v) {
        this.j = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setIconSize(v);
            }
        }
    }

    public void setItemPaddingBottom(int v) {
        this.G = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setItemPaddingBottom(v);
            }
        }
    }

    public void setItemPaddingTop(int v) {
        this.E = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                arr_navigationBarItemView[v1].setItemPaddingTop(v);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList0) {
        this.w = colorStateList0;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setItemRippleColor(colorStateList0);
            }
        }
    }

    public void setItemTextAppearanceActive(int v) {
        this.n = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                NavigationBarItemView navigationBarItemView0 = arr_navigationBarItemView[v1];
                navigationBarItemView0.setTextAppearanceActive(v);
                ColorStateList colorStateList0 = this.k;
                if(colorStateList0 != null) {
                    navigationBarItemView0.setTextColor(colorStateList0);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.o = z;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setTextAppearanceActiveBoldEnabled(z);
            }
        }
    }

    public void setItemTextAppearanceInactive(int v) {
        this.m = v;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v1 = 0; v1 < arr_navigationBarItemView.length; ++v1) {
                NavigationBarItemView navigationBarItemView0 = arr_navigationBarItemView[v1];
                navigationBarItemView0.setTextAppearanceInactive(v);
                ColorStateList colorStateList0 = this.k;
                if(colorStateList0 != null) {
                    navigationBarItemView0.setTextColor(colorStateList0);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList0) {
        this.k = colorStateList0;
        NavigationBarItemView[] arr_navigationBarItemView = this.f;
        if(arr_navigationBarItemView != null) {
            for(int v = 0; v < arr_navigationBarItemView.length; ++v) {
                arr_navigationBarItemView[v].setTextColor(colorStateList0);
            }
        }
    }

    public void setLabelVisibilityMode(int v) {
        this.e = v;
    }

    public void setPresenter(g g0) {
        this.c0 = g0;
    }
}

