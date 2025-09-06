package com.iloen.melon.player.playlist.music;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;

public abstract class Hilt_SmartPlaylistFragment extends MusicPlaylistBaseFragment {
    public ViewComponentManager.FragmentContextWrapper k;
    public boolean l;
    public boolean m;

    public Hilt_SmartPlaylistFragment() {
        this.m = false;
    }

    @Override  // com.melon.ui.p1
    public Context getContext() {
        if(super.getContext() == null && !this.l) {
            return null;
        }
        this.m();
        return this.k;
    }

    @Override  // com.melon.ui.p1
    public void inject() {
        if(!this.m) {
            this.m = true;
            ((SmartPlaylistFragment_GeneratedInjector)this.generatedComponent()).injectSmartPlaylistFragment(((SmartPlaylistFragment)this));
        }
    }

    public final void m() {
        if(this.k == null) {
            this.k = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.l = u0.I(super.getContext());
        }
    }

    @Override  // com.melon.ui.p1
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.k == null || i.b(this.k) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
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

