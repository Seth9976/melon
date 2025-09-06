package androidx.appcompat.widget;

import android.view.View;
import k.A;

public final class i extends r0 {
    public final int j;
    public final View k;

    public i(View view0, View view1, int v) {
        this.j = v;
        this.k = view0;
        super(view1);
    }

    @Override  // androidx.appcompat.widget.r0
    public final A b() {
        if(this.j != 0) {
            return ((ActivityChooserView)this.k).getListPopupWindow();
        }
        f f0 = ((j)this.k).a.E;
        return f0 == null ? null : f0.a();
    }

    @Override  // androidx.appcompat.widget.r0
    public final boolean c() {
        if(this.j != 0) {
            ActivityChooserView activityChooserView0 = (ActivityChooserView)this.k;
            if(!activityChooserView0.b() && activityChooserView0.r) {
                activityChooserView0.n = false;
                activityChooserView0.c(activityChooserView0.o);
            }
            return true;
        }
        ((j)this.k).a.o();
        return true;
    }

    @Override  // androidx.appcompat.widget.r0
    public final boolean d() {
        if(this.j != 0) {
            ((ActivityChooserView)this.k).a();
            return true;
        }
        ActionMenuPresenter actionMenuPresenter0 = ((j)this.k).a;
        if(actionMenuPresenter0.I != null) {
            return false;
        }
        actionMenuPresenter0.l();
        return true;
    }
}

