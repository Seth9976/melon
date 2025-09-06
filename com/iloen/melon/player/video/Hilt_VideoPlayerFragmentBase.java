package com.iloen.melon.player.video;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import d5.n;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import ee.i;
import h7.u0;

public abstract class Hilt_VideoPlayerFragmentBase extends MetaContentBaseFragment {
    public ViewComponentManager.FragmentContextWrapper a;
    public boolean b;
    public boolean c;

    public Hilt_VideoPlayerFragmentBase() {
        this.c = false;
    }

    public final void d0() {
        if(this.a == null) {
            this.a = new ViewComponentManager.FragmentContextWrapper(super.getContext(), this);
            this.b = u0.I(super.getContext());
        }
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public Context getContext() {
        if(super.getContext() == null && !this.b) {
            return null;
        }
        this.d0();
        return this.a;
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public void inject() {
        if(!this.c) {
            this.c = true;
            ((VideoPlayerFragmentBase_GeneratedInjector)this.generatedComponent()).injectVideoPlayerFragmentBase(((VideoPlayerFragmentBase)this));
        }
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public void onAttach(Activity activity0) {
        super.onAttach(activity0);
        n.n(this.a == null || i.b(this.a) == activity0, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        this.d0();
        this.inject();
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public void onAttach(Context context0) {
        super.onAttach(context0);
        this.d0();
        this.inject();
    }

    @Override  // com.iloen.melon.fragments.Hilt_MelonBaseFragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle0) {
        LayoutInflater layoutInflater0 = super.onGetLayoutInflater(bundle0);
        return layoutInflater0.cloneInContext(new ViewComponentManager.FragmentContextWrapper(layoutInflater0, this));
    }
}

