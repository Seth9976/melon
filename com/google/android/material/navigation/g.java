package com.google.android.material.navigation;

import N4.W;
import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.transition.AutoTransition;
import com.google.android.material.badge.BadgeState.State;
import com.google.android.material.internal.ParcelableSparseArray;
import f6.a;
import k.C;
import k.m;
import k.w;

public final class g implements w {
    public NavigationBarMenuView a;
    public boolean b;
    public int c;

    @Override  // k.w
    public final void b(MenuBuilder menuBuilder0, boolean z) {
    }

    @Override  // k.w
    public final boolean c(m m0) {
        return false;
    }

    @Override  // k.w
    public final void d(Parcelable parcelable0) {
        if(parcelable0 instanceof NavigationBarPresenter.SavedState) {
            NavigationBarMenuView navigationBarMenuView0 = this.a;
            int v = ((NavigationBarPresenter.SavedState)parcelable0).a;
            int v1 = navigationBarMenuView0.d0.f.size();
            for(int v3 = 0; v3 < v1; ++v3) {
                MenuItem menuItem0 = navigationBarMenuView0.d0.getItem(v3);
                if(v == menuItem0.getItemId()) {
                    navigationBarMenuView0.g = v;
                    navigationBarMenuView0.h = v3;
                    menuItem0.setChecked(true);
                    break;
                }
            }
            Context context0 = this.a.getContext();
            ParcelableSparseArray parcelableSparseArray0 = ((NavigationBarPresenter.SavedState)parcelable0).b;
            SparseArray sparseArray0 = new SparseArray(parcelableSparseArray0.size());
            for(int v4 = 0; v4 < parcelableSparseArray0.size(); ++v4) {
                int v5 = parcelableSparseArray0.keyAt(v4);
                BadgeState.State badgeState$State0 = (BadgeState.State)parcelableSparseArray0.valueAt(v4);
                sparseArray0.put(v5, (badgeState$State0 == null ? null : new a(context0, badgeState$State0)));
            }
            NavigationBarMenuView navigationBarMenuView1 = this.a;
            SparseArray sparseArray1 = navigationBarMenuView1.D;
            for(int v6 = 0; v6 < sparseArray0.size(); ++v6) {
                int v7 = sparseArray0.keyAt(v6);
                if(sparseArray1.indexOfKey(v7) < 0) {
                    sparseArray1.append(v7, ((a)sparseArray0.get(v7)));
                }
            }
            NavigationBarItemView[] arr_navigationBarItemView = navigationBarMenuView1.f;
            if(arr_navigationBarItemView != null) {
                for(int v2 = 0; v2 < arr_navigationBarItemView.length; ++v2) {
                    NavigationBarItemView navigationBarItemView0 = arr_navigationBarItemView[v2];
                    a a0 = (a)sparseArray1.get(navigationBarItemView0.getId());
                    if(a0 != null) {
                        navigationBarItemView0.setBadge(a0);
                    }
                }
            }
        }
    }

    @Override  // k.w
    public final Parcelable e() {
        Parcelable parcelable0 = new NavigationBarPresenter.SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        parcelable0.a = this.a.getSelectedItemId();
        SparseArray sparseArray0 = this.a.getBadgeDrawables();
        ParcelableSparseArray parcelableSparseArray0 = new ParcelableSparseArray();  // 初始化器: Landroid/util/SparseArray;-><init>()V
        for(int v = 0; v < sparseArray0.size(); ++v) {
            int v1 = sparseArray0.keyAt(v);
            a a0 = (a)sparseArray0.valueAt(v);
            parcelableSparseArray0.put(v1, (a0 == null ? null : a0.e.a));
        }
        parcelable0.b = parcelableSparseArray0;
        return parcelable0;
    }

    @Override  // k.w
    public final boolean f(m m0) {
        return false;
    }

    @Override  // k.w
    public final boolean g(C c0) {
        return false;
    }

    @Override  // k.w
    public final int getId() {
        return this.c;
    }

    @Override  // k.w
    public final void i(boolean z) {
        if(!this.b) {
            if(z) {
                this.a.b();
                return;
            }
            NavigationBarMenuView navigationBarMenuView0 = this.a;
            MenuBuilder menuBuilder0 = navigationBarMenuView0.d0;
            if(menuBuilder0 != null && navigationBarMenuView0.f != null) {
                int v = menuBuilder0.f.size();
                if(v != navigationBarMenuView0.f.length) {
                    navigationBarMenuView0.b();
                    return;
                }
                int v1 = navigationBarMenuView0.g;
                for(int v2 = 0; v2 < v; ++v2) {
                    MenuItem menuItem0 = navigationBarMenuView0.d0.getItem(v2);
                    if(menuItem0.isChecked()) {
                        navigationBarMenuView0.g = menuItem0.getItemId();
                        navigationBarMenuView0.h = v2;
                    }
                }
                if(v1 != navigationBarMenuView0.g) {
                    AutoTransition autoTransition0 = navigationBarMenuView0.a;
                    if(autoTransition0 != null) {
                        W.a(navigationBarMenuView0, autoTransition0);
                    }
                }
                boolean z1 = NavigationBarMenuView.f(navigationBarMenuView0.e, navigationBarMenuView0.d0.l().size());
                for(int v3 = 0; v3 < v; ++v3) {
                    navigationBarMenuView0.c0.b = true;
                    navigationBarMenuView0.f[v3].setLabelVisibilityMode(navigationBarMenuView0.e);
                    navigationBarMenuView0.f[v3].setShifting(z1);
                    navigationBarMenuView0.f[v3].c(((m)navigationBarMenuView0.d0.getItem(v3)));
                    navigationBarMenuView0.c0.b = false;
                }
            }
        }
    }

    @Override  // k.w
    public final boolean j() {
        return false;
    }

    @Override  // k.w
    public final void k(Context context0, MenuBuilder menuBuilder0) {
        this.a.d0 = menuBuilder0;
    }
}

