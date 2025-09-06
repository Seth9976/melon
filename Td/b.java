package td;

import Cc.x2;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.melon.ui.J0;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;
import k8.a;
import k8.h;

public abstract class b extends J0 {
    public ViewComponentManager.FragmentContextWrapper a;
    public boolean b;
    public boolean c;

    public b() {
        this.c = false;
    }

    @Override  // com.melon.ui.p1
    public final Context getContext() {
        if(super.getContext() == null && !this.b) {
            return null;
        }
        this.m();
        return this.a;
    }

    @Override  // com.melon.ui.p1
    public final void inject() {
        if(!this.c) {
            this.c = true;
            c0 c00 = (c0)this.generatedComponent();
            ((b0)this).downloadHelper = ((h)c00).a();
            ((b0)this).i = (x2)((h)c00).b.E0.get();
            ((b0)this).j = ((h)c00).b.j();
            a a0 = (a)((h)c00).b.l.get();
        }
    }

    public final void m() {
        if(this.a == null) {
            this.a = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.b = u0.I(super.getContext());
        }
    }

    @Override  // com.melon.ui.p1
    public final void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.a == null || i.b(this.a) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.m();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public final void onAttach(Context context0) {
        super.onAttach(context0);
        this.m();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public final LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

