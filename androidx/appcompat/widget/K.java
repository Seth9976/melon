package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.app.J;
import androidx.appcompat.view.menu.MenuBuilder;
import k.C;
import k.j;
import k.v;

public class k implements U, j, v {
    public final Object a;

    public k(Object object0) {
        this.a = object0;
        super();
    }

    @Override  // androidx.appcompat.widget.U
    public void a(int v) {
    }

    @Override  // k.v
    public void b(MenuBuilder menuBuilder0, boolean z) {
        if(menuBuilder0 instanceof C) {
            ((C)menuBuilder0).z.k().c(false);
        }
        v v0 = ((ActionMenuPresenter)this.a).e;
        if(v0 != null) {
            v0.b(menuBuilder0, z);
        }
    }

    @Override  // k.j
    public boolean c(MenuBuilder menuBuilder0, MenuItem menuItem0) {
        n n0 = ((ActionMenuView)this.a).V;
        if(n0 != null) {
            Toolbar toolbar0 = ((d1)n0).a;
            if(toolbar0.f0.a(menuItem0)) {
                return true;
            }
            return toolbar0.h0 == null ? false : ((J)toolbar0.h0).a.b.onMenuItemSelected(0, menuItem0);
        }
        return false;
    }

    @Override  // androidx.appcompat.widget.U
    public void d(int v, float f) {
    }

    @Override  // androidx.appcompat.widget.U
    public void e(int v) {
    }

    @Override  // k.j
    public void j(MenuBuilder menuBuilder0) {
        j j0 = ((ActionMenuView)this.a).I;
        if(j0 != null) {
            j0.j(menuBuilder0);
        }
    }

    @Override  // k.v
    public boolean m(MenuBuilder menuBuilder0) {
        ActionMenuPresenter actionMenuPresenter0 = (ActionMenuPresenter)this.a;
        if(menuBuilder0 == actionMenuPresenter0.c) {
            return false;
        }
        actionMenuPresenter0.S = ((C)menuBuilder0).A.a;
        return actionMenuPresenter0.e == null ? false : actionMenuPresenter0.e.m(menuBuilder0);
    }
}

