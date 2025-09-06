package com.iloen.melon.player.playlist.drawernew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.melon.ui.o1;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;

public abstract class Hilt_DrawerFragment extends o1 {
    public ViewComponentManager.FragmentContextWrapper a;
    public boolean b;
    public boolean c;

    public Hilt_DrawerFragment() {
        this.c = false;
    }

    @Override  // com.melon.ui.p1
    public Context getContext() {
        if(super.getContext() == null && !this.b) {
            return null;
        }
        this.m();
        return this.a;
    }

    @Override  // com.melon.ui.p1
    public void inject() {
        if(!this.c) {
            this.c = true;
            ((DrawerFragment_GeneratedInjector)this.generatedComponent()).injectDrawerFragment(((DrawerFragment)this));
        }
    }

    public final void m() {
        if(this.a == null) {
            this.a = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.b = u0.I(super.getContext());
        }
    }

    @Override  // com.melon.ui.p1
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.a == null || i.b(this.a) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.m();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public void onAttach(Context context0) {
        super.onAttach(context0);
        this.m();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

