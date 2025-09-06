package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ActionProvider;
import c2.c;
import java.util.ArrayList;
import k.C;
import k.d;
import k.m;
import k.s;
import k.v;
import k.x;
import k.y;

class ActionMenuPresenter extends d implements c {
    @SuppressLint({"BanParcelableUsage"})
    static class SavedState implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public int a;

        static {
            SavedState.CREATOR = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.a);
        }
    }

    public boolean B;
    public final SparseBooleanArray D;
    public f E;
    public f G;
    public h I;
    public g M;
    public final k N;
    public int S;
    public j j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int r;
    public int w;

    public ActionMenuPresenter(Context context0) {
        this.a = context0;
        this.d = LayoutInflater.from(context0);
        this.f = 0x7F0D0003;  // layout:abc_action_menu_layout
        this.g = 0x7F0D0002;  // layout:abc_action_menu_item_layout
        this.D = new SparseBooleanArray();
        this.N = new k(this);
    }

    public final View a(m m0, View view0, ViewGroup viewGroup0) {
        View view1 = m0.getActionView();
        int v = 0;
        if(view1 == null || m0.e()) {
            x x0 = view0 instanceof x ? ((x)view0) : ((x)this.d.inflate(this.g, viewGroup0, false));
            x0.c(m0);
            ((ActionMenuItemView)x0).setItemInvoker(((ActionMenuView)this.h));
            if(this.M == null) {
                this.M = new g(this);
            }
            ((ActionMenuItemView)x0).setPopupCallback(this.M);
            view1 = (View)x0;
        }
        if(m0.C) {
            v = 8;
        }
        view1.setVisibility(v);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
        ((ActionMenuView)viewGroup0).getClass();
        if(!(viewGroup$LayoutParams0 instanceof LayoutParams)) {
            view1.setLayoutParams(ActionMenuView.k(viewGroup$LayoutParams0));
        }
        return view1;
    }

    @Override  // k.w
    public final void b(MenuBuilder menuBuilder0, boolean z) {
        this.l();
        f f0 = this.G;
        if(f0 != null && f0.b()) {
            f0.i.dismiss();
        }
        v v0 = this.e;
        if(v0 != null) {
            v0.b(menuBuilder0, z);
        }
    }

    @Override  // k.w
    public final void d(Parcelable parcelable0) {
        if(parcelable0 instanceof SavedState) {
            int v = ((SavedState)parcelable0).a;
            if(v > 0) {
                MenuItem menuItem0 = this.c.findItem(v);
                if(menuItem0 != null) {
                    this.g(((C)menuItem0.getSubMenu()));
                }
            }
        }
    }

    @Override  // k.w
    public final Parcelable e() {
        Parcelable parcelable0 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        parcelable0.a = this.S;
        return parcelable0;
    }

    @Override  // k.w
    public final boolean g(C c0) {
        boolean z;
        if(c0.hasVisibleItems()) {
            C c1 = c0;
            MenuBuilder menuBuilder0;
            while((menuBuilder0 = c1.z) != this.c) {
                c1 = (C)menuBuilder0;
            }
            m m0 = c1.A;
            ViewGroup viewGroup0 = (ViewGroup)this.h;
            View view0 = null;
            if(viewGroup0 != null) {
                int v = viewGroup0.getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    View view1 = viewGroup0.getChildAt(v1);
                    if(view1 instanceof x && ((x)view1).getItemData() == m0) {
                        view0 = view1;
                        break;
                    }
                }
            }
            if(view0 != null) {
                this.S = c0.A.a;
                int v2 = c0.f.size();
                for(int v3 = 0; true; ++v3) {
                    z = false;
                    if(v3 >= v2) {
                        break;
                    }
                    MenuItem menuItem0 = c0.getItem(v3);
                    if(menuItem0.isVisible() && menuItem0.getIcon() != null) {
                        z = true;
                        break;
                    }
                }
                f f0 = new f(this, this.b, c0, view0);
                this.G = f0;
                f0.g = z;
                s s0 = f0.i;
                if(s0 != null) {
                    s0.p(z);
                }
                f f1 = this.G;
                if(!f1.b()) {
                    if(f1.e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    f1.d(0, 0, false, false);
                }
                v v4 = this.e;
                if(v4 != null) {
                    v4.m(c0);
                }
                return true;
            }
        }
        return false;
    }

    @Override  // k.w
    public final void i(boolean z) {
        int v3;
        ViewGroup viewGroup0 = (ViewGroup)this.h;
        ArrayList arrayList0 = null;
        int v = 0;
        if(viewGroup0 != null) {
            MenuBuilder menuBuilder0 = this.c;
            if(menuBuilder0 == null) {
                v3 = 0;
            }
            else {
                menuBuilder0.i();
                ArrayList arrayList1 = this.c.l();
                int v1 = arrayList1.size();
                v3 = 0;
                for(int v2 = 0; v2 < v1; ++v2) {
                    m m0 = (m)arrayList1.get(v2);
                    if((m0.x & 0x20) == 0x20) {
                        View view0 = viewGroup0.getChildAt(v3);
                        m m1 = view0 instanceof x ? ((x)view0).getItemData() : null;
                        View view1 = this.a(m0, view0, viewGroup0);
                        if(m0 != m1) {
                            view1.setPressed(false);
                            view1.jumpDrawablesToCurrentState();
                        }
                        if(view1 != view0) {
                            ViewGroup viewGroup1 = (ViewGroup)view1.getParent();
                            if(viewGroup1 != null) {
                                viewGroup1.removeView(view1);
                            }
                            ((ViewGroup)this.h).addView(view1, v3);
                        }
                        ++v3;
                    }
                }
            }
            while(v3 < viewGroup0.getChildCount()) {
                if(viewGroup0.getChildAt(v3) == this.j) {
                    ++v3;
                }
                else {
                    viewGroup0.removeViewAt(v3);
                }
            }
        }
        ((View)this.h).requestLayout();
        MenuBuilder menuBuilder1 = this.c;
        if(menuBuilder1 != null) {
            menuBuilder1.i();
            ArrayList arrayList2 = menuBuilder1.i;
            int v4 = arrayList2.size();
            for(int v5 = 0; v5 < v4; ++v5) {
                ActionProvider actionProvider0 = ((m)arrayList2.get(v5)).A;
                if(actionProvider0 != null) {
                    actionProvider0.b = this;
                }
            }
        }
        MenuBuilder menuBuilder2 = this.c;
        if(menuBuilder2 != null) {
            menuBuilder2.i();
            arrayList0 = menuBuilder2.j;
        }
        if(this.m && arrayList0 != null) {
            int v6 = arrayList0.size();
            if(v6 == 1) {
                v = !((m)arrayList0.get(0)).C;
            }
            else if(v6 > 0) {
                v = 1;
            }
        }
        if(v == 0) {
            j j1 = this.j;
            if(j1 != null) {
                ViewParent viewParent0 = j1.getParent();
                y y0 = this.h;
                if(viewParent0 == y0) {
                    ((ViewGroup)y0).removeView(this.j);
                }
            }
        }
        else {
            if(this.j == null) {
                this.j = new j(this, this.a);
            }
            ViewGroup viewGroup2 = (ViewGroup)this.j.getParent();
            if(viewGroup2 != this.h) {
                if(viewGroup2 != null) {
                    viewGroup2.removeView(this.j);
                }
                ActionMenuView actionMenuView0 = (ActionMenuView)this.h;
                j j0 = this.j;
                actionMenuView0.getClass();
                LayoutParams actionMenuView$LayoutParams0 = ActionMenuView.j();
                actionMenuView$LayoutParams0.a = true;
                actionMenuView0.addView(j0, actionMenuView$LayoutParams0);
            }
        }
        ((ActionMenuView)this.h).setOverflowReserved(this.m);
    }

    @Override  // k.w
    public final boolean j() {
        int v;
        ArrayList arrayList0;
        MenuBuilder menuBuilder0 = this.c;
        if(menuBuilder0 == null) {
            v = 0;
            arrayList0 = null;
        }
        else {
            arrayList0 = menuBuilder0.l();
            v = arrayList0.size();
        }
        int v1 = this.w;
        int v2 = this.r;
        ViewGroup viewGroup0 = (ViewGroup)this.h;
        boolean z = false;
        int v4 = 0;
        int v5 = 0;
        for(int v3 = 0; v3 < v; ++v3) {
            m m0 = (m)arrayList0.get(v3);
            int v6 = m0.y;
            if((v6 & 2) == 2) {
                ++v4;
            }
            else if((v6 & 1) == 1) {
                ++v5;
            }
            else {
                z = true;
            }
            if(this.B && m0.C) {
                v1 = 0;
            }
        }
        if(this.m && (z || v5 + v4 > v1)) {
            --v1;
        }
        int v7 = v1 - v4;
        SparseBooleanArray sparseBooleanArray0 = this.D;
        sparseBooleanArray0.clear();
        int v9 = 0;
        for(int v8 = 0; v8 < v; ++v8) {
            m m1 = (m)arrayList0.get(v8);
            int v10 = m1.y;
            int v11 = m1.b;
            if((v10 & 2) == 2) {
                View view0 = this.a(m1, null, viewGroup0);
                view0.measure(0, 0);
                int v12 = view0.getMeasuredWidth();
                v2 -= v12;
                if(v9 == 0) {
                    v9 = v12;
                }
                if(v11 != 0) {
                    sparseBooleanArray0.put(v11, true);
                }
                m1.g(true);
            }
            else if((v10 & 1) == 1) {
                boolean z1 = sparseBooleanArray0.get(v11);
                int v13 = v7 <= 0 && !z1 || v2 <= 0 ? 0 : 1;
                if(v13 != 0) {
                    View view1 = this.a(m1, null, viewGroup0);
                    view1.measure(0, 0);
                    int v14 = view1.getMeasuredWidth();
                    v2 -= v14;
                    if(v9 == 0) {
                        v9 = v14;
                    }
                    v13 &= (v2 + v9 <= 0 ? 0 : 1);
                }
                if(v13 != 0 && v11 != 0) {
                    sparseBooleanArray0.put(v11, true);
                }
                else if(z1) {
                    sparseBooleanArray0.put(v11, false);
                    for(int v15 = 0; v15 < v8; ++v15) {
                        m m2 = (m)arrayList0.get(v15);
                        if(m2.b == v11) {
                            if((m2.x & 0x20) == 0x20) {
                                ++v7;
                            }
                            m2.g(false);
                        }
                    }
                }
                if(v13 != 0) {
                    --v7;
                }
                m1.g(((boolean)v13));
            }
            else {
                m1.g(false);
            }
        }
        return true;
    }

    @Override  // k.w
    public final void k(Context context0, MenuBuilder menuBuilder0) {
        this.b = context0;
        LayoutInflater.from(context0);
        this.c = menuBuilder0;
        Resources resources0 = context0.getResources();
        Q5.k k0 = Q5.k.c(context0);
        if(!this.n) {
            this.m = true;
        }
        this.o = k0.a.getResources().getDisplayMetrics().widthPixels / 2;
        this.w = k0.d();
        int v = this.o;
        if(this.m) {
            if(this.j == null) {
                j j0 = new j(this, this.a);
                this.j = j0;
                if(this.l) {
                    j0.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                this.j.measure(0, 0);
            }
            v -= this.j.getMeasuredWidth();
        }
        else {
            this.j = null;
        }
        this.r = v;
        resources0.getDisplayMetrics();
    }

    public final boolean l() {
        h h0 = this.I;
        if(h0 != null) {
            y y0 = this.h;
            if(y0 != null) {
                ((View)y0).removeCallbacks(h0);
                this.I = null;
                return true;
            }
        }
        f f0 = this.E;
        if(f0 != null) {
            if(f0.b()) {
                f0.i.dismiss();
            }
            return true;
        }
        return false;
    }

    public final boolean m() {
        return this.E != null && this.E.b();
    }

    public final void n(boolean z) {
        if(z) {
            v v0 = this.e;
            if(v0 != null) {
                v0.m(this.c);
            }
            return;
        }
        MenuBuilder menuBuilder0 = this.c;
        if(menuBuilder0 != null) {
            menuBuilder0.c(false);
        }
    }

    public final boolean o() {
        if(this.m && !this.m()) {
            MenuBuilder menuBuilder0 = this.c;
            if(menuBuilder0 != null && this.h != null && this.I == null) {
                menuBuilder0.i();
                if(!menuBuilder0.j.isEmpty()) {
                    h h0 = new h(0, this, new f(this, this.b, this.c, this.j));
                    this.I = h0;
                    ((View)this.h).post(h0);
                    return true;
                }
            }
        }
        return false;
    }
}

