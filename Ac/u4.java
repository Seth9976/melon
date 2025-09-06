package Ac;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.melon.ui.o1;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import k8.h;

public abstract class u4 extends o1 {
    public ViewComponentManager.FragmentContextWrapper a;
    public boolean b;
    public boolean c;

    public u4() {
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
            ((u0)this).downloadHelper = ((h)(((v0)this.generatedComponent()))).a();
        }
    }

    public final void m() {
        if(this.a == null) {
            this.a = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.b = h7.u0.I(super.getContext());
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

