package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import c2.W;
import java.util.ArrayList;
import k.C;
import k.m;

public final class j extends j0 {
    public final ArrayList a;
    public m b;
    public boolean c;
    public final r d;

    public j(r r0) {
        this.d = r0;
        super();
        this.a = new ArrayList();
        this.a();
    }

    public final void a() {
        if(this.c) {
            return;
        }
        this.c = true;
        ArrayList arrayList0 = this.a;
        arrayList0.clear();
        arrayList0.add(new k());  // 初始化器: Ljava/lang/Object;-><init>()V
        r r0 = this.d;
        int v = r0.c.l().size();
        int v1 = -1;
        boolean z = false;
        int v3 = 0;
        for(int v2 = 0; v2 < v; ++v2) {
            m m0 = (m)r0.c.l().get(v2);
            if(m0.isChecked()) {
                this.b(m0);
            }
            if(m0.isCheckable()) {
                m0.f(false);
            }
            if(m0.hasSubMenu()) {
                C c0 = m0.o;
                if(c0.hasVisibleItems()) {
                    if(v2 != 0) {
                        arrayList0.add(new com.google.android.material.internal.m(r0.V, 0));
                    }
                    arrayList0.add(new n(m0));
                    int v4 = arrayList0.size();
                    int v5 = c0.size();
                    boolean z1 = false;
                    for(int v6 = 0; v6 < v5; ++v6) {
                        m m1 = (m)c0.getItem(v6);
                        if(m1.isVisible()) {
                            if(!z1 && m1.getIcon() != null) {
                                z1 = true;
                            }
                            if(m1.isCheckable()) {
                                m1.f(false);
                            }
                            if(m0.isChecked()) {
                                this.b(m0);
                            }
                            arrayList0.add(new n(m1));
                        }
                    }
                    if(z1) {
                        int v7 = arrayList0.size();
                        while(v4 < v7) {
                            ((n)arrayList0.get(v4)).b = true;
                            ++v4;
                        }
                    }
                }
            }
            else {
                int v8 = m0.b;
                if(v8 != v1) {
                    v3 = arrayList0.size();
                    z = m0.getIcon() != null;
                    if(v2 != 0) {
                        ++v3;
                        arrayList0.add(new com.google.android.material.internal.m(r0.V, r0.V));
                    }
                }
                else if(!z && m0.getIcon() != null) {
                    int v9 = arrayList0.size();
                    for(int v10 = v3; v10 < v9; ++v10) {
                        ((n)arrayList0.get(v10)).b = true;
                    }
                    z = true;
                }
                n n0 = new n(m0);
                n0.b = z;
                arrayList0.add(n0);
                v1 = v8;
            }
        }
        this.c = false;
    }

    public final void b(m m0) {
        if(this.b != m0 && m0.isCheckable()) {
            m m1 = this.b;
            if(m1 != null) {
                m1.setChecked(false);
            }
            this.b = m0;
            m0.setChecked(true);
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        return this.a.size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final long getItemId(int v) {
        return (long)v;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemViewType(int v) {
        l l0 = (l)this.a.get(v);
        if(l0 instanceof com.google.android.material.internal.m) {
            return 2;
        }
        if(l0 instanceof k) {
            return 3;
        }
        if(!(l0 instanceof n)) {
            throw new RuntimeException("Unknown item type.");
        }
        return ((n)l0).a.hasSubMenu() ? 1 : 0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onBindViewHolder(O0 o00, int v) {
        int v1 = this.getItemViewType(v);
        ArrayList arrayList0 = this.a;
        r r0 = this.d;
        switch(v1) {
            case 0: {
                NavigationMenuItemView navigationMenuItemView0 = (NavigationMenuItemView)((q)o00).itemView;
                navigationMenuItemView0.setIconTintList(r0.l);
                navigationMenuItemView0.setTextAppearance(r0.i);
                ColorStateList colorStateList0 = r0.k;
                if(colorStateList0 != null) {
                    navigationMenuItemView0.setTextColor(colorStateList0);
                }
                navigationMenuItemView0.setBackground((r0.m == null ? null : r0.m.getConstantState().newDrawable()));
                RippleDrawable rippleDrawable0 = r0.n;
                if(rippleDrawable0 != null) {
                    navigationMenuItemView0.setForeground(rippleDrawable0.getConstantState().newDrawable());
                }
                n n0 = (n)arrayList0.get(v);
                navigationMenuItemView0.setNeedsEmptyIcon(n0.b);
                navigationMenuItemView0.setPadding(r0.o, r0.r, r0.o, r0.r);
                navigationMenuItemView0.setIconPadding(r0.w);
                if(r0.M) {
                    navigationMenuItemView0.setIconSize(r0.B);
                }
                navigationMenuItemView0.setMaxLines(r0.S);
                navigationMenuItemView0.S = r0.j;
                navigationMenuItemView0.c(n0.a);
                W.o(navigationMenuItemView0, new i(this, v, false));
                return;
            }
            case 1: {
                TextView textView0 = (TextView)((q)o00).itemView;
                textView0.setText(((n)arrayList0.get(v)).a.e);
                textView0.setTextAppearance(r0.g);
                textView0.setPadding(r0.G, textView0.getPaddingTop(), r0.I, textView0.getPaddingBottom());
                ColorStateList colorStateList1 = r0.h;
                if(colorStateList1 != null) {
                    textView0.setTextColor(colorStateList1);
                }
                W.o(textView0, new i(this, v, true));
                return;
            }
            case 2: {
                com.google.android.material.internal.m m0 = (com.google.android.material.internal.m)arrayList0.get(v);
                ((q)o00).itemView.setPadding(r0.D, m0.a, r0.E, m0.b);
            }
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        r r0 = this.d;
        switch(v) {
            case 0: {
                O0 o00 = new p(r0.f.inflate(0x7F0D01EF, viewGroup0, false));  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
                o00.itemView.setOnClickListener(r0.X);
                return o00;
            }
            case 1: {
                return new h(r0.f.inflate(0x7F0D01F2, viewGroup0, false));  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
            }
            case 2: {
                return new h(r0.f.inflate(0x7F0D01F1, viewGroup0, false));  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
            }
            case 3: {
                return new h(r0.b);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
            }
            default: {
                return null;
            }
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onViewRecycled(O0 o00) {
        if(((q)o00) instanceof p) {
            NavigationMenuItemView navigationMenuItemView0 = (NavigationMenuItemView)((q)o00).itemView;
            FrameLayout frameLayout0 = navigationMenuItemView0.V;
            if(frameLayout0 != null) {
                frameLayout0.removeAllViews();
            }
            navigationMenuItemView0.T.setCompoundDrawables(null, null, null, null);
        }
    }
}

