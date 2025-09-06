package com.google.android.material.navigation;

import U4.x;
import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.app.o;
import androidx.appcompat.view.menu.MenuBuilder;
import k.m;

public final class e extends MenuBuilder {
    public final int A;
    public final Class z;

    public e(Context context0, int v, Class class0) {
        super(context0);
        this.z = class0;
        this.A = v;
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final m a(int v, int v1, int v2, CharSequence charSequence0) {
        int v3 = this.A;
        if(this.f.size() + 1 <= v3) {
            this.y();
            m m0 = super.a(v, v1, v2, charSequence0);
            m0.f(true);
            this.x();
            return m0;
        }
        String s = this.z.getSimpleName();
        throw new IllegalArgumentException(x.m(o.u(v3, "Maximum number of items supported by ", s, " is ", ". Limit can be checked with "), s, "#getMaxItemCount()"));
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final SubMenu addSubMenu(int v, int v1, int v2, CharSequence charSequence0) {
        throw new UnsupportedOperationException(this.z.getSimpleName() + " does not support submenus");
    }
}

