package k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

public class C extends MenuBuilder implements SubMenu {
    public final m A;
    public final MenuBuilder z;

    public C(Context context0, MenuBuilder menuBuilder0, m m0) {
        super(context0);
        this.z = menuBuilder0;
        this.A = m0;
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final boolean d(m m0) {
        return this.z.d(m0);
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final boolean e(MenuBuilder menuBuilder0, MenuItem menuItem0) {
        return super.e(menuBuilder0, menuItem0) || this.z.e(menuBuilder0, menuItem0);
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final boolean f(m m0) {
        return this.z.f(m0);
    }

    @Override  // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final String j() {
        int v = this.A == null ? 0 : this.A.a;
        return v == 0 ? null : "android:menu:actionviewstates:" + v;
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final MenuBuilder k() {
        return this.z.k();
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final boolean m() {
        return this.z.m();
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final boolean n() {
        return this.z.n();
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder
    public final boolean o() {
        return this.z.o();
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.z.setGroupDividerEnabled(z);
    }

    @Override  // android.view.SubMenu
    public final SubMenu setHeaderIcon(int v) {
        this.w(0, null, v, null, null);
        return this;
    }

    @Override  // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable0) {
        this.w(0, null, 0, drawable0, null);
        return this;
    }

    @Override  // android.view.SubMenu
    public final SubMenu setHeaderTitle(int v) {
        this.w(v, null, 0, null, null);
        return this;
    }

    @Override  // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence0) {
        this.w(0, charSequence0, 0, null, null);
        return this;
    }

    @Override  // android.view.SubMenu
    public final SubMenu setHeaderView(View view0) {
        this.w(0, null, 0, null, view0);
        return this;
    }

    @Override  // android.view.SubMenu
    public final SubMenu setIcon(int v) {
        this.A.setIcon(v);
        return this;
    }

    @Override  // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable0) {
        this.A.setIcon(drawable0);
        return this;
    }

    @Override  // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.z.setQwertyMode(z);
    }
}

