package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import k.j;

public final class h implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public h(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            int v = ((View)this.b).getLeft();
            int v1 = ((ScrollingTabContainerView)this.c).getWidth();
            int v2 = ((View)this.b).getWidth();
            ((ScrollingTabContainerView)this.c).smoothScrollTo(v - (v1 - v2) / 2, 0);
            ((ScrollingTabContainerView)this.c).a = null;
            return;
        }
        f f0 = (f)this.b;
        ActionMenuPresenter actionMenuPresenter0 = (ActionMenuPresenter)this.c;
        MenuBuilder menuBuilder0 = actionMenuPresenter0.c;
        if(menuBuilder0 != null) {
            j j0 = menuBuilder0.e;
            if(j0 != null) {
                j0.j(menuBuilder0);
            }
        }
        View view0 = (View)actionMenuPresenter0.h;
        if(view0 != null && view0.getWindowToken() != null) {
            if(f0.b()) {
                actionMenuPresenter0.E = f0;
            }
            else if(f0.e != null) {
                f0.d(0, 0, false, false);
                actionMenuPresenter0.E = f0;
            }
        }
        actionMenuPresenter0.I = null;
    }
}

