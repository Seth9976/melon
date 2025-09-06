package com.iloen.melon.fragments.detail;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;

public abstract class Hilt_MixPlaylistDetailFragment extends PlaylistDetailBaseFragment {
    private ContextWrapper componentContext;
    private boolean disableGetContextFix;
    private boolean injected;

    public Hilt_MixPlaylistDetailFragment() {
        this.injected = false;
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public Context getContext() {
        if(super.getContext() == null && !this.disableGetContextFix) {
            return null;
        }
        this.initializeComponentContext();
        return this.componentContext;
    }

    private void initializeComponentContext() {
        if(this.componentContext == null) {
            this.componentContext = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.disableGetContextFix = u0.I(super.getContext());
        }
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public void inject() {
        if(!this.injected) {
            this.injected = true;
            ((MixPlaylistDetailFragment_GeneratedInjector)this.generatedComponent()).injectMixPlaylistDetailFragment(((MixPlaylistDetailFragment)this));
        }
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.componentContext == null || i.b(this.componentContext) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.initializeComponentContext();
        this.inject();
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public void onAttach(Context context0) {
        super.onAttach(context0);
        this.initializeComponentContext();
        this.inject();
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

