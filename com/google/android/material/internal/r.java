package com.google.android.material.internal;

import E8.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.ArrayList;
import k.C;
import k.m;
import k.w;

public final class r implements w {
    public int B;
    public int D;
    public int E;
    public int G;
    public int I;
    public boolean M;
    public boolean N;
    public int S;
    public int T;
    public int V;
    public int W;
    public final a X;
    public NavigationMenuView a;
    public LinearLayout b;
    public MenuBuilder c;
    public int d;
    public j e;
    public LayoutInflater f;
    public int g;
    public ColorStateList h;
    public int i;
    public boolean j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public RippleDrawable n;
    public int o;
    public int r;
    public int w;

    public r() {
        this.g = 0;
        this.i = 0;
        this.j = true;
        this.N = true;
        this.W = -1;
        this.X = new a(this, 3);
    }

    @Override  // k.w
    public final void b(MenuBuilder menuBuilder0, boolean z) {
    }

    @Override  // k.w
    public final boolean c(m m0) {
        return false;
    }

    @Override  // k.w
    public final void d(Parcelable parcelable0) {
        if(parcelable0 instanceof Bundle) {
            SparseArray sparseArray0 = ((Bundle)parcelable0).getSparseParcelableArray("android:menu:list");
            if(sparseArray0 != null) {
                this.a.restoreHierarchyState(sparseArray0);
            }
            Bundle bundle0 = ((Bundle)parcelable0).getBundle("android:menu:adapter");
            if(bundle0 != null) {
                j j0 = this.e;
                ArrayList arrayList0 = j0.a;
                int v1 = bundle0.getInt("android:menu:checked", 0);
                if(v1 != 0) {
                    j0.c = true;
                    int v2 = arrayList0.size();
                    for(int v3 = 0; v3 < v2; ++v3) {
                        l l0 = (l)arrayList0.get(v3);
                        if(l0 instanceof n) {
                            m m0 = ((n)l0).a;
                            if(m0.a == v1) {
                                j0.b(m0);
                                break;
                            }
                        }
                    }
                    j0.c = false;
                    j0.a();
                }
                SparseArray sparseArray1 = bundle0.getSparseParcelableArray("android:menu:action_views");
                if(sparseArray1 != null) {
                    int v4 = arrayList0.size();
                    for(int v = 0; v < v4; ++v) {
                        l l1 = (l)arrayList0.get(v);
                        if(l1 instanceof n) {
                            m m1 = ((n)l1).a;
                            View view0 = m1.getActionView();
                            if(view0 != null) {
                                ParcelableSparseArray parcelableSparseArray0 = (ParcelableSparseArray)sparseArray1.get(m1.a);
                                if(parcelableSparseArray0 != null) {
                                    view0.restoreHierarchyState(parcelableSparseArray0);
                                }
                            }
                        }
                    }
                }
            }
            SparseArray sparseArray2 = ((Bundle)parcelable0).getSparseParcelableArray("android:menu:header");
            if(sparseArray2 != null) {
                this.b.restoreHierarchyState(sparseArray2);
            }
        }
    }

    @Override  // k.w
    public final Parcelable e() {
        Parcelable parcelable0 = new Bundle();
        if(this.a != null) {
            SparseArray sparseArray0 = new SparseArray();
            this.a.saveHierarchyState(sparseArray0);
            ((Bundle)parcelable0).putSparseParcelableArray("android:menu:list", sparseArray0);
        }
        j j0 = this.e;
        if(j0 != null) {
            ArrayList arrayList0 = j0.a;
            Bundle bundle0 = new Bundle();
            m m0 = j0.b;
            if(m0 != null) {
                bundle0.putInt("android:menu:checked", m0.a);
            }
            SparseArray sparseArray1 = new SparseArray();
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                l l0 = (l)arrayList0.get(v1);
                if(l0 instanceof n) {
                    m m1 = ((n)l0).a;
                    View view0 = m1 == null ? null : m1.getActionView();
                    if(view0 != null) {
                        ParcelableSparseArray parcelableSparseArray0 = new ParcelableSparseArray();  // 初始化器: Landroid/util/SparseArray;-><init>()V
                        view0.saveHierarchyState(parcelableSparseArray0);
                        sparseArray1.put(m1.a, parcelableSparseArray0);
                    }
                }
            }
            bundle0.putSparseParcelableArray("android:menu:action_views", sparseArray1);
            ((Bundle)parcelable0).putBundle("android:menu:adapter", bundle0);
        }
        if(this.b != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.b.saveHierarchyState(sparseArray2);
            ((Bundle)parcelable0).putSparseParcelableArray("android:menu:header", sparseArray2);
        }
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
        return this.d;
    }

    @Override  // k.w
    public final void i(boolean z) {
        j j0 = this.e;
        if(j0 != null) {
            j0.a();
            j0.notifyDataSetChanged();
        }
    }

    @Override  // k.w
    public final boolean j() {
        return false;
    }

    @Override  // k.w
    public final void k(Context context0, MenuBuilder menuBuilder0) {
        this.f = LayoutInflater.from(context0);
        this.c = menuBuilder0;
        this.V = context0.getResources().getDimensionPixelOffset(0x7F0700D2);  // dimen:design_navigation_separator_vertical_padding
    }
}

