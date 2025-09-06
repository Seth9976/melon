package k;

import android.content.Context;
import android.view.ActionProvider.VisibilityListener;
import android.view.View;
import androidx.core.view.ActionProvider;
import i.n.i.b.a.s.e.Ga;

public final class n extends ActionProvider implements ActionProvider.VisibilityListener {
    public Ga d;
    public final android.view.ActionProvider e;

    public n(r r0, Context context0, android.view.ActionProvider actionProvider0) {
        super(context0);
        this.e = actionProvider0;
    }

    @Override  // androidx.core.view.ActionProvider
    public final boolean a() {
        return this.e.hasSubMenu();
    }

    @Override  // androidx.core.view.ActionProvider
    public final boolean b() {
        return this.e.isVisible();
    }

    @Override  // androidx.core.view.ActionProvider
    public final View c() {
        return this.e.onCreateActionView();
    }

    @Override  // androidx.core.view.ActionProvider
    public final View d(m m0) {
        return this.e.onCreateActionView(m0);
    }

    @Override  // androidx.core.view.ActionProvider
    public final boolean e() {
        return this.e.onPerformDefaultAction();
    }

    @Override  // androidx.core.view.ActionProvider
    public final void f(C c0) {
        this.e.onPrepareSubMenu(c0);
    }

    @Override  // androidx.core.view.ActionProvider
    public final boolean g() {
        return this.e.overridesItemVisibility();
    }

    @Override  // androidx.core.view.ActionProvider
    public final void h(Ga ga0) {
        this.d = ga0;
        this.e.setVisibilityListener(this);
    }

    @Override  // android.view.ActionProvider$VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        Ga ga0 = this.d;
        if(ga0 != null) {
            ((m)ga0.b).n.h = true;
            ((m)ga0.b).n.p(true);
        }
    }
}

