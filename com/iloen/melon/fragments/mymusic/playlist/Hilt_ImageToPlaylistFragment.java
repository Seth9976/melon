package com.iloen.melon.fragments.mymusic.playlist;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.melon.ui.o1;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;

public abstract class Hilt_ImageToPlaylistFragment extends o1 {
    private ContextWrapper componentContext;
    private boolean disableGetContextFix;
    private boolean injected;

    public Hilt_ImageToPlaylistFragment() {
        this.injected = false;
    }

    @Override  // com.melon.ui.p1
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

    @Override  // com.melon.ui.p1
    public void inject() {
        if(!this.injected) {
            this.injected = true;
            ((ImageToPlaylistFragment_GeneratedInjector)this.generatedComponent()).injectImageToPlaylistFragment(((ImageToPlaylistFragment)this));
        }
    }

    @Override  // com.melon.ui.p1
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.componentContext == null || i.b(this.componentContext) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.initializeComponentContext();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public void onAttach(Context context0) {
        super.onAttach(context0);
        this.initializeComponentContext();
        this.inject();
    }

    @Override  // com.melon.ui.p1
    public LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

