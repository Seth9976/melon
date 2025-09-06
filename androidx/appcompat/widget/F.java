package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import k.C;
import k.s;
import k.u;

public final class f extends u {
    public final int l;
    public final ActionMenuPresenter m;

    public f(ActionMenuPresenter actionMenuPresenter0, Context context0, MenuBuilder menuBuilder0, View view0) {
        this.l = 1;
        this.m = actionMenuPresenter0;
        super(context0, menuBuilder0, view0, true, 0x7F04002C, 0);  // attr:actionOverflowMenuStyle
        this.f = 0x800005;
        k k0 = actionMenuPresenter0.N;
        this.h = k0;
        s s0 = this.i;
        if(s0 != null) {
            s0.h(k0);
        }
    }

    public f(ActionMenuPresenter actionMenuPresenter0, Context context0, C c0, View view0) {
        this.l = 0;
        this.m = actionMenuPresenter0;
        super(context0, c0, view0, false, 0x7F04002C, 0);  // attr:actionOverflowMenuStyle
        if((c0.A.x & 0x20) != 0x20) {
            View view1 = actionMenuPresenter0.j;
            if(view1 == null) {
                view1 = (View)actionMenuPresenter0.h;
            }
            this.e = view1;
        }
        k k0 = actionMenuPresenter0.N;
        this.h = k0;
        s s0 = this.i;
        if(s0 != null) {
            s0.h(k0);
        }
    }

    @Override  // k.u
    public final void c() {
        if(this.l != 0) {
            ActionMenuPresenter actionMenuPresenter0 = this.m;
            MenuBuilder menuBuilder0 = actionMenuPresenter0.c;
            if(menuBuilder0 != null) {
                menuBuilder0.c(true);
            }
            actionMenuPresenter0.E = null;
            super.c();
            return;
        }
        this.m.G = null;
        this.m.S = 0;
        super.c();
    }
}

