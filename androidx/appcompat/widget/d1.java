package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.app.J;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.a0;
import c2.p;
import k.j;

public final class d1 implements n, j {
    public final Toolbar a;

    public d1(Toolbar toolbar0) {
        this.a = toolbar0;
        super();
    }

    @Override  // k.j
    public boolean c(MenuBuilder menuBuilder0, MenuItem menuItem0) {
        return false;
    }

    @Override  // k.j
    public void j(MenuBuilder menuBuilder0) {
        Toolbar toolbar0 = this.a;
        ActionMenuPresenter actionMenuPresenter0 = toolbar0.a.E;
        if(actionMenuPresenter0 == null || !actionMenuPresenter0.m()) {
            for(Object object0: toolbar0.f0.b) {
                ((a0)(((p)object0))).a.t(menuBuilder0);
            }
        }
        J j0 = toolbar0.n0;
        if(j0 != null) {
            j0.j(menuBuilder0);
        }
    }
}

