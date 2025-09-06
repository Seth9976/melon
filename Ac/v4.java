package Ac;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;
import k8.h;

public abstract class v4 extends N0 {
    public ViewComponentManager.FragmentContextWrapper c;
    public boolean d;
    public boolean e;

    public v4() {
        this.e = false;
    }

    @Override  // com.melon.ui.p1
    public final Context getContext() {
        if(super.getContext() == null && !this.d) {
            return null;
        }
        this.n();
        return this.c;
    }

    @Override  // com.melon.ui.p1
    public final void inject() {
        if(!this.e) {
            this.e = true;
            ((v2)this).downloadHelper = ((h)(((w2)this.generatedComponent()))).a();
        }
    }

    public final void n() {
        if(this.c == null) {
            this.c = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.d = u0.I(super.getContext());
        }
    }

    @Override  // com.melon.ui.p1
    public final void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.c == null || i.b(this.c) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.n();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public final void onAttach(Context context0) {
        super.onAttach(context0);
        this.n();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public final LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

