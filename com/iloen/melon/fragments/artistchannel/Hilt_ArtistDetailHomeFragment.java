package com.iloen.melon.fragments.artistchannel;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import h7.u0;
import me.i;
import org.jetbrains.annotations.NotNull;

public abstract class Hilt_ArtistDetailHomeFragment extends DetailSongMetaContentBaseFragment {
    private ContextWrapper componentContext;
    private boolean disableGetContextFix;
    private boolean injected;

    public Hilt_ArtistDetailHomeFragment() {
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

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public abstract i getCoroutineContext();

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
            ((ArtistDetailHomeFragment_GeneratedInjector)this.generatedComponent()).injectArtistDetailHomeFragment(((ArtistDetailHomeFragment)this));
        }
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.componentContext == null || ee.i.b(this.componentContext) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
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

