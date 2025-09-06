package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import k.C;
import k.m;

public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context context0) {
        super(context0);
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final SubMenu addSubMenu(int v, int v1, int v2, CharSequence charSequence0) {
        m m0 = this.a(v, v1, v2, charSequence0);
        C c0 = new s(this.a, this, m0);  // 初始化器: Lk/C;-><init>(Landroid/content/Context;Landroidx/appcompat/view/menu/MenuBuilder;Lk/m;)V
        m0.o = c0;
        c0.setHeaderTitle(m0.e);
        return c0;
    }
}

