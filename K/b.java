package k;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.r0;

public final class b extends r0 {
    public final ActionMenuItemView j;

    public b(ActionMenuItemView actionMenuItemView0) {
        this.j = actionMenuItemView0;
        super(actionMenuItemView0);
    }

    @Override  // androidx.appcompat.widget.r0
    public final A b() {
        c c0 = this.j.m;
        return c0 != null ? c0.a() : null;
    }

    @Override  // androidx.appcompat.widget.r0
    public final boolean c() {
        k k0 = this.j.k;
        if(k0 != null && k0.b(this.j.h)) {
            A a0 = this.b();
            return a0 != null && a0.a();
        }
        return false;
    }
}

